package com.udpwork.ssdb.exception;

public class SSDBConnectionException extends SSDBException{

	public SSDBConnectionException(String message) {
		super(message);
	}

	public SSDBConnectionException(Throwable e) {
		super(e);
	}

	public SSDBConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static final long serialVersionUID = -4626935665216356332L;
	
}
