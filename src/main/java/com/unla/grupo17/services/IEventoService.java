package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Dispositivo;
import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.Ubicacion;

public interface IEventoService {

	public abstract List<Evento> getAll();

	public abstract List<Evento> getAllByOrderByFechaHoraRegistroDesc();

	public abstract Evento findByIdEvento(int idEvento);

	public abstract Evento insertOrUpdate(Evento evento);

	public abstract List<Evento> findByUltimoIdDispositivoEvento(int idDispositivo);

	public abstract List<Evento> getEventosByUbicacion(Ubicacion ubicacion);

	public abstract List<Evento> getEventosByUbicacion(int idUbicacion);

	public abstract List<Evento> getEventosByDispositivo(Dispositivo dispositivo);

	public abstract List<Evento> getEventosByDispositivo(int idDispositivo);

	public abstract List<Evento> getEventosByDispositivoActivo(boolean activo);

}
