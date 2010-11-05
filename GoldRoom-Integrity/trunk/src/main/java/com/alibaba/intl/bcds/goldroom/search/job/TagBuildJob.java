package com.alibaba.intl.bcds.goldroom.search.job;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.intl.bcds.goldroom.dao.TagDao;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.TagFactory;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.TagInfo;
import com.alibaba.intl.bcds.goldroom.service.BookSearchService;

public class TagBuildJob extends QuartzJobBean {

    private static Logger     logger = Logger.getLogger(TagBuildJob.class);
    private BookSearchService bookSearchService;
    private int               pageSize;
    private TagDao            tagDao;

    /**
     * full build data to index
     *
     * @throws IOException
     */
    public void build() {
        Date start = new Date();
        TagFactory tagFactory = TagFactory.getInstance();

        BookSearchResult result = bookSearchService.listAllBook(SearchBookType.ALL, 0, pageSize);
        int page = 0;
        while (result.getTotalCount() > 0) {
            tagFactory.addBooks(result.getBookList());
            page++;
            result = bookSearchService.listAllBook(SearchBookType.ALL, page * pageSize, pageSize);
        }

        Map<String, TagInfo> tagMap = tagFactory.getTagMap();
        Date end = new Date();
        logger.info("Tag build finish in " + (end.getTime() - start.getTime()) + "ms");
        tagDao.refresh(tagMap);
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        build();
    }

    public void setBookSearchService(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    public BookSearchService getBookSearchService() {
        return bookSearchService;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public TagDao getTagDao() {
        return tagDao;
    }

}
