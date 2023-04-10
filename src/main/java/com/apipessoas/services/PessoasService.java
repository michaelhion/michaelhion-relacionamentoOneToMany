package com.apipessoas.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apipessoas.exceptions.NotFoundException;
import com.apipessoas.models.Endereco;
import com.apipessoas.models.Pessoas;
import com.apipessoas.repositories.EnderecoRepository;
import com.apipessoas.repositories.PessoaRepository;

@Service
public class PessoasService {

	public static Logger logger = Logger.getLogger(PessoasService.class.getName());
	@Autowired
	private PessoaRepository repo;
	
	@Autowired
	private EnderecoRepository endRepo;
	
	/**
	 * foi necessário salvar primeiro os dados da tabela pessoa
	 * e depois os dados da tabela endereço pois dava erro de constraint violation
	 * após isso recebi erro de entity detached e resolvi com saveandflush
	 * também foi necessário colocar jsonignore no campo pessoas na tabela Endereço
	 * **/
	public Pessoas adicionarOuAlterar(Pessoas model) {
		Pessoas p = new Pessoas();
		p.setNome(model.getNome());
		p.setDt_nascimento(model.getDt_nascimento());
		p.setId(model.getId());
		this.repo.saveAndFlush(p);
		List<Endereco> list = model.getEnderecos();
		for (Endereco end : list) {
			Endereco endereco = new Endereco();
			endereco.setCep(end.getCep());
			endereco.setLogradouro(end.getLogradouro());
			endereco.setNr_casa(end.getNr_casa());
			endereco.setPessoas(p);
			this.endRepo.save(endereco);
		}
		
		
		return model;	
	}
	
	public List<Pessoas> listar(){
		return this.repo.findAll();
	}
	
	public Pessoas buscarPorId(Long id){
		return this.repo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	
	public void excluir(Long id){
		this.repo.deleteById(id);
	}
	
}
