package com.example.ferreteria.service;

import java.util.List;

import com.example.ferreteria.custom.OrdenDetalle;
import com.example.ferreteria.entity.Orden;

public interface IOrdenService {

	public List<Orden> findAll();
	
	public Orden findById(Long idOrden);
	
	public Orden save(Orden orden);
	
	public Orden saveOrdenDetalle(OrdenDetalle ordenDetalle);
	
	public Orden update(Orden orden, Long idOrden);
	
	public void delete(Long idOrden);
}
