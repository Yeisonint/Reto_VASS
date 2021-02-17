package com.yesh.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yesh.reto.model.Jefe;

@Repository
@Transactional
public interface RepositorioJefe extends JpaRepository<Jefe, Long> {

}
