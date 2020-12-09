package com.example.ferreteria.service;

import java.util.List;

import com.example.ferreteria.entity.Categoria;

public interface ICategoriaService {

	public List<Categoria> findAll();
	
	public Categoria findById(Long idCategoria);
	
	public Categoria save(Categoria categoria);
	
	public Categoria update(Categoria categoria, Long idCategoria);
	
	public void delete(Long idCategoria);
}
