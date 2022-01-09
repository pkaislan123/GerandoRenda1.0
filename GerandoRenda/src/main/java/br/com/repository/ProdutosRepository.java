package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{

	List<Produtos>findByTitulo(int id);

}
