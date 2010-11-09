package com.alibaba.intl.bcds.goldroom.dataobject;

/**
 * 每条评论对应的书
 * 
 */
public class CommentBookInfoDTO {

	private BookInfo bookinfo;
	private Comment commnet;

	public BookInfo getBookinfo() {
		return bookinfo;
	}

	public void setBookinfo(BookInfo bookinfo) {
		this.bookinfo = bookinfo;
	}

	public Comment getCommnet() {
		return commnet;
	}

	public void setCommnet(Comment commnet) {
		this.commnet = commnet;
	}
}
