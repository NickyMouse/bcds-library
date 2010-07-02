package com.alibaba.intl.goldroom.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RemotingDestination
@Transactional
public class EBookUploadService {

    private static Logger                     logger    = Logger.getLogger(EBookUploadService.class);
    private Map<String, BufferedOutputStream> fileOsMap = new ConcurrentHashMap<String, BufferedOutputStream>();

    @Autowired
    private String                            eBookUploadPath;

    public String uploadEBook(String isbn, String name, byte[] bytes, boolean isEOF) {
        if (StringUtils.isEmpty(isbn)) {
            return StringUtils.EMPTY;
        }
        BufferedOutputStream bos;

        try {
            if (fileOsMap.get(isbn) == null) {
                File f = new File(eBookUploadPath + getFilePath(isbn, name));
                f.mkdirs();
                f = new File(eBookUploadPath + getFilePath(isbn, name) + getFileName(isbn, name));
                FileOutputStream fos = new FileOutputStream(f);
                bos = new BufferedOutputStream(fos);
                fileOsMap.put(isbn, bos);
            } else {
                bos = fileOsMap.get(isbn);
            }
            if (bos != null) {
                logger.info("[EBookUploadService] isbn:" + isbn + " upload bytes:" + bytes.length + " isEOF" + isEOF);

                bos.write(bytes);
                if (isEOF) {
                    bos.flush();
                    bos.close();
                    fileOsMap.remove(isbn);
                    return getFilePath(isbn, name) + getFileName(isbn, name);
                }
                return "";
            } else {
                logger.error("[EBookUploadService] bos:is NULL isbn:" + isbn + " upload bytes:" + bytes.length
                             + " isEOF" + isEOF);
                return StringUtils.EMPTY;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return StringUtils.EMPTY;
        } catch (IOException e) {
            e.printStackTrace();
            return StringUtils.EMPTY;
        }
    }

    protected String getFilePath(String isbn, String name) {
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
            String ext = name.substring(name.lastIndexOf(".") + 1, name.length());
            sb.append(isbn).append(".").append(ext);
        }
        return sb.toString();
    }
}
