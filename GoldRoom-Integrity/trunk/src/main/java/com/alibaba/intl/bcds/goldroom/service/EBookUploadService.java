package com.alibaba.intl.bcds.goldroom.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EBookUploadService {

    private static Logger logger = Logger.getLogger(EBookUploadService.class);

    @Autowired
    private String        eBookUploadPath;

    public void uploadEBook() {
        // TODO implement the e-book upload
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
