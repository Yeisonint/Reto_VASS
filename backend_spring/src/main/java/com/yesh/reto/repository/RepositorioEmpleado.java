package com.yesh.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yesh.reto.model.Empleado;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long> {

}
