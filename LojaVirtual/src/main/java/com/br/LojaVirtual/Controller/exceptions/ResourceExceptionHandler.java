package com.br.LojaVirtual.Controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.LojaVirtual.Services.execeptions.DataIntegrityViolationException;
import com.br.LojaVirtual.Services.execeptions.ObjectnotFoundException;

import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Object Not Found", ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Violação de dados", ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> dataIntegrityViolationException(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

				ValidationError erros = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
					"Validation error", "Erro na validação de campos ", request.getRequestURI());

		for (FieldError x : ex.getBindingResult().getFieldErrors()){
			erros.addError( x.getField(), x.getDefaultMessage());
		}
					

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
}
