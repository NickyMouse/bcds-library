package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.TagInfo;

public class TagFactory {

    private final static String  SPILT_TAG_MARK = "[\\s,，]";
    private Map<String, TagInfo> tagMap         = new Hashtable<String, TagInfo>();

    private static TagFactory    tagFactory;

    public static TagFactory getInstance() {
        if (tagFactory == null) {
            tagFactory = new TagFactory();
        }
        return tagFactory;
    }

    public void addBooks(List<BuildBookSearch> bookList) {
        for (BuildBookSearch b : bookList) {
            String tags = b.getBookTags();
            if (StringUtils.isNotEmpty(tags)) {
                String[] tagArray = tags.split(SPILT_TAG_MARK);
                for (String tag : tagArray) {
                    tag = tag.trim();
                    if (StringUtils.isNotEmpty(tag)) {
                        putToMap(tag, b.getBookInfoId());
                    }
                }
            }
        }
    }

    public Map<String, TagInfo> getTagMap() {
        return tagMap;
    }

    protected void putToMap(String tag, Integer bookId) {
        TagInfo tagInfo;
        tag = tag.toLowerCase();
        if (tagMap.containsKey(tag)) {
            tagInfo = tagMap.get(tag);
        } else {
            tagInfo = new TagInfo();
            tagInfo.setTagName(tag);
            tagInfo.setIds(new HashSet<Integer>());
            tagMap.put(tag, tagInfo);
        }

        if (tagInfo.getIds() != null) {
            tagInfo.getIds().add(bookId);
        }
    }
}
