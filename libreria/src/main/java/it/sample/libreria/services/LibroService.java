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
	
	@Override
	public List<Libro> findAll() {
		return libroRepo.findAll();
	}

	@Override
	public Optional<Libro> findById(int id) {
		return libroRepo.findById(id);
	}

	@Override
	public Optional<Libro> cercaPerIsbnCode(String isbn) {
		// TODO Auto-generated method stub
		return libroRepo.cercaPerIsbnCode(isbn);
	}

}
