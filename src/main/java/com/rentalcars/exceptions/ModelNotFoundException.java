package com.rentalcars.exceptions;

public class ModelNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	ModelNotFoundException(Long id) {
		super("Could not find model with id=" + id);
	}
}
