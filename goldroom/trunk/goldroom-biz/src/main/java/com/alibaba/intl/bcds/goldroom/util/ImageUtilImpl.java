/**
 * Project: goldroom-biz
 * 
 * File Created at 2010-1-4
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
package com.alibaba.intl.bcds.goldroom.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

/**
 * TODO Comment of ImageUtilImpl
 * 
 * @author Zimmem
 */
public class ImageUtilImpl implements ImageUtil, InitializingBean {

    public static final String HTTP_SEPARATOR = "/";
    private String             uploadPath;

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.util.ImageUtil#save(java.lang.String,
     * java.lang.String, byte[])
     */
    @Override
    public String save(String isbn, String suffix, byte[] body) {
        String dirPath = uploadPath + isbnTopath(isbn);
        File dir = new File(dirPath);
        if (!dir.exists())
            dir.mkdirs();
        StringBuilder imgPath = new StringBuilder(dirPath);
        imgPath.append(isbn).append(suffix);
        File imageFile = new File(imgPath.toString());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageFile);
            fos.write(body);
            fos.flush();
        } catch (IOException e) {
            return null;
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
            }
        }

        return isbnToHttpPath(isbn, suffix);
    }

    /**
     * @param isbn
     * @param suffix
     * @return
     */
    private String isbnToHttpPath(String isbn, String suffix) {
        StringBuilder path = new StringBuilder(isbnTopath(isbn, HTTP_SEPARATOR));
        return path.append(isbn).append(suffix).toString();

    }

    private String isbnTopath(String isbn) {
        return isbnTopath(isbn, File.separator);
    }

    private String isbnTopath(String isbn, String separator) {
        StringBuilder sb = new StringBuilder();
        sb.append(separator).append(StringUtils.left(isbn, 2));
        sb.append(separator).append(StringUtils.mid(isbn, 2, 2));
        sb.append(separator).append(StringUtils.mid(isbn, 4, 2));
        sb.append(separator);
        return sb.toString();
    }

    /**
     * @param uploadPath the uploadPath to set
     */
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    /**
     * @return the uploadPath
     */
    public String getUploadPath() {
        return uploadPath;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(uploadPath)) {
            throw new Exception("upload path can not be null or empty");
        }

    }

}
