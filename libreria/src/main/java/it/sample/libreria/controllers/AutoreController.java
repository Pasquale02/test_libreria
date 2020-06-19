package it.sample.libreria.controllers;

import java.util.List;
import java.util.Optional;

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

import it.sample.libreria.dto.AutoreDto;
import it.sample.libreria.entities.Autore;
import it.sample.libreria.services.IAutoreService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AutoreController {
	
	@Autowired
	IAutoreService autoreService;
	
	@PostMapping(value="/inserisciAutore", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Autore> inserisciAutore(@RequestBody AutoreDto autore) {
		
		System.out.println("Autore " + autore.toString());		
		Autore nuovoAutore = autoreService.save(autore);
		System.out.println("Autore " + nuovoAutore.toString());
		
		return ResponseEntity.ok(nuovoAutore);
	}
	
	@GetMapping(value="/cercaAutore/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Autore>> get(@PathVariable("id") int idAutore) {
		
		Optional<Autore> autore = autoreService.findById(idAutore);
		if (!autore.isPresent()) {
            System.out.println("Id " + idAutore + " non esiste");
            return ResponseEntity.badRequest().build();
        }
		
		return ResponseEntity.ok(autore);
	}
	
	@GetMapping(value="/elencoAutori", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Autore>> findAll() {
		
		List<Autore> autori = autoreService.findAll();
		
		return ResponseEntity.ok(autori);
	}
	
    @PutMapping("/updateAutore/{id}")
    public ResponseEntity<Autore> update(@PathVariable int id, @RequestBody AutoreDto autore) {
        if (!autoreService.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(autoreService.save(autore));
    }
    
    @DeleteMapping("deleteAutore/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!autoreService.findById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        autoreService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
