package com.unla.grupo17.services.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.SensorContenedor;
import com.unla.grupo17.repositories.ISensorContenedorRepository;
import com.unla.grupo17.services.ISensorContenedorService;

@Service("sensorContenedorService")
public class SensorContenedorService implements ISensorContenedorService {

	@Autowired
	@Qualifier("sensorContenedorRepository")
	private ISensorContenedorRepository sensorContenedorRepository;

	@Override
	public List<SensorContenedor> getAll() {
		return sensorContenedorRepository.findAll();
	}

	public List<SensorContenedor> getContenedorByActive() {
		return sensorContenedorRepository.findContenedorByActive();

	}

	@Override
	public SensorContenedor findByIdSensor(int idSensor) {
		return sensorContenedorRepository.findByIdSensor(idSensor);
	}

}
