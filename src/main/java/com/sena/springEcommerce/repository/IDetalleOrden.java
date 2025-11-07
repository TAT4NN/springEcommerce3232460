package com.sena.springEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.springEcommerce.model.DetalleOrden;

@Repository
public interface IDetalleOrden  extends JpaRepository<DetalleOrden, Integer>{
	
	
}
