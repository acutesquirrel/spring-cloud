package com.ewp.data.quartz.exception;

/**
 * 
* @ClassName: ServiceException
* @Description: 自定义针对service异常
* @author zxj
* @date 2018年2月26日
*
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 8624944628363400977L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}