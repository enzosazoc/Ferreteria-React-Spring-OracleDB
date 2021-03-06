package com.example.ferreteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ferreteria.entity.Producto;
import com.example.ferreteria.service.ProductoServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private ProductoServiceImpl productoService;
	
	@GetMapping("/productos")
	public List<Producto> obtenerProductos(){
		
		return productoService.findAll();
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crearProducto(@RequestBody Producto producto) {
		
		return productoService.save(producto);
	}
	
	@PutMapping("/productos/{idProducto}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto actualizarProducto(@RequestBody Producto producto, @PathVariable Long idProducto) {
		
		return productoService.update(producto, idProducto);
	}
	
	@DeleteMapping("/productos/{idProducto}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable Long idProducto) {
		
		productoService.delete(idProducto);
	}
}
