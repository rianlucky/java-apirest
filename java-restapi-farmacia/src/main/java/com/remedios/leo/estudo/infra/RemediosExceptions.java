package com.remedios.leo.estudo.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice //responsavel por tratar as excecoes
public class RemediosExceptions  {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> tratar404() {
		return ResponseEntity.notFound().build(); //.notFound = 404 error
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>tratar400(MethodArgumentNotValidException e){
		var error = e.getFieldErrors();
		return ResponseEntity.badRequest().body(error.stream().map(DadosErros::new).toList());  //400 = bad request
	}
	public record DadosErros(String Campo, String Mensagem) {
		public DadosErros(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
