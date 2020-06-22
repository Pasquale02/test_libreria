package it.sample.libreria.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.sample.libreria.entities.Libro;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Integer>{
	
	@Query("select lib from Libro lib where lib.isbn=:isbn")
	Optional<Libro> cercaPerIsbnCode(@Param("isbn") String isbn);
	
	@Query("select lib from Libro lib "
			+ "where lib.autore.id_autore=:id_autore")	
	List<Libro> cercaLibriPerAutore(@Param("id_autore") int id_autore);
}
