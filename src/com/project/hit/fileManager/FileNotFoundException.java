package com.project.hit.fileManager;

public class FileNotFoundException extends Exception {
	private String msg;
	
	public FileNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
