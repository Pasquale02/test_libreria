package it.sample.libreria.services;

import java.util.List;
import java.util.Optional;

import it.sample.libreria.entities.Autore;

public interface IAutoreService {
	
	public List<Autore> findAll();	
	
	public Optional<Autore> findById(int id);
	
	public Autore save(Autore autore);
	
	public void deleteById(int id);	
}
