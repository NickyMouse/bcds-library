package com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Searcher;

public class BookSearchDatasource implements SearchDatasource {

	/**
	 * 索引路径
	 */
	private String indexLocation;

	/**
	 * 搜索器
	 */
	private static Searcher searcher;
	private static Logger logger = Logger.getLogger(BookSearchDatasource.class);

	/**
	 * 索引reader
	 */
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
			// 检查索引是否更新，若索引已被更新，更新reader和searcher
			if (!reader.isCurrent()) {
				synchronized (reader) {
					reader = reader.reopen();
					searcher = new IndexSearcher(reader);
				}
			}
		} catch (IOException e1) {
			logger.error("Refresh IndexReader Error", e1);
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
		} else {
			try {
				if (!reader.isCurrent()) {
					synchronized (reader) {
						reader = reader.reopen();
						searcher = new IndexSearcher(reader);
					}
				}
			} catch (IOException e1) {
				logger.error("Refresh IndexReader Error", e1);
			}
		}
		return reader;
	}

}
