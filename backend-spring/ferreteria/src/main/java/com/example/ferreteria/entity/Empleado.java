package com.example.ferreteria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLEADO")
	@SequenceGenerator(name = "SEQ_EMPLEADO", sequenceName = "SEQ_EMPLEADO", allocationSize = 1)
	private Long idEmpleado;
	private String run;
	private String nombres;
	private String apellidoP;
	private String apellidoM;
	
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public String getRun() {
		return run;
	}
	
	public void setRun(String run) {
		this.run = run;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidoP() {
		return apellidoP;
	}
	
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	
	public String getApellidoM() {
		return apellidoM;
	}
	
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	
}
