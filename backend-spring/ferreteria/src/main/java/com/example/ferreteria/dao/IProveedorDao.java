package com.example.ferreteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.Proveedor;

@Repository
public interface IProveedorDao extends JpaRepository<Proveedor, Long>{

}
