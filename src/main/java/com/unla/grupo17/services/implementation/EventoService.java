package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Dispositivo;
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

	public void deleteAll() {
		eventoRepository.deleteAll();
	}

	@Override
	public List<Evento> getAllByOrderByFechaHoraRegistroDesc() {
		return eventoRepository.findAllByOrderByFechaHoraRegistroDesc();
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

	@Override
	public List<Evento> getEventosByUbicacion(int idUbicacion) {
		return eventoRepository.findByUbicacion(idUbicacion);
	}

	@Override
	public List<Evento> getEventosByDispositivo(Dispositivo dispositivo) {
		return eventoRepository.findByDispositivo(dispositivo);
	}

	@Override
	public List<Evento> getEventosByDispositivo(int idDispositivo) {
		return eventoRepository.findByDispositivo(idDispositivo);
	}

	public List<Evento> getEventosByDispositivoActivo(boolean activo) {
		return eventoRepository.findByDispositivoActivo(activo);
	}

}
