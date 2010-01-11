package com.alibaba.intl.bcds.goldroom.search.commons.dataobject.helper;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import jeasy.analysis.MMAnalyzer;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.utils.NumberUtils;

/**
 * Document 到DO的转换类
 * 
 * @author Giraffe
 */
public class DocumentToDoConvertor {

    private static Logger logger = Logger.getLogger(DocumentToDoConvertor.class);
    private Highlighter   highlighter;                                           // 高亮器
    private Analyzer      analyzer;                                              // 词法分析器

    protected DocumentToDoConvertor(Query query) {
        this.analyzer = new MMAnalyzer();
        this.highlighter = new Highlighter(new SimpleHTMLFormatter("<font color=\"red\">", "</font>"),
                                           new QueryScorer(query));
    }

    protected DocumentToDoConvertor() {

    }

    public static DocumentToDoConvertor getConvertor(boolean highlight, Query query) {
        if (highlight) {
            return new DocumentToDoConvertor(query);
        } else {
            return new DocumentToDoConvertor();
        }
    }

    public BookSearch convertToBookSearchDO(Document doc) {
        BookSearch aDO = new BookSearch();

        try {
            aDO.setItemAddTime(new Date(NumberUtils.toLong(doc.get(BookSearchConstrains.ITEM_ADD_TIME), 0)));
            aDO.setItemFirstAddTime(new Date(NumberUtils.toLong(doc.get(BookSearchConstrains.ITEM_FIRST_ADD_TIME), 0)));
            aDO.setBookTags(doc.get(BookSearchConstrains.BOOK_TAGS));
            aDO.setBookInfoId(NumberUtils.toInteger(doc.get(BookSearchConstrains.BOOK_INFO_ID)));
            aDO.setBookAuthor(doc.get(BookSearchConstrains.BOOK_AUTHOR));
            aDO.setBookName(doc.get(BookSearchConstrains.BOOK_NAME));
            aDO.setBookPublisher(doc.get(BookSearchConstrains.BOOK_PUBLISHER));
            aDO.setBookPublishTime(new Date(NumberUtils.toLong(doc.get(BookSearchConstrains.BOOK_PUBLISH_TIME), 0)));
            aDO.setBookIsbn(doc.get(BookSearchConstrains.BOOK_ISBN));
            aDO.setBookCategoryId(NumberUtils.toInteger(doc.get(BookSearchConstrains.BOOK_CATEGORY_ID)));
            aDO.setBookImgUrl(doc.get(BookSearchConstrains.BOOK_IMG_URL));
            aDO.setBookDescription(doc.get(BookSearchConstrains.BOOK_DESCRIPTION));
            aDO.setBookEdition(doc.get(BookSearchConstrains.BOOK_EDITION));
            aDO.setBookOwners(doc.get(BookSearchConstrains.BOOK_OWNERS));
            aDO.setBookPages(NumberUtils.toInteger(doc.get(BookSearchConstrains.BOOK_PAGES)));
            aDO.setBookTranslator(doc.get(BookSearchConstrains.BOOK_TRANSLATOR));
            highlight(aDO, doc);
        } catch (Exception e) {
            logger.error(e);
        }
        return aDO;
    }

    private void highlight(BookSearch aDO, Document doc) {
        if (analyzer != null) {
            String bookTags = doc.get(BookSearchConstrains.BOOK_TAGS);
            String bookName = doc.get(BookSearchConstrains.BOOK_NAME);
            String bookDesc = doc.get(BookSearchConstrains.BOOK_DESCRIPTION);

            TokenStream bookTagsTS = analyzer.tokenStream(BookSearchConstrains.BOOK_TAGS, new StringReader(bookTags));
            TokenStream bookNameTS = analyzer.tokenStream(BookSearchConstrains.BOOK_NAME, new StringReader(bookName));
            TokenStream bookDescTS = analyzer.tokenStream(BookSearchConstrains.BOOK_DESCRIPTION,
                                                          new StringReader(bookDesc));
            try {
                bookTags = highlighter.getBestFragments(bookTagsTS, bookTags, 4, "");
                bookName = highlighter.getBestFragments(bookNameTS, bookName, 4, "");
                bookDesc = highlighter.getBestFragments(bookDescTS, bookDesc, 4, "");
                if (bookTags.length() != 0) aDO.setBookTags(bookTags);
                if (bookName.length() != 0) aDO.setBookName(bookName);
                if (bookDesc.length() != 0) aDO.setBookDescription(bookDesc);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
