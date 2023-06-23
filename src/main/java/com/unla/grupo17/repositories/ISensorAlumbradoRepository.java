package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.SensorAlumbrado;


@Repository("sensorAlumbradoRepository")
public interface ISensorAlumbradoRepository extends JpaRepository<SensorAlumbrado, Serializable> {

	public abstract SensorAlumbrado findByIdSensor(int idSensor);
	
}
