/**
 * Project: goldroom-web File Created at 2009-12-6 $Id$ Copyright 2008 Alibaba.com Croporation Limited. All rights
 * reserved. This software is the confidential and proprietary information of Alibaba Company.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.util.DateConverter;
import com.alibaba.intl.bcds.goldroom.util.ImageUtil;

/**
 * TODO Comment of DoubanBookInfoFetcher
 *
 * @author Zimmem
 */
public class DoubanBookInfoFetcher implements BookInfoFetcher, InitializingBean {

    private static Map<String, String> nameSpaceMap = new HashMap<String, String>();
    static {
        nameSpaceMap.put("s", "http://www.w3.org/2005/Atom");
        nameSpaceMap.put("db", "http://www.douban.com/xmlns/");
        nameSpaceMap.put("gd", "http://schemas.google.com/g/2005");
        nameSpaceMap.put("opensearch", "http://a9.com/-/spec/opensearchrss/1.0/");
    }

    private String                     fetchUrl;

    private static Logger              logger       = Logger.getLogger(DoubanBookInfoFetcher.class);

    private DateConverter              dateConverter;

    private ImageUtil                  imageUtil;

    public BookInfo fetch(String isbn) {
        HttpMethod method = new GetMethod(fetchUrl + isbn);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(method);
            BookInfo info = parserBookInfo(method.getResponseBodyAsString());
            return info;

        } catch (HttpException e) {
            logger.error("fetch bookinfo whth isbn(" + isbn + ") error", e);
        } catch (Exception e) {
            logger.error("fetch bookinfo whth isbn(" + isbn + ") error", e);
        }
        return null;
    }

    private BookInfo parserBookInfo(String xml) {
        if (logger.isDebugEnabled()) {
            logger.debug("the bookinfo xml is \n" + xml + "\n");
        }
        logger.debug(xml);
        BookInfo info = new BookInfo();
        try {
            Document document = DocumentHelper.parseText(xml);
            info.setAuthor(queryByXpath("/entry/s:author/s:name", document));
            info.setDescription(queryByXpath("/entry/s:summary", document));
            info.setName(queryByXpath("/entry/s:title", document));
            info.setIsbn10(queryByXpath("/entry/db:attribute[@name='isbn10']", document));
            info.setIsbn13(queryByXpath("/entry/db:attribute[@name='isbn13']", document));
            info.setIsbn(info.getIsbn13());
            info.setPages(NumberUtils.toInt(queryByXpath("/entry/db:attribute[@name='pages']", document)));
            info.setPublisher(queryByXpath("/entry/db:attribute[@name='publisher']", document));
            info.setTranslator(queryByXpath("/entry/db:attribute[@name='translator']", document));

            info.setPublishTime(dateConverter.conver(queryByXpath("/entry/db:attribute[@name='pubdate']", document)));

            info.setTags(formatTag(queryByXpathForList("/entry/db:tag", "@name", document)));

            String imageUrl = createXpath("/entry/s:link[@rel='image']").selectSingleNode(document).valueOf("@href");
            info.setImgUrl(saveImage(info.getIsbn(), imageUrl));
            return info;
        } catch (DocumentException e) {
            logger.error("parse bookinfo from xml{" + xml + "} error", e);
        }
        return null;
    }

    private String formatTag(List<String> tagList) {
        if (tagList == null || tagList.isEmpty()) {
            return StringUtils.EMPTY;
        }
        StringBuffer sb = new StringBuffer();
        for (String tag : tagList) {
            sb.append(tag).append(",");
        }
        return sb.toString();
    }

    /**
     * @param isbn
     * @param imageUrl
     * @return
     */
    private String saveImage(String isbn, String imageUrl) {

        String largeImageUrl = StringUtils.replaceOnce(imageUrl, "s", "l");
        HttpMethod method = new GetMethod(largeImageUrl);
        HttpClient client = new HttpClient();
        try {
            // 尝试先取大图，如果取不到再取api里的小图地址，上帝保佑douban不要乱改图片地址吧~~~
            client.executeMethod(method);
            if (method.getStatusCode() != 200) {
                method = new GetMethod(imageUrl);
                client.executeMethod(method);
            }
            byte[] imgBody = method.getResponseBody();
            return imageUtil.save(isbn, getImageSuffix(imageUrl), imgBody);
        } catch (Exception e) {
            logger.warn("error occurred while save image from url :" + imageUrl + " for isbn " + isbn, e);
        }
        return null;
    }

    private String getImageSuffix(String url) {
        int begin = url.lastIndexOf("/");
        String name = url.substring(begin);
        begin = name.indexOf(".");
        return name.substring(begin);

    }

    private XPath createXpath(String xpathExpression) {

        XPath xPath = DocumentHelper.createXPath(xpathExpression);
        xPath.setNamespaceURIs(nameSpaceMap);
        return xPath;
    }

    private String queryByXpath(String xpathExpression, Document document) {
        try {
            XPath xPath = createXpath(xpathExpression);
            Node node = xPath.selectSingleNode(document);
            if (node != null) {
                return node.getText();
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        }
    }

    private List<String> queryByXpathForList(String xpathExpression, String valueExpresssion, Document document) {
        try {
            XPath xPath = createXpath(xpathExpression);
            List<Node> nodes = xPath.selectNodes(document);
            if (nodes != null && nodes.size() > 0) {
                List<String> returnValue = new ArrayList<String>();
                for (Node n : nodes) {
                    returnValue.add(n.valueOf(valueExpresssion));
                }
                return returnValue;
            }
            return new ArrayList<String>(0);
        } catch (RuntimeException e) {
            return new ArrayList<String>(0);
        }
    }

    /**
     * @param fetchUrl the fetchUrl to set
     */
    public void setFetchUrl(String fetchUrl) {
        this.fetchUrl = fetchUrl;
    }

    /**
     * @return the fetchUrl
     */
    public String getFetchUrl() {
        return fetchUrl;
    }

    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(fetchUrl)) throw new IllegalStateException("fetchUrl can't be null or empty");

    }

    /**
     * @param dateConverter the dateConverter to set
     */
    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    /**
     * @return the dateConverter
     */
    public DateConverter getDateConverter() {
        return dateConverter;
    }

    /**
     * @param imageUtil the imageUtil to set
     */
    public void setImageUtil(ImageUtil imageUtil) {
        this.imageUtil = imageUtil;
    }

    /**
     * @return the imageUtil
     */
    public ImageUtil getImageUtil() {
        return imageUtil;
    }

}
