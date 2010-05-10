package com.alibaba.intl.bcds.goldroom.web.command;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileCommand {
	private MultipartFile file;
	private String isbn;

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

}
