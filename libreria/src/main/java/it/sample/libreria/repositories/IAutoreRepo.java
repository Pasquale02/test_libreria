package it.sample.libreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.sample.libreria.dto.LibroCompletoDto;
import it.sample.libreria.entities.Autore;
import it.sample.libreria.entities.Libro;

public interface IAutoreRepo extends JpaRepository<Autore, Integer>{

	// la seg query di base funziona
	@Query("select lib from Libro lib "
			+ "where lib.autore.id_autore=:id_autore")
	
	// elenco autori
	/*@Query("select aut from Autore aut "
			+ "join aut.libri libri "
			+ "where libri.autore.id_autore=:id_autore")*/
	
	List<Libro> cercaLibriPerAutore(@Param("id_autore") int id_autore);

}
