package it.sample.libreria.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="autori")
public class Autore implements java.io.Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autore")
	int id_autore;
	
	@Column(name = "nome_autore")
	String nome_autore;
	
	@OneToMany(mappedBy = "autore", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	Set<Libro> libri;

	public Autore() {}
	public Autore(int id_autore, String nome_autore) {
		this.id_autore = id_autore;
		this.nome_autore = nome_autore;
	}
	
	public int getId_autore() {
		return id_autore;
	}

	public void setId_autore(int id_autore) {
		this.id_autore = id_autore;
	}

	public String getNome_autore() {
		return nome_autore;
	}

	public void setNome_autore(String nome_autore) {
		this.nome_autore = nome_autore;
	}
}
