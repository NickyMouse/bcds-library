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

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;

public class DocumentToDoConvertor {
	private static Logger logger = Logger
			.getLogger(DocumentToDoConvertor.class);
	private Highlighter highlighter;
	private Analyzer analyzer;

	protected DocumentToDoConvertor(Query query) {
		this.analyzer = new MMAnalyzer();
		this.highlighter = new Highlighter(new SimpleHTMLFormatter(
				"<font color=\"red\">", "</font>"), new QueryScorer(query));
	}

	protected DocumentToDoConvertor() {

	}

	public static DocumentToDoConvertor getConvertor(boolean highlight,
			Query query) {
		if (highlight) {
			return new DocumentToDoConvertor(query);
		} else {
			return new DocumentToDoConvertor();
		}
	}

	public BookSearchDO convertToBookSearchDO(Document doc) {
		BookSearchDO aDO = new BookSearchDO();

		try {
			aDO.setItemId(Integer
					.valueOf(doc.get(BookSearchConstrains.ITEM_ID)));
			aDO.setItemState(Integer.valueOf(doc
					.get(BookSearchConstrains.ITEM_STATE)));
			aDO.setItemAddTime(new Date(Long.valueOf(doc
					.get(BookSearchConstrains.ITEM_ADD_TIME))));
			aDO.setItemFirstAddTime(new Date(Long.valueOf(doc
					.get(BookSearchConstrains.ITEM_ADD_TIME))));
			aDO.setItemGmtCreate(new Date(Long.valueOf(doc
					.get(BookSearchConstrains.ITEM_GMT_CREATE))));
			aDO.setItemGmtModified(new Date(Long.valueOf(doc
					.get(BookSearchConstrains.ITEM_GMT_MODIFIED))));
			aDO.setItemTags(doc.get(BookSearchConstrains.ITEM_TAGS));
			aDO.setBookInfoId(Integer.valueOf(doc
					.get(BookSearchConstrains.BOOK_INFO_ID)));
			aDO.setBookAuthor(doc.get(BookSearchConstrains.BOOK_AUTHOR));
			aDO.setBookName(doc.get(BookSearchConstrains.BOOK_NAME));
			aDO.setBookPublisher(doc.get(BookSearchConstrains.BOOK_PUBLISHER));
			aDO.setBookPublishTime(new Date(Long.valueOf(doc
					.get(BookSearchConstrains.BOOK_PUBLISH_TIME))));
			aDO.setBookIsbn(doc.get(BookSearchConstrains.BOOK_ISBN));
			aDO.setBookCategoryId(Integer.valueOf(doc
					.get(BookSearchConstrains.BOOK_CATEGORY_ID)));
			aDO.setBookImgUrl(doc.get(BookSearchConstrains.BOOK_IMG_URL));
			aDO.setBookDescription(doc
					.get(BookSearchConstrains.BOOK_DESCRIPTION));
			aDO.setBookEdition(doc.get(BookSearchConstrains.BOOK_EDITION));
			aDO.setMemberId(Integer.valueOf(doc
					.get(BookSearchConstrains.MEMBER_ID)));
			aDO.setMemberName(doc.get(BookSearchConstrains.MEMBER_NAME));
			aDO.setMemberWorkId(Integer.valueOf(doc
					.get(BookSearchConstrains.MEMBER_WORK_ID)));
			aDO.setMemberLoginId(doc.get(BookSearchConstrains.MEMBER_LOGIN_ID));
			aDO.setMemberEmail(doc.get(BookSearchConstrains.MEMBER_EMAIL));
			aDO.setMemberAlitalkId(doc
					.get(BookSearchConstrains.MEMBER_ALI_TALK_ID));
			highlight(aDO, doc);
		} catch (Exception e) {
			logger.error(e);
		}
		return aDO;
	}

	private void highlight(BookSearchDO aDO, Document doc) {
		if (analyzer != null) {
			String itemTags = doc.get(BookSearchConstrains.ITEM_TAGS);
			String bookName = doc.get(BookSearchConstrains.BOOK_NAME);
			String bookDesc = doc.get(BookSearchConstrains.BOOK_DESCRIPTION);

			TokenStream itemTagsTS = analyzer.tokenStream(
					BookSearchConstrains.ITEM_TAGS, new StringReader(itemTags));
			TokenStream bookNameTS = analyzer.tokenStream(
					BookSearchConstrains.BOOK_NAME, new StringReader(bookName));
			TokenStream bookDescTS = analyzer.tokenStream(
					BookSearchConstrains.BOOK_DESCRIPTION, new StringReader(
							bookDesc));
			try {
				itemTags = highlighter.getBestFragments(itemTagsTS, itemTags,
						4, "");
				bookName = highlighter.getBestFragments(bookNameTS, bookName,
						4, "");
				bookDesc = highlighter.getBestFragments(bookDescTS, bookDesc,
						4, "");
				if(itemTags.length()!=0 ) aDO.setItemTags(itemTags);
				if(bookName.length()!=0 ) aDO.setBookName(bookName);
				if(bookDesc.length()!=0 ) aDO.setBookDescription(bookDesc);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
