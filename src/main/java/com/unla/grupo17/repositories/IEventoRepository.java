package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Dispositivo;
import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.Ubicacion;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {

	public abstract List<Evento> findAllByOrderByFechaHoraRegistroDesc();

	public abstract Evento findByIdEvento(int idEvento);

	public abstract Evento findByDescripcion(String descripcion);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.idDispositivo = (:idDispositivo)")
	public abstract List<Evento> findByUltimoIdDispositivoEvento(int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.ubicacion = :ubicacion")
	public abstract List<Evento> findByUbicacion(@Param("ubicacion") Ubicacion ubicacion);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.ubicacion.idUbicacion = :idUbicacion")
	public abstract List<Evento> findByUbicacion(@Param("idUbicacion") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo = :dispositivo")
	public abstract List<Evento> findByDispositivo(@Param("dispositivo") Dispositivo dispositivo);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.idDispositivo = :idDispositivo")
	public abstract List<Evento> findByDispositivo(@Param("idDispositivo") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.activo = :activo")
	public abstract List<Evento> findByDispositivoActivo(@Param("activo") boolean activo);

}
