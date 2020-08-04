package com.example.application.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L; //não obriga a implementa

	public ResourceNotFoundException(Object id) {
		super("Resource Not Found" + id);
	}
}
