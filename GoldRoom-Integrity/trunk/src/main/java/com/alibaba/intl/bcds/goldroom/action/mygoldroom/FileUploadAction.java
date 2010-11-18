package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;

public class FileUploadAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = -95683682541841999L;

    private static final int  BUFFER_SIZE      = 20 * 1024;          // 20K

    private File              myFile;                                // 与页面 <input type="file"> 控件的 name 保持一致

    private String            fileName;                              //
    private String            contentType;
    private String            queueID;

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
        String newFileName = new Date().getTime() + getExtention(fileName);

        File imageFile = new File("f:/" + newFileName);

        upload(myFile, imageFile);

        return SUCCESS;
    }

    private static void upload(File src, File dst) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = in.read(buffer);
                while (count > 0) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");

        return fileName.substring(pos);
    }

    public void setQueueID(String queueID) {
        this.queueID = queueID;
    }

    public String getQueueID() {
        return queueID;
    }

}
