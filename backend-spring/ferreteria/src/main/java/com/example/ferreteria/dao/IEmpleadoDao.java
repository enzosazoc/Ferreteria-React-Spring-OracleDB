package com.example.ferreteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.Empleado;

@Repository
public interface IEmpleadoDao extends JpaRepository<Empleado, Long>{

}
