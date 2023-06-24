package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.SensorAlumbrado;

public interface ISensorAlumbradoService {

	List<SensorAlumbrado> getAll();

	public abstract SensorAlumbrado findByIdSensor(int idSensor);

}
