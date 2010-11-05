package com.alibaba.intl.bcds.goldroom.search.commons.dataobject;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * 装载tag 标签及对应的BOOKInfo 信息
 * 
 * @author wangguocheng
 * 
 */
public class TagInfoBooks {

	private TagInfo tagInfo;
	private List<BookSearch> bookinfos;

	public List<BookSearch> getBookinfos() {
		return bookinfos;
	}

	public void setBookinfos(List<BookSearch> bookinfos) {
		this.bookinfos = bookinfos;
	}

	public TagInfo getTagInfo() {
		return tagInfo;
	}

	public void setTagInfo(TagInfo tagInfo) {
		this.tagInfo = tagInfo;
	}

}
