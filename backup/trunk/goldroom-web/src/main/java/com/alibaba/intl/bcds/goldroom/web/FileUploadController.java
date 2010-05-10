package com.alibaba.intl.bcds.goldroom.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.util.ImageUtil;
import com.alibaba.intl.bcds.goldroom.web.command.UploadFileCommand;

public class FileUploadController extends SimpleFormController {
    private static Logger logger = Logger.getLogger(FileUploadController.class);
    private ImageUtil     imageUtil;

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) {

        UploadFileCommand bean = (UploadFileCommand) command;
        String isbn = bean.getIsbn();
        MultipartFile file = bean.getFile();

        if (file == null) {
            return null;
        }
        if (file.getSize() > 10000000) {
            return null;
        }

        String orginalName = file.getOriginalFilename();
        String extName = orginalName.substring(orginalName.lastIndexOf("."), orginalName.length());

        String path = null;
        try {
            path = getImageUtil().save(isbn, extName, file.getBytes());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
        try {
            response.getWriter().write(path);
            response.setStatus(200);
            response.setContentType("Text");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;

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
