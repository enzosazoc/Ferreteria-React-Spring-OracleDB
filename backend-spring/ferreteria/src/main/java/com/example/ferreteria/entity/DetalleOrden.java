package com.example.ferreteria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DETALLE_ORDEN")
	@SequenceGenerator(name = "SEQ_DETALLE_ORDEN", sequenceName = "SEQ_DETALLE_ORDEN", allocationSize = 1)
	private Long idDetalleOrden;
	private int precioUnitario;
	private int cantidad;
	private int total;
	
	@JoinColumn(name = "id_producto")
	@ManyToOne
	private Producto producto;
	
	@JoinColumn(name = "id_orden", referencedColumnName = "idOrden")
	@ManyToOne
	private Orden orden;

	
	// Getters and setters
	public Long getIdDetalleOrden() {
		return idDetalleOrden;
	}

	public void setIdDetalleOrden(Long idDetalleOrden) {
		this.idDetalleOrden = idDetalleOrden;
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

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
	

}
