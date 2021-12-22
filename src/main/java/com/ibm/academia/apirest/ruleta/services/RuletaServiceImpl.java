package com.ibm.academia.apirest.ruleta.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.ruleta.enums.Estatus;
import com.ibm.academia.apirest.ruleta.exceptions.BadRequestException;
import com.ibm.academia.apirest.ruleta.exceptions.NotFoundException;
import com.ibm.academia.apirest.ruleta.models.entities.Ruleta;
import com.ibm.academia.apirest.ruleta.repositories.RuletaRepository;

@Service
public class RuletaServiceImpl implements IRuletaService {

	@Autowired
	private RuletaRepository ruletaRepository;

	@Autowired
	private IRuletaService ruletaService;

	@Override
	@Transactional
	public List<Ruleta> buscarTodos() {

		return (List<Ruleta>) ruletaRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Ruleta> buscarPorId(Integer id) {

		return ruletaRepository.findById(id);
	}

	private Integer numeroRuleta = (int) (Math.random() * 0 + 36);
	
	@Override
	@Transactional
	public Double realizarApuesta(Integer ruletaId, Integer numeroIngresado, Double apuesta) {

		List<Ruleta> ruletas = (List<Ruleta>) ruletaRepository.FindRuletaById(ruletaId);

		if (Estatus.CERRADA.equals(ruletas)) {

			throw new NotFoundException(String.format("La ruleta %d se encuentra cerrada por el momento", ruletaId));

		} else if (Estatus.ABIERTA.equals(ruletas)) {

		}
		if (numeroIngresado == numeroRuleta) {

			return apuesta * 2;

		} else if (numeroIngresado != numeroRuleta) {

			throw new NotFoundException("Apuesta perdida");
		}

		return null;

	}

	@Override
	public Ruleta FindRuletaById(Integer ruletaId) {

		return ruletaRepository.FindRuletaById(ruletaId);
	}

}
