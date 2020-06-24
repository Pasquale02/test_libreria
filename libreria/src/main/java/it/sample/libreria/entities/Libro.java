package it.sample.libreria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libri")
public class Libro implements java.io.Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
	int id_libro;
	
	@Column(name = "isbn")
	String isbn;
	
	@Column(name = "titolo")
	String titolo;
	
	@Column(name="prezzo")
	Double prezzo;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="id_autore", referencedColumnName = "id_autore")
	Autore autore;
	
	public Libro () {}
	public Libro(int id, String titolo) {
		this.id_libro = id;
		this.titolo = titolo;
	}
	
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
