package com.example.ferreteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.Venta;

@Repository
public interface IVentaDao extends JpaRepository<Venta, Long>{

}
