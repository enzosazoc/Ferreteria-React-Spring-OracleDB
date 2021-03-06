package com.example.ferreteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ferreteria.dao.IProveedorDao;
import com.example.ferreteria.entity.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorDao proveedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findAll() {
		
		return (List<Proveedor>)proveedorDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Proveedor findById(Long idProveedor) {
		
		return proveedorDao.findById(idProveedor).orElse(null);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		
		return proveedorDao.save(proveedor);
	}

	@Override
	@Transactional
	public Proveedor update(Proveedor proveedor, Long idProveedor) {
		
		Proveedor proveedorModificado = this.findById(idProveedor);
		
		proveedorModificado.setRut(proveedor.getRut());
		proveedorModificado.setNombre(proveedor.getNombre());
		proveedorModificado.setDireccion(proveedor.getDireccion());
		proveedorModificado.setRubro(proveedor.getRubro());
		proveedorModificado.setTelefono(proveedor.getTelefono());
		proveedorModificado.setMoneda(proveedor.getMoneda());
		
		return proveedorDao.save(proveedorModificado);
	}

	@Override
	@Transactional
	public void delete(Long idProveedor) {
		
		proveedorDao.deleteById(idProveedor);
	}
}
