package it.sample.libreria.services;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.sample.libreria.entities.Libro;
import it.sample.libreria.repositories.ILibroRepo;

@Service
@Transactional
public class LibroService implements ILibroService{

	@Autowired
	ILibroRepo libroRepo;
	
	public List<Libro> findAll() {
		return libroRepo.findAll();
	}

	public Optional<Libro> findById(int id) {
		return libroRepo.findById(id);
	}

	public Optional<Libro> cercaPerIsbnCode(String isbn) {
		return libroRepo.cercaPerIsbnCode(isbn);
	}
	
	public List<Libro> cercaLibriPerAutore(int id_autore) {		
		return libroRepo.cercaLibriPerAutore(id_autore);
	}

	public Libro save(Libro libro) {
		return libroRepo.save(libro);
	}

	public void deleteById(int id) {
		libroRepo.deleteById(id);		
	}
}
