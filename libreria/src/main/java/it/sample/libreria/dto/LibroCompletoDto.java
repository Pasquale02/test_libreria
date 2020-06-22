package it.sample.libreria.dto;

import java.util.Optional;

import it.sample.libreria.entities.Autore;

public class LibroCompletoDto {
	
	int id_libro;
	String isbn;
	String titolo;
	Double prezzo;
	
	Optional<Autore> autore;

	public LibroCompletoDto() {}
	public LibroCompletoDto(int id_libro, String isbn, String titolo, Double prezzo, Autore autore) {
		super();
		this.id_libro = id_libro;
		this.isbn = isbn;
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.autore = Optional.ofNullable(autore);
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int i) {
		this.id_libro = i;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Optional<Autore> getAutore() {
		return autore;
	}

	public void setAutore(Optional<Autore> autore2) {
		this.autore = autore2;
	}
}
