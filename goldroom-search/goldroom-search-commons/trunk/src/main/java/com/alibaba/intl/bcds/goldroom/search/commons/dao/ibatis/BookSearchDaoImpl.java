package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.MultiPhraseQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource.SearchDatasource;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQuery;

public class BookSearchDaoImpl implements BookSearchDao {
	private static Logger logger = Logger.getLogger(BookSearchDaoImpl.class);
	private SearchDatasource searchDatasource;

	public SearchDatasource getSearchDatasource() {
		return searchDatasource;
	}

	public void setSearchDatasource(SearchDatasource searchDatasource) {
		this.searchDatasource = searchDatasource;
	}

	public List<BookSearchDO> searchByQuery(BookSearchQuery query) {
		//TODO Clean code
		int n = query.getN();
		String primarySortKey = query.getPrimarySortFiled();
		Searcher searcher = searchDatasource.getSearcher();
		MultiPhraseQuery mQuery = query.getMultiPhraseQuery();

		long start = new Date().getTime();
		TopDocs docs = null;
		try {

			docs = searcher.search(mQuery, null, n, new Sort(new SortField(
					primarySortKey, 1)));
		} catch (IOException e) {
			logger.error(e);
			return new ArrayList<BookSearchDO>();
		}
		ScoreDoc[] hits = docs.scoreDocs;

		long end = new Date().getTime();

		int numTotalHits = hits.length;
		logger.info(query.toString() + " #result:" + numTotalHits
				+ " total matching documents. Time is " + (end - start) + "ms");

		for (ScoreDoc hit : hits) {
			Document doc = null;
			try {
				doc = searcher.doc(hit.doc);
			} catch (Exception e) {
				continue;
			}
			System.out.println(hit);
		}
		return null;
	}
}
