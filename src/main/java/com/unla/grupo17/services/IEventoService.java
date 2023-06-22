package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Dispositivo;
import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.Ubicacion;

public interface IEventoService {

	List<Evento> getAll();

	List<Evento> getAllByOrderByFechaHoraRegistroDesc();

	public abstract Evento findByIdEvento(int idEvento);

	public Evento insertOrUpdate(Evento evento);

	public List<Evento> findByUltimoIdDispositivoEvento(int idDispositivo);

	public List<Evento> getEventosByUbicacion(Ubicacion ubicacion);

	public List<Evento> getEventosByDispositivo(Dispositivo dispositivo);

	public List<Evento> getEventosByDispositivo(int idDispositivo);

}
