package com.ibm.academia.apirest.ruleta.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.apirest.ruleta.exceptions.NotFoundException;



public class RuletaException {
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<?> noExisteException(NotFoundException exception){
		Map<String, Object> respuesta =  new HashMap<String, Object>();
		respuesta.put("error", exception.getMessage());
		return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		
	}


}
