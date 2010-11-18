package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.io.File;

import org.apache.commons.lang.xwork.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.service.EBookUploadService;

public class FileUploadAction extends BaseAction {

    /**
     *
     */
    private static final long  serialVersionUID = -95683682541841999L;

    private File               myFile;

    private String             fileName;
    private String             contentType;
    private String             folder;

    private String             ebookUploadPath;
    private EBookUploadService eBookUploadService;

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getFileName() {
        return fileName;
    }

    // 是setMyFileFileName而不是setFileName 。 struts2的规则。MyFile 是上面private File
    // myFile

    public void setMyFileFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    // 同上
    public void setMyFileContentType(String contentType) {
        this.contentType = contentType;
    }

    public String execute() {
        String isbn = getIsbn(folder);
        ebookUploadPath = eBookUploadService.uploadEBook(myFile, isbn, fileName);
        return SUCCESS;
    }

    public String getIsbn(String folder) {
        if (StringUtils.isNotEmpty(folder)) {
            folder = folder.trim();
            if (folder.length() > 2) {
                return folder.substring(1, folder.length());
            }
        }
        return StringUtils.EMPTY;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }

    public void seteBookUploadService(EBookUploadService eBookUploadService) {
        this.eBookUploadService = eBookUploadService;
    }

    public EBookUploadService geteBookUploadService() {
        return eBookUploadService;
    }

    public void setEbookUploadPath(String ebookUploadPath) {
        this.ebookUploadPath = ebookUploadPath;
    }

    public String getEbookUploadPath() {
        return ebookUploadPath;
    }
}
