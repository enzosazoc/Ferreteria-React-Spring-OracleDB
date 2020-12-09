package com.example.ferreteria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.DetalleOrden;


@Repository
public interface IDetalleOrdenDao extends JpaRepository<DetalleOrden, Long>{

	List<DetalleOrden> findByOrden_IdOrden(Long idOrden);
}
