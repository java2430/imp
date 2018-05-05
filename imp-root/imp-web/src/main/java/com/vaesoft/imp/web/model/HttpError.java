package com.vaesoft.imp.web.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class HttpError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4353477873338793189L;

	private HttpStatus status;

	private String message;

	private LocalDateTime timestamp;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
