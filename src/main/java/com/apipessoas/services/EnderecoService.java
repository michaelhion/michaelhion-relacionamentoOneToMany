package com.apipessoas.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apipessoas.exceptions.NotFoundException;
import com.apipessoas.models.Endereco;
import com.apipessoas.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	public static Logger logger = Logger.getLogger(EnderecoService.class.getName());
	@Autowired
	private EnderecoRepository repo;
	
	
	public Endereco adicionarOuAlterar(Endereco model) {
		this.repo.save(model);
		return model;	
	}
	
	public List<Endereco> listar(){
		return this.repo.findAll();
	}
	
	public Endereco buscarPorId(Long id){
		return this.repo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	
	public void excluir(Long id){
		this.repo.deleteById(id);
	}
	
	public List<Endereco> buscarPorIdPessoa(Long idPessoa) {
		return this.repo.buscarPorIdPessoa(idPessoa);
	}
	
}
