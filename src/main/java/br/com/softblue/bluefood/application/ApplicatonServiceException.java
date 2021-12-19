package br.com.softblue.bluefood.application;

@SuppressWarnings("serial")
public class ApplicatonServiceException extends RuntimeException {

	public ApplicatonServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicatonServiceException(String message) {
		super(message);
	}

	public ApplicatonServiceException(Throwable cause) {
		super(cause);
	}
  
}
