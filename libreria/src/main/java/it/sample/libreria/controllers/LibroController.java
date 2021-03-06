package it.sample.libreria.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sample.libreria.dto.LibroCompletoDto;
import it.sample.libreria.entities.Libro;
import it.sample.libreria.services.IAutoreService;
import it.sample.libreria.services.ILibroService;
import it.sample.libreria.services.LibroService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
	
	 private static final Logger LOGGER = LogManager.getLogger(LibroController.class);
	 
	@Autowired
	ILibroService libroService;
	
	@Autowired
	IAutoreService autoreService;
	
	@PostMapping(value="/inserisciLibro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> inserisciAutore(@RequestBody Libro libro) {
		
		System.out.println("Autore " + libro.toString());		
		Libro nuovolibro = libroService.save(libro);
		System.out.println("Autore " + nuovolibro.toString());
		
		return ResponseEntity.ok(nuovolibro);
	}
	
	@GetMapping(value="/libro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Libro>> get(@PathVariable("id") int idLibro) {
		
		Optional<Libro> libro = Optional.ofNullable(new Libro());
		libro = libroService.findById(idLibro);
		
		return ResponseEntity.ok(libro);
	}
	
	@GetMapping(value="/libri", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> findAll() {
        
		List<Libro> libri = libroService.findAll();
		
        LOGGER.debug("[DEBUG LOGGER] {}", libri);
		
		return ResponseEntity.ok(libri);
	}
	
	@GetMapping(value="/libri/autore/{id_autore}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibroCompletoDto>> cercaLibriPerAutore(@PathVariable("id_autore") int id_autore) {
		
		List<LibroCompletoDto> libri = libroService.cercaLibriPerAutore(id_autore);
		
		return ResponseEntity.ok(libri);
	}
	
	@GetMapping(value="/libro/isbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> get(@PathVariable("isbn") String isbn) {
		
		// Optional<Libro> libro = Optional.ofNullable(new Libro());
		// libro = libroService.cercaPerIsbnCode(isbn);
		
		// se usi findBy non mettere nullable
		Libro libro = new Libro();
		libro = libroService.findByIsbn(isbn);
		
		return ResponseEntity.ok(libro);
	}
	
    @PutMapping("/libro/update/{id}")
    public ResponseEntity<Libro> update(@PathVariable int id, @RequestBody Libro libro) {
        if (!libroService.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(libroService.save(libro));
    }
    
    @DeleteMapping("libro/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!libroService.findById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        libroService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
