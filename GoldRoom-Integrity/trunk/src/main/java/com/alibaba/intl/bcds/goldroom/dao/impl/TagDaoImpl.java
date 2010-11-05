package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.dao.TagDao;
import com.alibaba.intl.bcds.goldroom.dataobject.TagInfo;

public class TagDaoImpl implements TagDao {

    private Map<String, TagInfo> tagMap            = new Hashtable<String, TagInfo>();
    private List<TagInfo>        sortedTagInfoList = new ArrayList<TagInfo>();

    private static Logger        logger            = Logger.getLogger(TagDaoImpl.class);

    public void refresh(Map<String, TagInfo> tagMap) {
        Map<String, TagInfo> newTagMap = tagMap;
        if (newTagMap == null) {
            logger.error("tagDaoImpl: refresh newTagMap is null");
        }

        List<TagInfo> newSortedTagInfoList = new ArrayList<TagInfo>();

        for (TagInfo t : newTagMap.values()) {
            newSortedTagInfoList.add(t);
        }

        Collections.sort(newSortedTagInfoList, new Comparator<TagInfo>() {

            @Override
            public int compare(TagInfo o1, TagInfo o2) {
                return o2.getAmount() - o1.getAmount();
            }

        });
        if (tagMap != null) {
            synchronized (tagMap) {
                tagMap = newTagMap;
            }
        } else {
            tagMap = newTagMap;
        }

        if (sortedTagInfoList != null) {
            synchronized (sortedTagInfoList) {
                sortedTagInfoList = newSortedTagInfoList;
            }
        } else {
            sortedTagInfoList = newSortedTagInfoList;
        }
        logger.info("tagDaoImpl refresh completed, map size:" + newTagMap.size() + "," + (new Date()).toString());
    }

    @Override
    public TagInfo findTagInfoByTag(String tag) {
        if (StringUtils.isEmpty(tag)) {
            return null;
        }
        tag = tag.toLowerCase();
        if (tagMap != null) {
            return tagMap.get(tag);
        }
        return null;
    }

    @Override
    public List<TagInfo> listTagInfo() {
        return Collections.unmodifiableList(sortedTagInfoList);
    }

    @Override
    public List<TagInfo> listTagInfo(int size) {
        if (sortedTagInfoList.size() >= size) {
            return Collections.unmodifiableList(sortedTagInfoList.subList(0, size));
        } else {
            return Collections.unmodifiableList(sortedTagInfoList);
        }
    }
}
