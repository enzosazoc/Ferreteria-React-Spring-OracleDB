package com.example.ferreteria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DETALLE_VENTA")
	@SequenceGenerator(name = "SEQ_DETALLE_VENTA", sequenceName = "SEQ_DETALLE_VENTA", allocationSize = 1)
	private Long idDetalleVenta;
	private int precioUnitario;
	private int cantidad;
	private int total;
	
	@JoinColumn(name = "id_producto")
	@ManyToOne
	private Producto producto;

	@JoinColumn(name = "id_venta", referencedColumnName = "idVenta")
	@ManyToOne(optional = false)
	private Venta venta;
	
	// Getters and setters
	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
}
