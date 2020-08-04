package com.example.application.services.exceptions;

//classe nossa de exceptions
public class ResourceNotFoundException extends RuntimeException{ //não obriga a implementa

	private static final long serialVersionUID = 1L; 

	public ResourceNotFoundException(Object id) {
		super("Resource Not Found" + id);
	}
}
