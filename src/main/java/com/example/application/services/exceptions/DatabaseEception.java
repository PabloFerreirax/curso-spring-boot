package com.example.application.services.exceptions;

public class DatabaseEception extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DatabaseEception(String msg) {
		super(msg);
	}

}
