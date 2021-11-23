package com.solienlac.khoaluan.web.common.exception;
import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorDetails {
	private Date timestamp;
	private Object message;

	public ErrorDetails(Date timestamp, Object message) {
		this.timestamp = timestamp;
		this.message = message;
	}


}