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

import com.example.ferreteria.entity.DetalleOrden;
import com.example.ferreteria.service.DetalleOrdenServiceImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DetalleOrdenController {

	@Autowired
	private DetalleOrdenServiceImpl detalleOrdenService;
	
	@GetMapping("/detallesOrden")
	public List<DetalleOrden> obtenerDetallesOrden(){
		
		return detalleOrdenService.findAll();
	}
	
	@GetMapping("/detallesOrdenPorIdOrden/{idOrden}")
	public List<DetalleOrden> obtenerDetalleOrdenPorIdOrden(@PathVariable Long idOrden){
		
		return detalleOrdenService.findByIdOrden(idOrden);
	}
	
	@PostMapping("/detallesOrden")
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleOrden crearDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
		
		return detalleOrdenService.save(detalleOrden);
	}
	
	@PutMapping("/detallesOrden/{idDetalleOrden}")
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleOrden actualizarDetalleOrden(@RequestBody DetalleOrden detalleOrden, @PathVariable Long idDetalleOrden) {
		
		return detalleOrdenService.update(detalleOrden, idDetalleOrden);
	}
	
	@DeleteMapping("/detallesOrden/{idDetalleOrden}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarDetalleOrden(@PathVariable Long idDetalleOrden) {
		
		detalleOrdenService.delete(idDetalleOrden);
	}
}
