package it.sample.libreria.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sample.libreria.dto.LibroCompletoDto;
import it.sample.libreria.entities.Autore;
import it.sample.libreria.entities.Libro;
import it.sample.libreria.repositories.ILibroRepo;

@Service
@Transactional
public class LibroService implements ILibroService{

	@Autowired
	ILibroRepo libroRepo;
	
	@Autowired 
	IAutoreService autoreRepo;
	
	public List<Libro> findAll() {
		return libroRepo.findAll();
	}

	public Optional<Libro> findById(int id) {
		return libroRepo.findById(id);
	}

	public Optional<Libro> cercaPerIsbnCode(String isbn) {
		return libroRepo.cercaPerIsbnCode(isbn);
	}
	
	public Libro findByIsbn(String isbn) {
		return libroRepo.findByIsbn(isbn);
	}
	
	public List<LibroCompletoDto> cercaLibriPerAutore(int id_autore) {	
		
		Optional<Autore> autore = autoreRepo.findById(id_autore);
		List<Libro> listLibri = libroRepo.cercaLibriPerAutore(id_autore);
		
		// output
		List<LibroCompletoDto> elencoLibriDto = new ArrayList<LibroCompletoDto>();
		
		for (Libro item : listLibri) {
			LibroCompletoDto newLibroDto = new LibroCompletoDto();
			newLibroDto.setId_libro(item.getId_libro());
			newLibroDto.setTitolo(item.getTitolo());
			newLibroDto.setIsbn(item.getIsbn());
			newLibroDto.setPrezzo(item.getPrezzo());
			newLibroDto.setAutore(autore);
			elencoLibriDto.add(newLibroDto);
		}
		
		return elencoLibriDto;
	}

	public Libro save(Libro libro) {
		return libroRepo.save(libro);
	}

	public void deleteById(int id) {
		libroRepo.deleteById(id);		
	}
}
