package com.example.ferreteria.service;

import java.util.List;

import com.example.ferreteria.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	
	public Empleado findById(Long idEmpleado);
	
	public Empleado save(Empleado empleado);
	
	public Empleado update(Empleado empleado, Long idEmpleado);
	
	public void delete(Long idEmpleado);
}
