package cn.com.pers.utils;

public class AppErrorException extends Exception {

	private static final long serialVersionUID = 2434119168843088066L;
	public AppErrorException() {
	}

	public AppErrorException(String message) {
		super(message);
	}

	public AppErrorException(Throwable cause) {
		super(cause);
	}

	public AppErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	private String errorCode = "";
	public AppErrorException(String eCode, String message, Throwable cause) {
		super(message, cause);
		errorCode = eCode;
	}
	
	public AppErrorException(String eCode, String message) {
		super(message);
		errorCode = eCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
