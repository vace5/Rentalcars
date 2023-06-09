package com.rentalcars.exceptions;

public class ContractNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	ContractNotFoundException(Long id) {
		super("Could not find contract with id=" + id);
	}

}
