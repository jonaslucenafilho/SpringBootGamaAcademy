package com.primeira.api.apiRest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.primeira.api.apiRest.model.Produto;
import com.primeira.api.apiRest.model.Usuario;
import com.primeira.api.apiRest.repository.ProdutoRepository;
import com.primeira.api.apiRest.repository.UsuarioRepository;

@SpringBootApplication
public class ApiRestApplication implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario("Jonas Lucena", "joninhas");
		Usuario u2 = new Usuario("Marina Andrade", "nari");
		
		Produto p1 = new Produto("Televisão", 2000.00);
		Produto p2 = new Produto("Computador", 4500.00);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));	
		produtoRepository.saveAll(Arrays.asList(p1, p2));
	}
}
