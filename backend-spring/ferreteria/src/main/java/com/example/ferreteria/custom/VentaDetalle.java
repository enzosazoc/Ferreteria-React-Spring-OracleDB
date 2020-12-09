package com.example.ferreteria.custom;

import java.util.List;

import com.example.ferreteria.entity.DetalleVenta;
import com.example.ferreteria.entity.Venta;

public class VentaDetalle {

	private Venta venta;
	
	private List<DetalleVenta> detallesVenta;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}
	
	
}
