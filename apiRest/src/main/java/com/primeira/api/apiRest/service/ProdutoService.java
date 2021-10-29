package com.primeira.api.apiRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeira.api.apiRest.model.Produto;
import com.primeira.api.apiRest.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto update(Integer id, Produto produto) {
		Produto updateProduto = findById(id);
		updateProduto.setNome(produto.getNome());
		updateProduto.setPreco(produto.getPreco());
		return produtoRepository.save(updateProduto);
	}
	
	public void delete(Integer id) {
		Produto deleteProduto = findById(id);
		produtoRepository.delete(deleteProduto);
	}
	
	public Produto create(Produto produto) {
		Produto createProduto = new Produto(produto.getNome(), produto.getPreco());
		return produtoRepository.save(createProduto);
	}
}
