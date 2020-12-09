package com.example.ferreteria.custom;

import java.util.List;

import com.example.ferreteria.entity.DetalleOrden;
import com.example.ferreteria.entity.Orden;

public class OrdenDetalle {

	private Orden orden;
	
	private List<DetalleOrden> detallesOrden;

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public List<DetalleOrden> getDetallesOrden() {
		return detallesOrden;
	}

	public void setDetallesOrden(List<DetalleOrden> detallesOrden) {
		this.detallesOrden = detallesOrden;
	}
	
	
}
