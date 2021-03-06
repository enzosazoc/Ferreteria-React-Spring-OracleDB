package com.example.ferreteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ferreteria.dao.IProductoDao;
import com.example.ferreteria.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long idProducto) {
		
		return productoDao.findById(idProducto).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public Producto update(Producto producto, Long idProducto) {
		
		Producto productoModificado = this.findById(idProducto);
		
		productoModificado.setMarca(producto.getMarca());
		productoModificado.setNombre(producto.getNombre());
		productoModificado.setDescripcion(producto.getDescripcion());
		productoModificado.setPrecio(producto.getPrecio());
		productoModificado.setStock(producto.getStock());
		productoModificado.setCategoria(producto.getCategoria());
		productoModificado.setProveedor(producto.getProveedor());
		
		return productoDao.save(productoModificado);
	}

	@Override
	@Transactional
	public void delete(Long idProducto) {
		
		productoDao.deleteById(idProducto);
	}

}
