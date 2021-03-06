package it.sample.libreria.services;

import java.util.List;
import java.util.Optional;

import it.sample.libreria.dto.LibroCompletoDto;
import it.sample.libreria.entities.Libro;

public interface ILibroService {

	public List<Libro> findAll();	
	
	public Optional<Libro> findById(int id);
	
	public Libro save(Libro libro);
	
	public void deleteById(int id);
	
	public Optional<Libro> cercaPerIsbnCode(String isbn);
	
	public Libro findByIsbn(String isbn);
	
	public List<LibroCompletoDto> cercaLibriPerAutore(int id_autore);

}
