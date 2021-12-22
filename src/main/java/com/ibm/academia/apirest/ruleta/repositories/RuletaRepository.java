package com.ibm.academia.apirest.ruleta.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ibm.academia.apirest.ruleta.models.entities.Ruleta;

public interface RuletaRepository extends PagingAndSortingRepository<Ruleta, Integer> {
	
	@Query("select r.estatus from Ruleta r where r.id = ?1")
	public Ruleta FindRuletaById(Integer ruletaId);

	

}
