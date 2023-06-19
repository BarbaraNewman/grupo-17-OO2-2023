package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Alumbrado;

public interface IAlumbradoService {

	List<Alumbrado> getall();

	public abstract Alumbrado findByIdDispositivo(int idDispositivo);

}
