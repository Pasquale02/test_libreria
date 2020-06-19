package it.sample.libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sample.libreria.entities.Autore;
import it.sample.libreria.entities.Libro;
import it.sample.libreria.repositories.IAutoreRepo;

@Service
public class AutoreService implements IAutoreService {
	@Autowired
	IAutoreRepo autoreRepo;
	
	@Override
	public List<Autore> findAll() {
		return autoreRepo.findAll();
	}

	@Override
	public Optional<Autore> findById(int id) {
		return autoreRepo.findById(id);
	}

	@Override
	public List<Libro> cercaLibriPerAutore(int id_autore) {
		return autoreRepo.cercaLibriPerAutore(id_autore);
	}

	@Override
	public Autore save(Autore autore) {
		// TODO Auto-generated method stub
		return autoreRepo.save(autore);
	}

	@Override
	public void deleteById(int id) {
		autoreRepo.deleteById(id);
	}
}
