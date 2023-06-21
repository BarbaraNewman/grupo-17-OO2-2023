package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.SensorAlumbrado;
import com.unla.grupo17.repositories.ISensorAlumbradoRepository;
import com.unla.grupo17.services.ISensorAlumbradoService;

@Service("sensorAlumbradoService")
public class SensorAlumbradoService implements ISensorAlumbradoService {

	@Autowired
	@Qualifier("sensorAlumbradoRepository")
	private ISensorAlumbradoRepository sensorAlumbradoRepository;

	@Override
	public List<SensorAlumbrado> getAll() {
		return sensorAlumbradoRepository.findAll();
	}

	@Override
	public SensorAlumbrado findByIdSensor(int idSensor) {
		return sensorAlumbradoRepository.findByIdSensor(idSensor);
	}

}
