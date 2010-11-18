package com.alibaba.intl.bcds.goldroom.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EBookUploadService {

    private static Logger    logger      = Logger.getLogger(EBookUploadService.class);

    // 20K
    private static final int BUFFER_SIZE = 20 * 1024;

    @Autowired
    private String           eBookUploadPath;

    public String uploadEBook(File src, String isbn, String fileName) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                String path = eBookUploadPath + getFilePath(isbn);
                String destinationFullPath = path + getFileName(isbn, fileName);
                logger.info("Saving file to: " + destinationFullPath);
                File folder = new File(path);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                File dst = new File(destinationFullPath);
                in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                while (in.read(buffer) > 0) {
                    out.write(buffer);
                }
                String ebookPath = getFilePath(isbn) + getFileName(isbn, fileName);
                return ebookPath;
            } catch (IOException e) {
                logger.error(e);
                return StringUtils.EMPTY;
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            logger.error(e);
            return StringUtils.EMPTY;
        }
    }

    protected String getFilePath(String isbn) {
        StringBuffer sb = new StringBuffer();
        isbn = isbn.replace("-", "");
        isbn = isbn.replace("_", "");
        sb.append("/");
        if (isbn.length() > 6) {
            sb.append(isbn.substring(0, 2)).append("/");
            sb.append(isbn.substring(2, 4)).append("/");
            sb.append(isbn.substring(4, 6)).append("/");
            sb.append(isbn.subSequence(6, isbn.length())).append("/");
        } else {
            sb.append(isbn).append("/");
        }
        return sb.toString();
    }

    protected String getFileName(String isbn, String name) {
        StringBuffer sb = new StringBuffer();
        if (name.lastIndexOf(".") >= 0) {
            String ext = name.substring(name.lastIndexOf("."), name.length());
            sb.append(isbn).append(ext);
        }
        return sb.toString();
    }

    /**
     * @return the eBookUploadPath
     */
    public String getEBookUploadPath() {
        return eBookUploadPath;
    }

    /**
     * @param bookUploadPath the eBookUploadPath to set
     */
    public void setEBookUploadPath(String bookUploadPath) {
        eBookUploadPath = bookUploadPath;
    }
}
