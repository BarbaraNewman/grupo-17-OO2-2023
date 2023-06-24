package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Contenedor;

@Repository("contenedorRepository")
public interface IContenedorRepository extends JpaRepository<Contenedor, Serializable> {

	public abstract Contenedor findByIdDispositivo(int idDispositivo);

	public abstract List<Contenedor> findByActivo(boolean activo);

}
