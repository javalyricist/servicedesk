package com.service.desk.servicedesk.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.desk.servicedesk.service.IServiceDesk;

public class ServiceDeskError implements IServiceDesk{

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;

	private ServiceDeskError() {
		timestamp = LocalDateTime.now();
	}

	public ServiceDeskError(HttpStatus status) {
		this();
		this.status = status;
	}

	public ServiceDeskError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ServiceDeskError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
