package com.example.ferreteria.service;

import java.util.List;

import com.example.ferreteria.custom.VentaDetalle;
import com.example.ferreteria.entity.Venta;

public interface IVentaService {
	
	public List<Venta> findAll();
	
	public Venta findById(Long idVenta);
	
	public Venta save(Venta venta);
	
	public Venta saveVentaDetalle(VentaDetalle ventaDetalle);
	
	public Venta update(Venta venta, Long idVenta);
	
	public void delete(Long idVenta);
	
}
