package com.example.ferreteria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.ferreteria.custom.VentaDetalle;
import com.example.ferreteria.entity.Venta;
import com.example.ferreteria.service.VentaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	private VentaServiceImpl ventaService;
	
	@GetMapping("/ventas")
	public List<Venta> obtenerVentas(){
		
		return ventaService.findAll();
	}
	
	@GetMapping("/ventas/{idVenta}")
	public Venta obtenerVenta(@PathVariable Long idVenta) {
		
		return ventaService.findById(idVenta);
	}
	
	@PostMapping("/ventas")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta crearVenta(@RequestBody Venta venta) {
		
		return ventaService.save(venta);
	}
	
	@PostMapping("/ventaDetalle")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta crearVentaDetalle(@RequestBody VentaDetalle ventaDetalle) {
		
		return ventaService.saveVentaDetalle(ventaDetalle);
	}
	
	@PutMapping("/ventas/{idVenta}")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta actualizarVenta(@RequestBody Venta venta, @PathVariable Long idVenta) {
		
		return ventaService.update(venta, idVenta);
	}
	
	@DeleteMapping("/ventas/{idVenta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarVenta(@PathVariable Long idVenta) {
		
		ventaService.delete(idVenta);
	}
}
