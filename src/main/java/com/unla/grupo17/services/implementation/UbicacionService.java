package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Ubicacion;
import com.unla.grupo17.repositories.IUbicacionRepository;
import com.unla.grupo17.services.IUbicacionService;

@Service("ubicacionService")
public class UbicacionService implements IUbicacionService {

	@Autowired
	@Qualifier("ubicacionRepository")
	private IUbicacionRepository ubicacionRepository;

	@Override
	public List<Ubicacion> getAll() {
		return ubicacionRepository.findAll();
	}

	@Override
	public Ubicacion findByIdUbicacion(int idUbicacion) {
		return ubicacionRepository.findByIdUbicacion(idUbicacion);
	}

	@Override
	public Ubicacion findByNombre(String nombre) {
		return ubicacionRepository.findByNombre(nombre);
	}

	@Override
	public Ubicacion insertOrUpdate(Ubicacion ubicacion) {
		return ubicacionRepository.save(ubicacion);
	}

	@Override
	public boolean remove(int idUbicacion) {
		try {
			ubicacionRepository.deleteById(idUbicacion);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
