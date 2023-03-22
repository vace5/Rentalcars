package com.rentalcars.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	UserNotFoundException(Long id) {
		super("Could not find user with id=" + id);
	}

}
