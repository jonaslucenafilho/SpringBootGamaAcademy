package com.primeira.api.apiRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeira.api.apiRest.model.Usuario;
import com.primeira.api.apiRest.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario update(Integer id, Usuario usuario) {
		Usuario updateObj = findById(id);
		updateObj.setNome(usuario.getNome());
		updateObj.setSenha(usuario.getSenha());
		return usuarioRepository.save(updateObj);
	}
	
	public void delete(Integer id) {
		Usuario deleteObj = findById(id);
		usuarioRepository.delete(deleteObj);
	}
	
	public Usuario create(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}
}
