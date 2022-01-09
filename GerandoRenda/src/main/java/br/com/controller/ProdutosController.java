package br.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@GetMapping("/detalhe")
	public String detalhar() {
		return "detalhes do produto";
	}
	
}
