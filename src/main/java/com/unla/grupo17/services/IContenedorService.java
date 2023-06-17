package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Contenedor;

public interface IContenedorService {

	List<Contenedor> getAll();

	public abstract Contenedor findByIdDispositivo(int idDispositivo);

}
