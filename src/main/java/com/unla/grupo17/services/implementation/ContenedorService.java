package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Contenedor;
import com.unla.grupo17.repositories.IContenedorRepository;
import com.unla.grupo17.services.IContenedorService;

@Service("contenedorService")
public class ContenedorService implements IContenedorService {

	@Autowired
	@Qualifier("contenedorRepository")
	private IContenedorRepository contenedorRepository;

	@Override
	public List<Contenedor> getAll() {
		return contenedorRepository.findAll();
	}

	@Override
	public Contenedor findByIdDispositivo(int idDispositivo) {
		return contenedorRepository.findByIdDispositivo(idDispositivo);
	}

}
