package com.ibm.academia.apirest.ruleta.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.ruleta.exceptions.NotFoundException;
import com.ibm.academia.apirest.ruleta.models.entities.Ruleta;
import com.ibm.academia.apirest.ruleta.repositories.RuletaRepository;
import com.ibm.academia.apirest.ruleta.services.IRuletaService;



@RestController
@RequestMapping("/ruleta")
public class RuletaController {

	Logger logger = LoggerFactory.getLogger(RuletaController.class);
	
	@Autowired
	private RuletaRepository ruletaRepository;

	@Autowired
	private IRuletaService ruletaService;

	/**
	 * Endpoint para lista ruletas
	 * @return Retorna una lista de ruletas
	 * @NotFoundException En caso de que no existan ruletas
	 * @author RAJA 20/12/2021
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarRuletas() {

		List<Ruleta> ruletas = ruletaService.buscarTodos();

		if (ruletas.isEmpty())
			throw new NotFoundException("No existen productos en la base de datos");

		return new ResponseEntity<List<Ruleta>>(ruletas, HttpStatus.OK);

	}
	
	/**
	 * Endpoint para consultar una ruleta
	 * @param productoid Parametro para la busqueda del objeto ruleta
	 * @return Retorna una objeto Ruleta
	 * @NotFoundException En caso de que no encuentre una coincidencia
	 * @author RAJA 20/12/2021
	 */
	@GetMapping("/ruletaId/{ruletaId}")
	public ResponseEntity<?> detalleRuleta(@PathVariable Integer ruletaId){
		
		Optional<Ruleta>  ruletas = ruletaService.buscarPorId(ruletaId);
		
		if(!ruletas.isPresent())
			throw new NotFoundException(String.format("El producto con ID: %d no existe", ruletaId));
		
		
		return new ResponseEntity<Ruleta>(ruletas.get(), HttpStatus.OK);

	}
	
	/**
	 * Endpoint para crear una nueva ruleta
	 * @param ruleta parametro que se utiliza para craer una nueva ruleta
	 * @return Retorna la nueva ruleta con todos su valores
	 * @author JARA 21/12/2021
	 */
	 @PostMapping
	  public ResponseEntity<?> crearRuleta(@RequestBody Ruleta ruleta){
	    
	    Ruleta ruletaGuardada = ruletaRepository.save(ruleta);
	    return new ResponseEntity<Ruleta>(ruletaGuardada, HttpStatus.CREATED);
	  }
	 
	/**
	 * Endpoint para realizar apuesta en la ruleta
	 * @param ruletaID parametro para buscar una ruleta
	 * @param numeroIngresado parametro que se ingresa para realizar la apuesta
	 * @param apuesta cantidad ingresada que se apuesta
	 * @return Retorna el resultado de la apuesta
	 * @author RAJA 21/12/2021
	 */
	 @GetMapping("/apuesta")
		public ResponseEntity<?> apuestas(@RequestParam(value = "ruletaId") Integer ruletaID, @RequestParam(value = "numeroIngresado") Integer numeroIngresado,
				@RequestParam(value = "apuesta") Double apuesta) {
			
			Double ruleta =  ruletaService.realizarApuesta(ruletaID, numeroIngresado, apuesta);
			
			return new ResponseEntity<Double>(ruleta, HttpStatus.OK);
			 
		}

}
