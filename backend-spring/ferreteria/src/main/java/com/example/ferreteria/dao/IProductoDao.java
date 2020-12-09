package com.example.ferreteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.Producto;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Long>{

}
