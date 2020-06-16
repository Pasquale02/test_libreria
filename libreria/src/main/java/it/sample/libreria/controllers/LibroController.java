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
import it.sample.libreria.entities.Libro;
import it.sample.libreria.services.IAutoreService;
import it.sample.libreria.services.ILibroService;

@RestController
@RequestMapping("/api")
public class LibroController {
	
	@Autowired
	ILibroService libroService;
	
	@Autowired
	IAutoreService autoreService;
	
	@GetMapping(value="/cercaLibro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Libro>> get(@PathVariable("id") int idLibro) {
		
		Optional<Libro> libro = Optional.ofNullable(new Libro());
		libro = libroService.findById(idLibro);
		
		return ResponseEntity.ok(libro);
	}
	
	@GetMapping(value="/elencoLibri", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> findAll() {
		
		List<Libro> libri = libroService.findAll();
		
		return ResponseEntity.ok(libri);
	}
	
	@GetMapping(value="/cercaLibriPerAutore/{id_autore}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> cercaLibriPerAutore(@PathVariable("id_autore") int id_autore) {
		
		List<Libro> libri = autoreService.cercaLibriPerAutore(id_autore);
		
		return ResponseEntity.ok(libri);
	}
	
	@GetMapping(value="/cercaIsbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Libro>> get(@PathVariable("isbn") String isbn) {
		
		Optional<Libro> libro = Optional.ofNullable(new Libro());
		libro = libroService.cercaPerIsbnCode(isbn);
		
		return ResponseEntity.ok(libro);
	}
	
}
