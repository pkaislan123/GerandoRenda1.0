package br.com.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.model.Produtos;
import br.com.repository.ProdutosRepository;

@RestController
@CrossOrigin
@RequestMapping("/v1/produtos")
public class ProdutosController {

	@Autowired
	ProdutosRepository produtosRepository;
	
	
	@GetMapping("/listar")
	public List<Produtos> listar() {
		return produtosRepository.findAll();
	}
	
	@GetMapping("/listarPorId/{id}")
	public Optional<Produtos> listar(@PathVariable int id) {
		return produtosRepository.findById(id);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cadastrar")
	public boolean cadastrar(@RequestBody Produtos produto) {
		return produtosRepository.save(produto) != null;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(path = "/excluir/{id}")
	@Transactional  
	public ResponseEntity<Void> excluirClassificador(@PathVariable int id) {
		
		produtosRepository.deleteById(id);
		return ResponseEntity.noContent().build();

	}
}
