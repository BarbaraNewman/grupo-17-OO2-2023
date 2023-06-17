package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Ubicacion;

@Repository("ubicacionRepository")
public interface IUbicacionRepository extends JpaRepository<Ubicacion, Serializable> {

	public abstract Ubicacion findByIdUbicacion(int idUbicacion);

	public abstract Ubicacion findByNombre(String nombre);

}
