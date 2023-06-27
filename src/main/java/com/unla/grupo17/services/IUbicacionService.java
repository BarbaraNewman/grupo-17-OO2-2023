package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Ubicacion;

public interface IUbicacionService {

	public abstract List<Ubicacion> getAll();

	public abstract Ubicacion findByIdUbicacion(int idUbicacion);

	public abstract Ubicacion findByNombre(String nombre);

	public abstract Ubicacion insertOrUpdate(Ubicacion ubicacion);

	public boolean remove(int idUbicacion);

}
