package it.sample.libreria.entities;

import java.util.HashSet;
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
	String nome;
	
	@OneToMany(mappedBy = "autore", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	Set<Libro> libri;

	public Autore() {}
	public Autore(int id, String nome) {
		this.id_autore = id;
		this.nome = nome;
	}
	
	public int getId_autore() {
		return id_autore;
	}

	public void setId_autore(int id_autore) {
		this.id_autore = id_autore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
