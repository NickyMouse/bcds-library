/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dataobject.comment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Comment;

/**
 * @author Harrison
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="BOOKINFO")
public class BookInfoComment extends Comment {
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=com.alibaba.intl.bcds.goldroom.dataobject.BookInfo.class)
	@JoinColumn(name="TARGET_ID",referencedColumnName="id")
	private BookInfo bookInfo; // 评论的书籍

	/**
	 * @return the bookInfo
	 */
	public BookInfo getBookInfo() {
		return bookInfo;
	}

	/**
	 * @param bookInfo the bookInfo to set
	 */
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

}
