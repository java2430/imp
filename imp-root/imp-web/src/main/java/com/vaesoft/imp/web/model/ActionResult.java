package com.vaesoft.imp.web.model;

public class ActionResult {

	private Meta meta = new Meta();

	private Object data;

	public static ActionResult newSuccessActionResult(String message) {
		return newSuccessActionResult(message, null);
	}

	public static ActionResult newSuccessActionResult(String message, Object data) {
		ActionResult result = new ActionResult();
		result.setSuccess(true);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public static ActionResult newErrorActionResult(String message) {
		return newErrorActionResult(message, null);
	}

	public static ActionResult newErrorActionResult(String message, Object data) {
		ActionResult result = new ActionResult();
		result.setSuccess(false);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setSuccess(boolean success) {
		this.meta.setSuccess(success);
	}

	public void setMessage(String message) {
		this.meta.setMessage(message);
	}

	public void setCode(String code) {
		this.meta.setCode(code);
	}

	class Meta {
		private boolean success;
		private String code;

		private String message;

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
