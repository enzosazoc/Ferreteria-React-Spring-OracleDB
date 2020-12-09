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

import com.example.ferreteria.entity.Proveedor;
import com.example.ferreteria.service.ProveedorServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	private ProveedorServiceImpl proveedorService;
	
	@GetMapping("/proveedores")
	public List<Proveedor> obtenerProveedores(){
		
		return proveedorService.findAll();
	}
	
	@PostMapping("/proveedores")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
		
		return proveedorService.save(proveedor);
	}
	
	@PutMapping("/proveedores/{idProveedor}")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor actualizarProveedor(@RequestBody Proveedor proveedor, @PathVariable Long idProveedor) {
		
		return proveedorService.update(proveedor, idProveedor);
	}
	
	@DeleteMapping("/proveedores/{idProveedor}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProveedor(@PathVariable Long idProveedor) {
		
		proveedorService.delete(idProveedor);
	}
}
