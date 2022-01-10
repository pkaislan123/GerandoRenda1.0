package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.Imagens;
import br.com.model.Produtos;
import br.com.repository.ImagensRepository;
import br.com.repository.ProdutosRepository;

@RestController
@RequestMapping("/v1/imagens")
public class ImagensController {

	@Autowired
	ImagensRepository imagensRepository;
	
	@GetMapping("/listar")
	public List<Imagens> listar() {
		return imagensRepository.findAll();
	}
	
}
