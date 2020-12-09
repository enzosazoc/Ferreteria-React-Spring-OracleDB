package com.example.ferreteria.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

@Entity(name = "ORDEN")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORDEN")
	@SequenceGenerator(name = "SEQ_ORDEN", sequenceName = "SEQ_ORDEN", allocationSize = 1)
	private Long idOrden;
	private int total;
	private String estado;
	private LocalDate fechaCreacion;
	private LocalDate fechaEnvio;
	
	@JoinColumn(name = "id_empleado")
	@OneToOne
	private Empleado empleado;
	
	@JoinColumn(name = "id_proveedor")
	@OneToOne
	private Proveedor proveedor;
	
	
	// Getters and setters
	public Long getIdOrden() {
		return idOrden;
	}
	
	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}
	
	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@PrePersist
	public void prePersist() {
		this.setFechaCreacion(LocalDate.now());
	}
	
}
