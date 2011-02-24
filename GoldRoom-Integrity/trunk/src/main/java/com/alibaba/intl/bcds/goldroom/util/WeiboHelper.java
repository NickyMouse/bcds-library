package com.alibaba.intl.bcds.goldroom.util;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import weibo4j.Weibo;
import weibo4j.WeiboException;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

public class WeiboHelper {

    private Weibo               sinaWeibo;

    private final static Logger logger     = Logger.getLogger(WeiboHelper.class);

    private String              bookImagePath;

    private static final String DETAIL_URL = "http://goldroom.b2b.alibaba-inc.com/detail/bookDetail.do?bookInfoId=%s&log=fromSinaWeibo";

    public void sendMessage(String content) throws WeiboException {
        sinaWeibo.updateStatus(content);
    }

    public void sendMessageWithImage(String content, String imageAbsolutePath) throws WeiboException,
                                                                              FileNotFoundException {
        File imageFile = new File(imageAbsolutePath);
        if (imageFile.exists() == false) {
            throw new FileNotFoundException("imageFile not found:" + imageAbsolutePath);
        }
        sinaWeibo.uploadStatus(content, imageFile);
    }

    public void sendNewBookMessage(BookInfo bookInfo) throws FileNotFoundException, WeiboException {
        if (bookInfo == null) {
            logger.error("bookInfo is null");
        }
        if (bookInfo == null || bookInfo.getId() == null || StringUtils.isEmpty(bookInfo.getName())) {
            throw new IllegalArgumentException("bookInfo is not valid, id: " + bookInfo.getId() + ", name:"
                                               + bookInfo.getName());
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
