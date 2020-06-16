package it.sample.libreria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sample.libreria.entities.Autore;
import it.sample.libreria.services.IAutoreService;

@RestController
@RequestMapping("/api")
public class AutoreController {
	
	// commit
	@Autowired
	IAutoreService autoreService;
	
	@GetMapping(value="/cercaAutore/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Autore>> get(@PathVariable("id") int idAutore) {
		
		Optional<Autore> autore = Optional.ofNullable(new Autore());
		autore = autoreService.findById(idAutore);
		
		return ResponseEntity.ok(autore);
	}
	
	@GetMapping(value="/elencoAutori", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Autore>> findAll() {
		
		List<Autore> autori = autoreService.findAll();
		
		return ResponseEntity.ok(autori);
	}

}
