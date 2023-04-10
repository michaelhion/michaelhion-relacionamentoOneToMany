package com.apipessoas.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end_generator")
	@SequenceGenerator(name="end_generator", sequenceName = "end_seq", allocationSize=50)
	private Long id;
	
	
	private String logradouro;
	
	
	private String cep;
	
	
	private String nr_casa;
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id" )
	@JsonIgnore
	private Pessoas pessoas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNr_casa() {
		return nr_casa;
	}

	public void setNr_casa(String nr_casa) {
		this.nr_casa = nr_casa;
	}
	
	@Override
	public String toString() {
		return "\n rua :" + this.logradouro + "\n cep: " + this.cep + "\n numeroDaCasa : " + this.nr_casa;
	}

	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
}
