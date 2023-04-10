package com.apipessoas.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apipessoas.models.Pessoas;
import com.apipessoas.services.PessoasService;

@RestController
@RequestMapping("api-pessoas")
public class PessoasController {

	@Autowired
	private PessoasService serv;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		
			return new ResponseEntity<>(this.serv.listar(), HttpStatus.OK);

	}

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
		
			return new ResponseEntity<>(this.serv.buscarPorId(id), HttpStatus.OK);

	}

	@PostMapping("/adicionar")
	@Transactional
	public ResponseEntity<?> adicionar(@RequestBody Pessoas pessoa) {
			this.serv.adicionarOuAlterar(pessoa);
			return new ResponseEntity<>("Pessoa criada!", HttpStatus.CREATED);
		
	}

	@PatchMapping("/alterar/{id}")
	public ResponseEntity<?> alterar(@PathVariable("id")Long id, @RequestBody Pessoas pessoa) {
		
				return new ResponseEntity<Pessoas>(this.serv.adicionarOuAlterar(pessoa), HttpStatus.ACCEPTED);
			}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
				this.serv.excluir(id);	
				return new ResponseEntity<>("Registro excluido com sucesso!", HttpStatus.ACCEPTED);
		
	}
}
