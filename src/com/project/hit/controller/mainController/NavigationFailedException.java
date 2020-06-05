package com.project.hit.controller.mainController;

/*
 * Signals upon navigation to requested view failed.
 */
public class NavigationFailedException extends Exception {
	
	private String msg;
	
	public NavigationFailedException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
