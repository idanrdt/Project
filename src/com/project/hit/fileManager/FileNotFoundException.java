package com.project.hit.fileManager;

/**
 * Signals that the specified file not found in the application database.
 */
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