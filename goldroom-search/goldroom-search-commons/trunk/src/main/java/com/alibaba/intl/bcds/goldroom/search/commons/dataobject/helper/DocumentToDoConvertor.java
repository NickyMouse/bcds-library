package com.alibaba.intl.bcds.goldroom.search.commons.dataobject.helper;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;

public class DocumentToDoConvertor {
	private static Logger logger = Logger.getLogger(DocumentToDoConvertor.class);
	public static BookSearchDO convertToBookSearchDO(Document doc){
		BookSearchDO aDO = new BookSearchDO();
		try{
			aDO.setItemId(Integer.valueOf(doc.get(BookSearchConstrains.ITEM_ID)));
			aDO.setItemState(Integer.valueOf(doc.get(BookSearchConstrains.ITEM_STATE)));
			aDO.setItemAddTime(new Date(Long.valueOf(doc.get(BookSearchConstrains.ITEM_ADD_TIME))));
			aDO.setItemFirstAddTime(new Date(Long.valueOf(doc.get(BookSearchConstrains.ITEM_ADD_TIME))));
			aDO.setItemGmtCreate(new Date(Long.valueOf(doc.get(BookSearchConstrains.ITEM_GMT_CREATE))));
			aDO.setItemGmtModified(new Date(Long.valueOf(doc.get(BookSearchConstrains.ITEM_GMT_MODIFIED))));
			aDO.setItemTags(doc.get(BookSearchConstrains.ITEM_TAGS));
			aDO.setBookInfoId(Integer.valueOf(doc.get(BookSearchConstrains.BOOK_INFO_ID)));
			aDO.setBookAuthor(doc.get(BookSearchConstrains.BOOK_AUTHOR));
			aDO.setBookName(doc.get(BookSearchConstrains.BOOK_NAME));
			aDO.setBookPublisher(doc.get(BookSearchConstrains.BOOK_PUBLISHER));
			aDO.setBookPublishTime(new Date(Long.valueOf(doc.get(BookSearchConstrains.BOOK_PUBLISH_TIME))));
			aDO.setBookIsbn(doc.get(BookSearchConstrains.BOOK_ISBN));
			aDO.setBookCategoryId(Integer.valueOf(doc.get(BookSearchConstrains.BOOK_CATEGORY_ID)));
			aDO.setBookImgUrl(doc.get(BookSearchConstrains.BOOK_IMG_URL));
			aDO.setBookDescription(doc.get(BookSearchConstrains.BOOK_DESCRIPTION));
			aDO.setBookEdition(doc.get(BookSearchConstrains.BOOK_EDITION));
			aDO.setMemberId(Integer.valueOf(doc.get(BookSearchConstrains.MEMBER_ID)));
			aDO.setMemberName(doc.get(BookSearchConstrains.MEMBER_NAME));
			aDO.setMemberWorkId(Integer.valueOf(doc.get(BookSearchConstrains.MEMBER_WORK_ID)));
			aDO.setMemberLoginId(doc.get(BookSearchConstrains.MEMBER_LOGIN_ID));
			aDO.setMemberEmail(doc.get(BookSearchConstrains.MEMBER_EMAIL));
			aDO.setMemberAlitalkId(doc.get(BookSearchConstrains.MEMBER_ALI_TALK_ID));
			
		}catch (Exception e){
			logger.error(e);
		}
		return aDO;
	}
}
