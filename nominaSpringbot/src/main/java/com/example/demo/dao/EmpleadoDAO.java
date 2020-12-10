package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Empleado;

public interface EmpleadoDAO extends JpaRepository<Empleado, String> {

}
