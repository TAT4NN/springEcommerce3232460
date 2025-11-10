package com.sena.springEcommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.springEcommerce.model.Usuario;

public interface IUsuarioService {

	//Métodos CRUD
	
	public Usuario save(Usuario usuario);

	public Optional<Usuario> get(Integer id);

	public void update(Usuario usuario);

	public void delete(Integer id);

	Optional<Usuario> findById(Integer id);

	Optional<Usuario> findByEmail(String email);

	List<Usuario> findAll();
}
