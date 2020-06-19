package it.sample.libreria.dto;

public class AutoreDto {
	int id_autore;
	
	String nome_autore;
	
	String cognome_autore;

	public AutoreDto() {}
	public AutoreDto(int id_autore, String nome_autore, String cognome_autore) {
		super();
		this.id_autore = id_autore;
		this.nome_autore = nome_autore;
		this.cognome_autore = cognome_autore;
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
	
	

}
