package com.apipessoas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apipessoas.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	@Query("SELECT e FROM Endereco e where e.pessoas.id = :idPessoa")
	public List<Endereco> buscarPorIdPessoa(@Param("idPessoa")Long idPessoa);
}
