package com.yesh.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yesh.reto.model.Jefe;

@Repository
public interface RepositorioJefe extends JpaRepository<Jefe, Long> {

}
