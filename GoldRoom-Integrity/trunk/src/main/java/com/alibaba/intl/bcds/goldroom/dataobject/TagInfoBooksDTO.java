package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * 装载tag 标签及对应的BOOKInfo 信息
 *
 * @author wangguocheng
 */
public class TagInfoBooksDTO {

    private TagInfo        tagInfo;
    private List<BookInfo> bookInfoList;

    public TagInfo getTagInfo() {
        return tagInfo;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.tagInfo = tagInfo;
    }

    public void setBookInfoList(List<BookInfo> bookInfoList) {
        this.bookInfoList = bookInfoList;
    }

    public List<BookInfo> getBookInfoList() {
        return bookInfoList;
    }

}
