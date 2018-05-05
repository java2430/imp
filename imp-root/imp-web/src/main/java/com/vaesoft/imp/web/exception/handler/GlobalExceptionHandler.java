package com.vaesoft.imp.web.exception.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaesoft.imp.web.exception.EntityNotFoundException;
import com.vaesoft.imp.web.model.HttpError;

@ControllerAdvice
public class GlobalExceptionHandler {
	@SuppressWarnings("rawtypes")
	private static final Map<Class, HttpStatus> EXCEPTION_HTTPSTATUS = new HashMap<Class, HttpStatus>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7671659467097439718L;

		{
			put(EntityNotFoundException.class, HttpStatus.NOT_FOUND);
			put(Exception.class, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	};

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	ResponseEntity<HttpError> handleException(Exception e) {
		HttpError error = new HttpError();
		error.setStatus(EXCEPTION_HTTPSTATUS.getOrDefault(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR));
		error.setMessage(e.getMessage());
		error.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<HttpError>(error, error.getStatus());
	}
}
