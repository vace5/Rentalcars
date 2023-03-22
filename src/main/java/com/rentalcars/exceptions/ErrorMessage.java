package com.rentalcars.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorMessage {

	private int statusCode;
	private LocalDateTime timestamp;
	private String message;
	private String description;

}
