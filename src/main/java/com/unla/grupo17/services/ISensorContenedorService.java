package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.SensorContenedor;

public interface ISensorContenedorService {

	List<SensorContenedor> getAll();

	public abstract SensorContenedor findByIdSensor(int idSensor);

}
