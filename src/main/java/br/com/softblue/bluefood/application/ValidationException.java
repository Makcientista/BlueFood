package br.com.softblue.bluefood.application;

@SuppressWarnings("serial")
public class ValidationException extends Exception {

	ValidationException(String message ){
		super(message);
	}
}
