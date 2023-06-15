package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Ubicacion;

public interface IUbicacionService {

	List<Ubicacion> getAll();

	public Ubicacion findByIdUbicacion(int idUbicacion);

	public Ubicacion findByNombre(String nombre);

	public Ubicacion insertOrUpdate(Ubicacion ubicacion);

	public boolean remove(int idUbicacion);

}
