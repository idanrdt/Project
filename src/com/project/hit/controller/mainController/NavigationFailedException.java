package com.project.hit.controller.mainController;

/*
 * Signals upon navigation to requested view failed.
 */
public class NavigationFailedException extends Exception {
	
	private String msg;
	
	/**
	 * Creates new {@link NavigationFailedException} and adds a message to it.
	 * @param msg - the message of the {@link Exception}.
	 */
	public NavigationFailedException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
