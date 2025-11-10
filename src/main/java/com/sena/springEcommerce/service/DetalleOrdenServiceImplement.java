package com.sena.springEcommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.springEcommerce.model.DetalleOrden;

@Service
public class DetalleOrdenServiceImplement  implements IDetalleOrdenService{

	@Autowired
    private IDetalleOrdenService detalleOrdenRepository;


	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		// TODO Auto-generated method stub
		return detalleOrdenRepository.save(detalleOrden);
	}

}
