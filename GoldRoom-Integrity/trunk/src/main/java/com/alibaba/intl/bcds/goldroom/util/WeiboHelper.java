package com.alibaba.intl.bcds.goldroom.util;

import java.io.File;

import org.apache.log4j.Logger;

import weibo4j.Weibo;
import weibo4j.WeiboException;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

public class WeiboHelper {

    private Weibo               sinaWeibo;

    private final static Logger logger     = Logger.getLogger(WeiboHelper.class);

    private String              bookImagePath;

    private static final String DETAIL_URL = "http://goldroom.b2b.alibaba-inc.com/detail/bookDetail.do?bookInfoId=%s&log=fromSinaWeibo";

    public void sendMessage(String content) {
        try {
            sinaWeibo.updateStatus(content);
        } catch (WeiboException e) {
            logger.error(e);
        }
    }

    public void sendMessageWithImage(String content, String imageAbsolutePath) {
        try {
            File imageFile = new File(imageAbsolutePath);
            if (imageFile.exists() == false) {
                logger.error("Image not found:" + imageAbsolutePath);
                return;
            }
            sinaWeibo.uploadStatus(content, imageFile);
        } catch (WeiboException e) {
            logger.error(e);
        }
    }

    public void sendNewBookMessage(BookInfo bookInfo) {
        if (bookInfo == null || bookInfo.getId() == null || StringUtils.isEmpty(bookInfo.getName())) {
            return;
        }
        String url = String.format(DETAIL_URL, bookInfo.getId());
        String message = "新书上架《" + bookInfo.getName() + "》，点击查看： " + url;
        String imageAbsPath = bookImagePath + bookInfo.getImgUrl();
        this.sendMessageWithImage(message, imageAbsPath);
    }

    public void setSinaWeibo(Weibo sinaWeibo) {
        this.sinaWeibo = sinaWeibo;
    }

    public Weibo getSinaWeibo() {
        return sinaWeibo;
    }

    public void setBookImagePath(String bookImagePath) {
        this.bookImagePath = bookImagePath;
    }

    public String getBookImagePath() {
        return bookImagePath;
    }
}
