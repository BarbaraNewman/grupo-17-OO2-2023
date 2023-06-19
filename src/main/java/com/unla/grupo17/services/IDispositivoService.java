package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Dispositivo;

public interface IDispositivoService {

	List<Dispositivo> getAll();

	public abstract Dispositivo findByIdDispositivo(int idDispositivo);

}
