package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.Ubicacion;
import com.unla.grupo17.repositories.IEventoRepository;
import com.unla.grupo17.services.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService {

	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Override
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}

	@Override
	public Evento findByIdEvento(int idEvento) {
		return eventoRepository.findByIdEvento(idEvento);
	}

	@Override
	public List<Evento> findByUltimoIdDispositivoEvento(int idDispositivo) {
		return eventoRepository.findByUltimoIdDispositivoEvento(idDispositivo);
	}

	@Override
	public Evento insertOrUpdate(Evento evento) {
		return eventoRepository.save(evento);
	}

	public List<Evento> getEventosByUbicacion(Ubicacion ubicacion) {
		return eventoRepository.findByUbicacion(ubicacion);
	}

}
