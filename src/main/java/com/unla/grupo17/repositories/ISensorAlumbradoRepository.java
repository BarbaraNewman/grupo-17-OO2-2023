package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.SensorAlumbrado;


@Repository("sensorAlumbradoRepository")
public interface ISensorAlumbradoRepository extends JpaRepository<SensorAlumbrado, Serializable> {

	public abstract SensorAlumbrado findByIdSensor(int idSensor);
	
	@Query("SELECT s FROM SensorAlumbrado s JOIN s.alumbrado a WHERE a.estadoLuces = true")
	public abstract List<SensorAlumbrado> findAlumbradoByEstadoLuces();
	
	@Query("SELECT s FROM SensorAlumbrado s JOIN s.alumbrado a WHERE a.controlDeAlumbrado = (:controlDeAlumbrado)")
	public abstract List<SensorAlumbrado> findByControlDeAlumbrado(String controlDeAlumbrado);
	
	
	
	
	
}
