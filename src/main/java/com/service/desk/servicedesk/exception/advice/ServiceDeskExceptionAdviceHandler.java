package com.service.desk.servicedesk.exception.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.desk.servicedesk.exception.ServiceDeskError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ServiceDeskExceptionAdviceHandler extends ResponseEntityExceptionHandler {

	   @Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new ServiceDeskError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ServiceDeskError serviceDeskError) {
	       return new ResponseEntity<>(serviceDeskError, serviceDeskError.getStatus());
	   }
	}

