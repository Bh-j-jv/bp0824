package com.tool.rental.exceptions;

public class InvalidDiscountException extends RuntimeException {

	public InvalidDiscountException(String message) {
		super(message);
	}
}