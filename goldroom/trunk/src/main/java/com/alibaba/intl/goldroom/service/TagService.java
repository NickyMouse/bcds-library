package com.alibaba.intl.goldroom.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.TagDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.TagInfo;

@Transactional
public class TagService {

    private static Logger logger = Logger.getLogger(TagService.class);
    @Autowired
    private TagDao        tagDao;

    public List<TagInfo> listTag(int size) {
        return tagDao.listTagInfo(size);
    }

    public TagInfo findTagInfoByTag(String tag) {
        return tagDao.findTagInfoByTag(tag);
    }
}
