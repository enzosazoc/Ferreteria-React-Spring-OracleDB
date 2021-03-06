package com.example.ferreteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ferreteria.dao.IDetalleVentaDao;
import com.example.ferreteria.entity.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{

	@Autowired
	private IDetalleVentaDao detalleVentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleVenta> findAll() {
		
		return (List<DetalleVenta>)detalleVentaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleVenta findById(Long idDetalleVenta) {
		
		return detalleVentaDao.findById(idDetalleVenta).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleVenta> findByIdVenta(Long idVenta) {
		
		return detalleVentaDao.findByVenta_IdVenta(idVenta);
	}

	@Override
	@Transactional
	public DetalleVenta save(DetalleVenta detalleVenta) {
		
		return detalleVentaDao.save(detalleVenta);
	}

	@Override
	@Transactional
	public DetalleVenta update(DetalleVenta detalleVenta, Long idDetalleVenta) {
		
		DetalleVenta detalleVentaModificado = this.findById(idDetalleVenta);
		
		detalleVentaModificado.setPrecioUnitario(detalleVenta.getPrecioUnitario());
		detalleVentaModificado.setCantidad(detalleVenta.getCantidad());
		detalleVentaModificado.setTotal(detalleVenta.getTotal());
		detalleVentaModificado.setProducto(detalleVenta.getProducto());
		detalleVentaModificado.setVenta(detalleVenta.getVenta());
		
		return detalleVentaDao.save(detalleVentaModificado);
	}

	@Override
	@Transactional
	public void delete(Long idDetalleVenta) {
		
		detalleVentaDao.deleteById(idDetalleVenta);
	}

}
