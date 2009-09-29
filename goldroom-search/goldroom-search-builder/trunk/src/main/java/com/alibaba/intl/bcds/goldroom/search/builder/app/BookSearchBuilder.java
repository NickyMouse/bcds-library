package com.alibaba.intl.bcds.goldroom.search.builder.app;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import jeasy.analysis.MMAnalyzer;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.LockObtainFailedException;
import org.springframework.context.ApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.builder.utils.ConvertObjectHandler;
import com.alibaba.intl.bcds.goldroom.search.builder.utils.DocumentFactory;
import com.alibaba.intl.bcds.goldroom.search.builder.utils.SearchApplicationContext;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchServiceLocator;

public class BookSearchBuilder {
	public static String INDEX_DIR = "f:/bookSearchIndex";

	/**
	 * @param args
	 * @throws IOException
	 * @throws LockObtainFailedException
	 * @throws CorruptIndexException
	 */
	public static void main(String[] args) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		List<BuildBookSearchDO> bookList = BookSearchServiceLocator
				.getBuildBookSearchService().listAllBook(0, 0);

		ApplicationContext handlerContext = SearchApplicationContext
				.getConvertObjectHandlerContext();
		ConvertObjectHandler handler = (ConvertObjectHandler) handlerContext
				.getBean("convertObjectHandler");
		DocumentFactory factory = DocumentFactory.getInstance(
				BuildBookSearchDO.class, handler);

		// Directory dir = new SimpleFSDirectory(new File(INDEX_DIR));
		IndexWriter writer = new IndexWriter(INDEX_DIR, new MMAnalyzer(),
				true, IndexWriter.MaxFieldLength.LIMITED);
		List<Document> docList = factory.convertList(bookList);
		System.out.println("Indexing to directory '" + INDEX_DIR + "'...");
		Date start = new Date();
		for (Document doc : docList) {
			writer.addDocument(doc);
		}
		System.out.println("Optimizing...");
		writer.optimize();
		writer.close();

		Date end = new Date();
		System.out.println(end.getTime() - start.getTime()
				+ " total milliseconds");

		System.out.println("Done");
	}
}
