package it.sample.libreria.entities;

import java.util.Date;
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
	
	@Column(name = "cognome_autore")
	String cognome_autore;

	@Column(name = "data_nascita_autore")
	Date data_nascita_autore;
	
	@OneToMany(mappedBy = "autore", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	Set<Libro> libri;
	
	public Autore() {}	
	public Autore(int id_autore, String nome_autore, String cognome_autore, Date data_nascita_autore) {
		super();
		this.id_autore = id_autore;
		this.nome_autore = nome_autore;
		this.cognome_autore = cognome_autore;
		this.data_nascita_autore = data_nascita_autore;
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
	public String getCognome_autore() {
		return cognome_autore;
	}
	public void setCognome_autore(String cognome_autore) {
		this.cognome_autore = cognome_autore;
	}
	public Date getData_nascita_autore() {
		return data_nascita_autore;
	}
	public void setData_nascita_autore(Date data_nascita_autore) {
		this.data_nascita_autore = data_nascita_autore;
	}
	
    @Override
    public String toString() {
        return "Autore [id_autore=" + id_autore + ", nome_autore=" + nome_autore + ", cognome_autore=" + cognome_autore + ", data_nascita_autore=" + data_nascita_autore
       + "]";
    }
	
}
