package com.ibm.academia.apirest.ruleta.services;

import java.util.List;
import java.util.Optional;

import com.ibm.academia.apirest.ruleta.enums.Estatus;
import com.ibm.academia.apirest.ruleta.models.entities.Ruleta;

public interface IRuletaService {

	public List<Ruleta> buscarTodos();

	public Optional<Ruleta> buscarPorId(Integer id);
	
	public Double realizarApuesta(Integer id,Integer numeroIngresado, Double apuesta);
	
	public Ruleta FindRuletaById(Integer ruletaId);



}
