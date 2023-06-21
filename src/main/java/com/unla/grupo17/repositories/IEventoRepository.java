package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unla.grupo17.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {

	public abstract Evento findByIdEvento(int idEvento);

	public abstract Evento findByDescripcion(String descripcion);
	
	@Query("SELECT e FROM Evento e WHERE e.dispositivo.idDispositivo = (:idDispositivo)")
	public abstract List<Evento> findByUltimoIdDispositivoEvento(int idDispositivo);
	

}
