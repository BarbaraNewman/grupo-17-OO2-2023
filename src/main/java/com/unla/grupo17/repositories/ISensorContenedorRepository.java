package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.SensorContenedor;

@Repository("sensorContenedorRepository")
public interface ISensorContenedorRepository extends JpaRepository<SensorContenedor, Serializable> {

	public abstract SensorContenedor findByIdSensor(int idSensor);

	@Query("SELECT sc FROM SensorContenedor sc JOIN sc.contenedor c WHERE c.activo = true")
	public abstract List<SensorContenedor> findContenedorByActive();

}
