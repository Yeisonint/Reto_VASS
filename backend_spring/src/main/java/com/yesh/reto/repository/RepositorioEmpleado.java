package com.yesh.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yesh.reto.model.Empleado;

@Repository
@Transactional
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long> {

}
