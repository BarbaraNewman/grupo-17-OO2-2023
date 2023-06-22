package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Sanitario;
import com.unla.grupo17.repositories.ISanitarioRepository;
import com.unla.grupo17.services.ISanitarioService;

@Service("sanitarioService")

public class SanitarioService implements ISanitarioService {
	@Autowired
	@Qualifier("sanitarioRepository")
	private ISanitarioRepository sanitarioRepository;

	@Override
	public List<Sanitario> getAll() {
		return sanitarioRepository.findAll();
	}

	@Override
	public Sanitario findByIdDispositivo(int idDispositivo) {
		return sanitarioRepository.findByIdDispositivo(idDispositivo);
	}

}
