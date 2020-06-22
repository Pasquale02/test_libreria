package it.sample.libreria.dto;

import it.sample.libreria.entities.Autore;

public class LibroCompletoDto {
	
	String id_libro;
	String isbn;
	String titolo;
	Double prezzo;
	
	Autore autore;

	public LibroCompletoDto() {}
	public LibroCompletoDto(String id_libro, String isbn, String titolo, Double prezzo, Autore autore) {
		super();
		this.id_libro = id_libro;
		this.isbn = isbn;
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.autore = autore;
	}

	public String getId_libro() {
		return id_libro;
	}

	public void setId_libro(String id_libro) {
		this.id_libro = id_libro;
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

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
}
