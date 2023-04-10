package com.apipessoas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apipessoas.models.Pessoas;

public interface PessoaRepository extends JpaRepository<Pessoas, Long>{
	public Pessoas findByNome(String nome);
}
