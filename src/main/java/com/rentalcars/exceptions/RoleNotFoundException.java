package com.rentalcars.exceptions;

public class RoleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoleNotFoundException(Long id) {
		super("Could not find role with id=" + id);
	}
}
