package com.udpwork.ssdb.exception;

public class SSDBException extends RuntimeException {

	private static final long serialVersionUID = 2018398441448804797L;

	public SSDBException(String message) {
		super(message);
	}

	public SSDBException(Throwable e) {
		super(e);
	}

	public SSDBException(String message, Throwable cause) {
		super(message, cause);
	}
}
