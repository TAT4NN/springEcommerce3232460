package com.sena.springEcommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.springEcommerce.model.Orden;
import com.sena.springEcommerce.model.Usuario;

public interface IOrdenService {

	public Orden save(Orden orden);
	
	public List<Orden> findAll();
	
	public List<Orden> findByUsuario(Usuario usuario);
	
	public Optional<Orden> findById(Integer id);
	
	public String generarNumeroOrden();
}
