/**
 * Project: goldroom-web
 * 
 * File Created at 2009-12-6
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.remote;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * TODO Comment of DoubanBookInfoFetcher
 * 
 * @author Zimmem
 */
public class DoubanBookInfoFetcher implements BookInfoFetcher, InitializingBean {

    private String fetchUrl;

    // private Map<String, String> nameSpaceMap = new HashMap<String, String>();
    //static {

    //}

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.remote.BookInfoFetcher#fetch(java.lang
     * .String)
     */
    @Override
    public BookInfo fetch(String isbn) {
        HttpMethod method = new GetMethod(fetchUrl + isbn);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(method);
            return parserBookInfo(method.getResponseBodyAsString());
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private BookInfo parserBookInfo(String xml) {
        BookInfo info = new BookInfo();
        try {
            Document document = DocumentHelper.parseText(xml);
            info.setAuthor(createXpath("/entry/s:author/s:name").selectSingleNode(document)
                    .getText());
            info.setDescription(createXpath("/entry/s:summary").selectSingleNode(document)
                    .getText());
            info.setName(createXpath("/entry/s:title").selectSingleNode(document).getText());
            info.setPages(NumberUtils.toInt(document.selectSingleNode(
                    "/entry/db:attribute[@name='pages']").getText()));
            info.setPublisher(document.selectSingleNode("/entry/db:attribute[@name='publisher']")
                    .getText());
            info.setTranslator(document.selectSingleNode("/entry/db:attribute[@name='translator']")
                    .getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            info.setPublishTime(sdf.parse(document.selectSingleNode(
                    "/entry/db:attribute[@name='pubdate']").getText()));

            return info;
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private XPath createXpath(String xpathExpression) {

        Map<String, String> nameSpaceMap = new HashMap<String, String>();
        nameSpaceMap.put("s", "http://www.w3.org/2005/Atom");
        XPath xPath = DocumentHelper.createXPath(xpathExpression);
        xPath.setNamespaceURIs(nameSpaceMap);
        return xPath;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(fetchUrl))
            throw new IllegalStateException("fetchUrl can't be null or empty");

    }

}
