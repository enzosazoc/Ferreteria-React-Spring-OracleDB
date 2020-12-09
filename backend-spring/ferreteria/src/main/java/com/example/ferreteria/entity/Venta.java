package com.example.ferreteria.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

@Entity(name = "VENTA")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VENTA")
	@SequenceGenerator(name = "SEQ_VENTA", sequenceName = "SEQ_VENTA", allocationSize = 1)
	private Long idVenta;
	private int total;
	private String estado;
	private LocalDate fecha;
	
	
	// Getters and setters
	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	@PrePersist
	public void prePersist() {
		this.setFecha(LocalDate.now());
	}
	
}
