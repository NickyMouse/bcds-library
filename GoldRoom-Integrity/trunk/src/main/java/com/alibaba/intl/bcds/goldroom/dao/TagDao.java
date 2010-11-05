package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.TagInfo;

/**
 * tag dao, get tag data from xml file
 *
 * @author Giraffe
 */
public interface TagDao {

    public TagInfo findTagInfoByTag(String tag);

    public List<TagInfo> listTagInfo();

    public List<TagInfo> listTagInfo(int size);

    public void refresh(Map<String, TagInfo> tagMap);
}
