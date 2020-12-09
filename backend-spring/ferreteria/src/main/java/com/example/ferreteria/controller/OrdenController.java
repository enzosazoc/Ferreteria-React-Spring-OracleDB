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

import com.example.ferreteria.custom.OrdenDetalle;
import com.example.ferreteria.entity.Orden;
import com.example.ferreteria.service.OrdenServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrdenController {

	@Autowired
	private OrdenServiceImpl ordenService;
	
	@GetMapping("/ordenes")
	public List<Orden> obtenerOrdenes(){
		
		return ordenService.findAll();
	}
	
	@GetMapping("/ordenes/{idOrden}")
	public Orden obtenerOrden(@PathVariable Long idOrden){
		
		return ordenService.findById(idOrden);
	}
	
	@PostMapping("/ordenes")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden crearOrden(@RequestBody Orden orden) {
		
		return ordenService.save(orden);
	}
	
	@PostMapping("/ordenDetalle")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden crearOrdenDetalle(@RequestBody OrdenDetalle ordenDetalle) {
		
		return ordenService.saveOrdenDetalle(ordenDetalle);
	}
	
	@PutMapping("/ordenes/{idOrden}")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden actualizarOrden(@RequestBody Orden orden, @PathVariable Long idOrden) {
		
		return ordenService.update(orden, idOrden);
	}
	
	@DeleteMapping("/ordenes/{idOrden}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarOrden(@PathVariable Long idOrden) {
		
		ordenService.delete(idOrden);
	}
}
