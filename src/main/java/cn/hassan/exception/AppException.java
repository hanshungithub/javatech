package cn.hassan.exception;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/23 10:47
 * Description:
 */
public class AppException extends Exception {

	public AppException() {
		super();
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
