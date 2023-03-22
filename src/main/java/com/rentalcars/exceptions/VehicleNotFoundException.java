package com.rentalcars.exceptions;

public class VehicleNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	VehicleNotFoundException(Long id) {
		super("Could not find vehicle with id=" + id);
	}

}
