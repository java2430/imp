package com.vaesoft.imp.web.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vaesoft.imp.web.model.ActionResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	ActionResult handleException(Exception e) {
		return ActionResult.newErrorActionResult(e.getMessage());
	}
}
