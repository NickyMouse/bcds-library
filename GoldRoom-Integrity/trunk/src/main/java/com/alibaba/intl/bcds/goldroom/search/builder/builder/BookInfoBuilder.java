package com.alibaba.intl.bcds.goldroom.search.builder.builder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jeasy.analysis.MMAnalyzer;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.springframework.context.ApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.builder.utils.ConvertObjectHandler;
import com.alibaba.intl.bcds.goldroom.search.builder.utils.DocumentFactory;
import com.alibaba.intl.bcds.goldroom.search.builder.utils.SearchApplicationContext;
import com.alibaba.intl.bcds.goldroom.search.builder.utils.TagFactory;
import com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource.BookSearchDatasource;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.TagInfo;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.helper.BookSearchConstrains;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchServiceLocator;
import com.thoughtworks.xstream.XStream;

public class BookInfoBuilder extends BaseBuilder {

    private static Logger logger = Logger.getLogger(BookInfoBuilder.class);
    private Date          processStartTime;
    private Date          modifiedEndTime;
    private long          interval;

    private String        tagXmlPath;

    public Date getModifiedEndTime() {
        return modifiedEndTime;
    }

    public void setModifiedEndTime(Date modifiedEndTime) {
        this.modifiedEndTime = modifiedEndTime;
    }

    public String getTagXmlPath() {
        return tagXmlPath;
    }

    public void setTagXmlPath(String tagXmlPath) {
        this.tagXmlPath = tagXmlPath;
    }

    @Override
    protected void afterBuild() {
        Date processEndTime = new Date();
        String info = null;
        if (this.isIncrementBuild()) {
            info = "[Search Builder]:Increment Build Done at " + processEndTime;
        } else {
            info = "[Search Builder]:Full Build Done at " + processEndTime;
        }
        logger.info(info + "; " + (processEndTime.getTime() - processStartTime.getTime()) + " total milliseconds");
    }

    @Override
    protected void beforeBuild() {
        processStartTime = new Date();
        String info;
        if (this.isIncrementBuild()) {
            info = "[Search Builder]:Increment Build Start at " + processStartTime;
        } else {
            info = "[Search Builder]:Full Build Start. at " + processStartTime;
        }
        logger.info(info);
    }

    @Override
    protected void fullBuild() throws IOException {
        ApplicationContext handlerContext = SearchApplicationContext.getConvertObjectHandlerContext();
        ConvertObjectHandler handler = (ConvertObjectHandler) handlerContext.getBean("bookInfoConvertObjectHandler");
        DocumentFactory factory = DocumentFactory.getInstance(BuildBookSearch.class, handler);
        IndexWriter writer = null;
        PrintWriter tagXmlWriter = null;
        try {
            writer = new IndexWriter(this.getDestination(), new StandardAnalyzer(), true,
                                     IndexWriter.MaxFieldLength.LIMITED);

            int page = 1;
            List<BuildBookSearch> listToProcessed = BookSearchServiceLocator.getBuildBookSearchService().listAllBook(page);
            List<BuildBookSearch> bookList = filterBooks(listToProcessed);
            TagFactory tagFactory = TagFactory.getInstance();
            while (bookList != null && bookList.size() > 0) {
                List<Document> docList = factory.convertList(bookList);
                tagFactory.addBooks(bookList);
                System.out.println("page:" + page + " list:" + bookList.size() + "documentList:" + docList.size());

                for (Document doc : docList) {
                    writer.addDocument(doc);
                }
                page++;
                listToProcessed = BookSearchServiceLocator.getBuildBookSearchService().listAllBook(page);
                bookList = filterBooks(listToProcessed);
            }
            writer.optimize();

            // write tags info to xml file
            XStream xs = new XStream();

            Map<String, TagInfo> tagMap = tagFactory.getTagMap();
            File tagXmlFile = new File(this.getTagXmlPath());
            logger.info(this.getTagXmlPath());
            if (!tagXmlFile.exists()) {
                File tagXmlFileDir = tagXmlFile.getParentFile();
                if (!tagXmlFileDir.exists()) {
                    tagXmlFileDir.mkdirs();
                }
                tagXmlFile.createNewFile();
            }
            tagXmlWriter = new PrintWriter(this.getTagXmlPath(), "UTF-8");
            xs.toXML(tagMap, tagXmlWriter);
        } catch (IOException e) {
            logger.error(e);
            throw e;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (tagXmlWriter != null) {
                    tagXmlWriter.close();
                }
            } catch (IOException e) {
                logger.error(e);
                throw e;
            }
        }
    }

    @Override
    protected void incrementBuild() throws IOException {
        ApplicationContext handlerContext = SearchApplicationContext.getConvertObjectHandlerContext();
        ConvertObjectHandler handler = (ConvertObjectHandler) handlerContext.getBean("bookInfoConvertObjectHandler");
        DocumentFactory factory = DocumentFactory.getInstance(BuildBookSearch.class, handler);
        IndexWriter writer = null;
        try {
            Date modifiedStartTime = new Date(modifiedEndTime.getTime() - interval);
            List<BuildBookSearch> bookList = BookSearchServiceLocator.getBuildBookSearchService().listBookByTime(modifiedStartTime,
                                                                                                                 modifiedEndTime);

            for (BuildBookSearch book : bookList) {
                if (StringUtils.isNotEmpty(book.getBookOwners())) {
                    String temp = "," + book.getBookOwners().replace('.', '@') + ",";
                    book.setBookOwners(temp);
                }
            }

            logger.info("[Search Builder]Incrememnt build " + bookList.size() + " records modified between "
                        + modifiedStartTime + " and " + modifiedEndTime);
            deleteIndex(bookList);
            writer = new IndexWriter(this.getDestination(), new MMAnalyzer(), false, IndexWriter.MaxFieldLength.LIMITED);
            List<Document> docList = factory.convertList(bookList);
            for (Document doc : docList) {
                writer.addDocument(doc);
            }
            writer.optimize();
            modifiedEndTime = new Date(modifiedEndTime.getTime() + interval);
        } catch (IOException e) {
            logger.error(e);
            throw e;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                logger.error(e);
                throw e;
            }
        }

    }

    @Override
    protected void onError(Object errorObj) {
        logger.error(errorObj);
        System.exit(1);
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getInterval() {
        return interval;
    }

    private List<BuildBookSearch> filterBooks(List<BuildBookSearch> listToProcessed) {
        List<BuildBookSearch> bookList = new ArrayList<BuildBookSearch>();
        for (BuildBookSearch book : listToProcessed) {
            if (StringUtils.isEmpty(book.getEbookUrl()) && StringUtils.isEmpty(book.getBookOwners())) {
                continue;
            }

            if (StringUtils.isNotEmpty(book.getBookOwners())) {
                String temp = "," + book.getBookOwners().replace('.', '@') + ",";
                book.setBookOwners(temp);
            }
            if (StringUtils.isEmpty(book.getEbookUrl())) {
                book.setHasEbook(Boolean.FALSE.toString());
            } else {
                book.setHasEbook(Boolean.TRUE.toString());
            }
            bookList.add(book);
        }
        return bookList;
    }

    private void deleteIndex(List<BuildBookSearch> bookList) {
        if (bookList == null || bookList.size() == 0) {
            return;
        }
        BookSearchDatasource datasource = new BookSearchDatasource();
        datasource.setIndexLocation(this.getDestination());
        IndexReader reader = datasource.getIndexReader();
        try {
            for (BuildBookSearch book : bookList) {
                reader.deleteDocuments(new Term(BookSearchConstrains.BOOK_INFO_ID, book.getBookInfoId().toString()));
            }
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}
