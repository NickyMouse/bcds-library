package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dao.TagDao;
import com.alibaba.intl.bcds.goldroom.dataobject.TagInfo;

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

	/**
	 * @return the tagDao
	 */
	public TagDao getTagDao() {
		return tagDao;
	}

	/**
	 * @param tagDao the tagDao to set
	 */
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
}
