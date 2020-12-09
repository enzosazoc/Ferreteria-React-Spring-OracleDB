package com.example.ferreteria.service;

import java.util.List;

import com.example.ferreteria.entity.Proveedor;

public interface IProveedorService {
	
	public List<Proveedor> findAll();
	
	public Proveedor findById(Long idProveedor);
	
	public Proveedor save(Proveedor proveedor);
	
	public Proveedor update(Proveedor proveedor, Long idProveedor);
	
	public void delete(Long idProveedor);

}
