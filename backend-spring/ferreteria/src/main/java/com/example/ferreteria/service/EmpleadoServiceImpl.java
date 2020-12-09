package com.example.ferreteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ferreteria.dao.IEmpleadoDao;
import com.example.ferreteria.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		
		return (List<Empleado>)empleadoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Empleado findById(Long idEmpleado) {
		
		return empleadoDao.findById(idEmpleado).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public Empleado update(Empleado empleado, Long idEmpleado) {
		
		Empleado empleadoModificado = this.findById(idEmpleado);
		
		empleadoModificado.setRun(empleado.getRun());
		empleadoModificado.setNombres(empleado.getNombres());
		empleadoModificado.setApellidoP(empleado.getApellidoP());
		empleadoModificado.setApellidoM(empleado.getApellidoM());
		
		return empleadoDao.save(empleadoModificado);
	}

	@Override
	@Transactional
	public void delete(Long idEmpleado) {
		
		empleadoDao.deleteById(idEmpleado);
	}
}
