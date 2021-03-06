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

import com.example.ferreteria.entity.DetalleVenta;
import com.example.ferreteria.service.DetalleVentaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DetalleVentaController {

	@Autowired
	private DetalleVentaServiceImpl detalleVentaService;
	
	@GetMapping("detallesVenta")
	public List<DetalleVenta> obtenerDetallesVenta(){
		
		return detalleVentaService.findAll();
	}
	
	@GetMapping("detallesVentaPorIdVenta/{idVenta}")
	public List<DetalleVenta> obtenerDetalleVentaPorIdVenta(@PathVariable Long idVenta){
		
		return detalleVentaService.findByIdVenta(idVenta);
	}
	
	@PostMapping("/detallesVenta")
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleVenta crearDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
		
		return detalleVentaService.save(detalleVenta);
	}
	
	@PutMapping("/detallesVenta/{idDetalleVenta}")
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleVenta actualizarDetalleVenta(@RequestBody DetalleVenta detalleVenta, @PathVariable Long idDetalleVenta) {
		
		return detalleVentaService.update(detalleVenta, idDetalleVenta);
	}
	
	@DeleteMapping("/detallesVenta/{idDetalleVenta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarDetalleVenta(@PathVariable Long idDetalleVenta) {
		
		detalleVentaService.delete(idDetalleVenta);
	}
}
