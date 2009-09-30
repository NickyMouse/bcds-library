package com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource;

import org.apache.log4j.Logger;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Searcher;

public class BookSearchDatasource implements SearchDatasource {

	private String indexLocation;
	private static Searcher searcher;
	private static Logger logger = Logger.getLogger(BookSearchDatasource.class);

	public String getIndexLocation() {
		return indexLocation;
	}

	public void setIndexLocation(String indexLocation) {
		this.indexLocation = indexLocation;
	}

	public Searcher getSearcher() {
		if (searcher == null) {
			IndexReader reader = null;
			try {
				reader = IndexReader.open(indexLocation);
			} catch (Exception e) {
				logger.error("Could not open index file location", e);
				return null;
			}
			searcher = new IndexSearcher(reader);
		}
		return searcher;
	}

}