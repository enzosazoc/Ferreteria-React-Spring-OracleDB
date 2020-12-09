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

import com.example.ferreteria.entity.Categoria;
import com.example.ferreteria.service.CategoriaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoriaController {

	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	@GetMapping("/categorias")
	public List<Categoria> obtenerCategorias(){
		
		return categoriaService.findAll();
	}
	
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria crearCategoria(@RequestBody Categoria categoria) {
		
		return categoriaService.save(categoria);
	}
	
	@PutMapping("/categorias/{idCategoria}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria actualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long idCategoria) {
		
		return categoriaService.update(categoria, idCategoria);
	}
	
	@DeleteMapping("/categorias/{idCategoria}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarCategoria(@PathVariable Long idCategoria) {
		
		categoriaService.delete(idCategoria);
	}
}
