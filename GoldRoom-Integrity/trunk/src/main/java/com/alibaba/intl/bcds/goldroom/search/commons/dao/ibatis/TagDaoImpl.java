package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.TagDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.TagInfo;
import com.thoughtworks.xstream.XStream;

public class TagDaoImpl implements TagDao {

    private Map<String, TagInfo> tagMap            = new Hashtable<String, TagInfo>();
    private String               tagXmlPath;
    private List<TagInfo>        sortedTagInfoList = new ArrayList<TagInfo>();
    private long                 refreshInterval   = 5 * 60 * 60 * 1000;

    private static Logger        logger            = Logger.getLogger(TagDaoImpl.class);

    public long getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(long refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public String getTagXmlPath() {
        return tagXmlPath;
    }

    public void setTagXmlPath(String tagXmlPath) {
        this.tagXmlPath = tagXmlPath;
    }

    protected void refresh() {
        Timer timer = new Timer(true);
        TimerTask timeTask = new TimerTask() {

            @SuppressWarnings("unchecked")
            public void run() {
                File tagXmlFile = new File(tagXmlPath);
                if (!tagXmlFile.exists()) {
                    logger.error("tagDaoImpl: can not find tag xml file in [" + tagXmlPath + "]");
                    return;
                }
                try {
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(tagXmlFile), "UTF-8");
                    XStream xs = new XStream();
                    Map<String, TagInfo> newTagMap = (Map<String, TagInfo>) xs.fromXML(reader);
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
                    logger.info("tagDaoImpl refresh completed, map size:" + newTagMap.size() + ","
                                + (new Date()).toString());
                } catch (UnsupportedEncodingException e) {
                    logger.error("tagDaoImpl:" + e.getMessage());
                } catch (FileNotFoundException e) {
                    logger.error("tagDaoImpl:" + e.getMessage());
                }
            }
        };
        timer.schedule(timeTask, 0, refreshInterval);
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
