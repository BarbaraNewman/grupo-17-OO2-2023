package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Contenedor;

public interface IContenedorService {

	public abstract List<Contenedor> getAll();

	public abstract List<Contenedor> getAllByActivo(Boolean active);

	public abstract Contenedor findByIdDispositivo(int idDispositivo);

	public abstract Contenedor insertOrUpdate(Contenedor contenedor);

}
