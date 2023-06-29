package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Sanitario;

public interface ISanitarioService {

	List<Sanitario> getAll();

	public abstract Sanitario findByIdDispositivo(int idDispositivo);

	public Sanitario insertOrUpdate(Sanitario sanitario);
}
