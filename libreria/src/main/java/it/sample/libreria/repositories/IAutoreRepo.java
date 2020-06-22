package it.sample.libreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.sample.libreria.entities.Autore;

public interface IAutoreRepo extends JpaRepository<Autore, Integer>{
}
