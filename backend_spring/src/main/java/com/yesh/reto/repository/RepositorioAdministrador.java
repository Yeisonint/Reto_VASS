package com.yesh.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yesh.reto.model.Administrador;

@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador, Long> {

}
