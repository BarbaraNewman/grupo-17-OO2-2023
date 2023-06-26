package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Contenedor;
import com.unla.grupo17.entities.SensorContenedor;

@Repository("sensorContenedorRepository")
public interface ISensorContenedorRepository extends JpaRepository<SensorContenedor, Serializable> {

	public abstract SensorContenedor findByIdSensor(int idSensor);

	@Query("SELECT sc FROM SensorContenedor sc JOIN sc.contenedor c WHERE c.activo = true")
	public abstract List<SensorContenedor> findContenedorByActive();

	@Query("SELECT sc FROM SensorContenedor sc WHERE sc.contenedor IS NULL")
	public abstract List<SensorContenedor> findSensorContenedorByContenedorNulo();

	@Query("SELECT c FROM Contenedor c LEFT JOIN SensorContenedor sc ON c.idDispositivo = sc.contenedor.idDispositivo WHERE sc.idSensor IS NULL")
	public abstract List<Contenedor> findContenedoresNuloBySensorContenedor();

}
