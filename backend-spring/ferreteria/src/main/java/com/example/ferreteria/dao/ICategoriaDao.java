package com.example.ferreteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.Categoria;

@Repository
public interface ICategoriaDao extends JpaRepository<Categoria, Long>{

}
