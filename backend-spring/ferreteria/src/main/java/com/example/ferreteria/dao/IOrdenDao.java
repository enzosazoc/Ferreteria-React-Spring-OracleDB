package com.example.ferreteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferreteria.entity.Orden;

@Repository
public interface IOrdenDao extends JpaRepository<Orden, Long>{

}
