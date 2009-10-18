package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource.SearchDatasource;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.helper.DocumentToDoConvertor;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;

public class BookSearchDaoImpl implements BookSearchDao {
	private static Logger logger = Logger.getLogger(BookSearchDaoImpl.class);
	private SearchDatasource searchDatasource;

	public SearchDatasource getSearchDatasource() {
		return searchDatasource;
	}

	public void setSearchDatasource(SearchDatasource searchDatasource) {
		this.searchDatasource = searchDatasource;
	}

	@SuppressWarnings("unchecked")
	public void searchByQuery(BookSearchQueryObject bsQueryObj) {
		int number = bsQueryObj.getN() + bsQueryObj.getSkipResult();

		String primarySortKey = bsQueryObj.getPrimarySortFiled();
		Searcher searcher = searchDatasource.getSearcher();

		Query query = bsQueryObj.getQuery();

		long start = new Date().getTime();
		TopDocs docs = null;
		try {
			docs = searcher.search(query, null, number, new Sort(new SortField(
					primarySortKey, SortField.AUTO, bsQueryObj.isReverse())));

		} catch (IOException e) {
			logger.error(e);
			return;
		}

		long end = new Date().getTime();

		int numTotalHits = docs.scoreDocs.length;
		logger.info("[Search Result]" + numTotalHits
				+ " total matching documents. Time is " + (end - start) + "ms");

		DocumentToDoConvertor convertor = DocumentToDoConvertor.getConvertor(
				bsQueryObj.isHighlight(), query);

		List result = getResult(searcher, convertor, docs, bsQueryObj
				.getSkipResult(), bsQueryObj.getN());
		bsQueryObj.setResultList(result);
		bsQueryObj.setTotalCount(docs.totalHits);
	}

	protected List<BookSearch> getResult(Searcher searcher,
			DocumentToDoConvertor convertor, TopDocs topDocs, int skipResult,
			int n) {
		List<BookSearch> doList = new ArrayList<BookSearch>();
		ScoreDoc[] scoreDocList = topDocs.scoreDocs;
		if (skipResult >= topDocs.scoreDocs.length) {
			return doList;
		}
		int count = 0;
		for (ScoreDoc scoreDoc : scoreDocList) {
			count++;
			if (count < skipResult) {
				continue;
			}
			Document doc = null;
			try {
				doc = searcher.doc(scoreDoc.doc);
				doList.add(convertor.convertToBookSearchDO(doc));
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return doList;
	}
}
