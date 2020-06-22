package it.sample.libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sample.libreria.dto.LibroCompletoDto;
import it.sample.libreria.entities.Autore;
import it.sample.libreria.entities.Libro;
import it.sample.libreria.repositories.IAutoreRepo;

@Service
public class AutoreService implements IAutoreService {
	@Autowired
	IAutoreRepo autoreRepo;
	
	public List<Autore> findAll() {
		System.out.println("result==" + autoreRepo.findAll().toString());
		return autoreRepo.findAll();
	}

	public Optional<Autore> findById(int id) {
		return autoreRepo.findById(id);
	}

	public List<Libro> cercaLibriPerAutore(int id_autore) {		
		return autoreRepo.cercaLibriPerAutore(id_autore);
	}

	public Autore save(Autore autore) {
		
		//Autore autore = new Autore();
		//autore.setNome_autore(autoreDto.getNome_autore());
		//autore.setCognome_autore(autoreDto.getCognome_autore());
		return autoreRepo.save(autore);
	}

	public void deleteById(int id) {
		autoreRepo.deleteById(id);
	}
}
