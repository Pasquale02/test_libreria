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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_libro")
	int id_libro;
	
	@Column(name = "isbn")
	String isbn;
	
	@Column(name = "titolo")
	String titolo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
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
}
