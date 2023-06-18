package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.SensorContenedor;

@Repository("sensorContenedorRepository")
public interface ISensorContenedorRepository extends JpaRepository<SensorContenedor, Serializable> {

	public abstract SensorContenedor findByIdSensor(int idSensor);

}
