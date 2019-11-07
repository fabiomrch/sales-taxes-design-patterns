package com.salestaxes.exception;

/**
 * Custom exception that must be thrown when a not existent product is selected
 * @author fab
 *
 */
public class ProductNotExistentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotExistentException(String message){
		super(message);
	}
	
}
