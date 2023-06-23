package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.SensorContenedor;

public interface ISensorContenedorService {

	public abstract List<SensorContenedor> getAll();

	public abstract List<SensorContenedor> getContenedorByActive();

	public abstract SensorContenedor findByIdSensor(int idSensor);

	public abstract SensorContenedor insertOrUpdate(SensorContenedor sensorContenedor);

}
