package com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Searcher;

public class BookSearchDatasource implements SearchDatasource {

	private String indexLocation;
	private static Searcher searcher;
	private static Logger logger = Logger.getLogger(BookSearchDatasource.class);
	private static IndexReader reader;

	public String getIndexLocation() {
		return indexLocation;
	}

	public void setIndexLocation(String indexLocation) {
		this.indexLocation = indexLocation;
	}

	public Searcher getSearcher() {

		if (searcher == null) {
			try {
				reader = IndexReader.open(indexLocation);
			} catch (Exception e) {
				logger.error("Could not open index file location", e);
				return null;
			}
			searcher = new IndexSearcher(reader);
		}

		try {
			if (!reader.isCurrent()) {
				synchronized (reader) {
					reader = reader.reopen();
					searcher = new IndexSearcher(reader);
				}
			}
		} catch (CorruptIndexException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return searcher;
	}

	public IndexReader getIndexReader() {
		if (reader == null) {
			try {
				reader = IndexReader.open(indexLocation);
			} catch (Exception e) {
				logger.error("Could not open index file location", e);
				return null;
			}
		}
		return reader;
	}

}
