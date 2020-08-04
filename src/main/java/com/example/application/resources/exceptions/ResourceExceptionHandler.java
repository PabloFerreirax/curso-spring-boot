package com.example.application.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.application.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // tratamento personalizado desta execção
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "resourse not found"; //mensagem de erro personalizada
		HttpStatus status = HttpStatus.NOT_FOUND; // erro  que deve aparecer codigo 404 neste caso
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status(status).body(err);
	}
	
}
