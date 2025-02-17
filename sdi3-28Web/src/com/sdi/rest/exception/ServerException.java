package com.sdi.rest.exception;

public class ServerException extends Exception{

	private static final long serialVersionUID = -8080889170103298058L;

	public ServerException() {
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable cause) {
		super(cause);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

}
