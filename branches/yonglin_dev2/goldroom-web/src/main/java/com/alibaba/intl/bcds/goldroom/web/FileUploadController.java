package com.alibaba.intl.bcds.goldroom.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.web.command.UploadFileCommand;

public class FileUploadController extends SimpleFormController {
	private String uploadRoot;

	public void setUploadRoot(String uploadRoot) {
		this.uploadRoot = uploadRoot;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) {
		try {
			UploadFileCommand bean = (UploadFileCommand) command;
			String isbn = bean.getIsbn();
			MultipartFile file = bean.getFile();

			if (file == null) {
				throw new Exception("");
			}
			if (file.getSize() > 10000000) {
				throw new Exception("");
			}

			String orginalName = file.getOriginalFilename();
			String extName = orginalName.substring(
					orginalName.lastIndexOf("."), orginalName.length());
			String fileName = isbn + extName;

			if (file.getSize() > 0) {
				try {
					saveFileFromInputStream(file.getInputStream(), uploadRoot,
							fileName);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					return null;
				}
			} else {
				throw new Exception("");
			}
			try {
				// return super.onSubmit(request, response, command, errors);
				ModelAndView modelAndView = new ModelAndView(
						"redirect:fillBookInfo.htm");
				modelAndView.addObject("imgSrc", fileName);
				modelAndView.addObject("isbn", isbn);
				return modelAndView;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void saveFileFromInputStream(InputStream stream, String path,
			String filename) throws IOException {
		FileOutputStream fs = new FileOutputStream(path + "/" + filename);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;

		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}
}
