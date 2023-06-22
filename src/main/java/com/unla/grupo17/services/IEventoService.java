package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Evento;

public interface IEventoService {

	List<Evento> getAll();

	public abstract Evento findByIdEvento(int idEvento);

	public Evento insertOrUpdate(Evento evento);		
	
	public List<Evento> findByUltimoIdDispositivoEvento(int idDispositivo);

}