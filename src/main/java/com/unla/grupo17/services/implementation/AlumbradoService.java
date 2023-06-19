package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Alumbrado;
import com.unla.grupo17.repositories.IAlumbradoRepository;
import com.unla.grupo17.services.IAlumbradoService;

@Service("alumbradoService")
public class AlumbradoService implements IAlumbradoService {
	@Autowired
	@Qualifier("alumbradoRepository")
	private IAlumbradoRepository alumbradoRepository;

	@Override
	public List<Alumbrado> getall() {
		return alumbradoRepository.findAll();
	}

	@Override
	public Alumbrado findByIdDispositivo(int idDispositivo) {
		return alumbradoRepository.findByIdDispositivo(idDispositivo);
	}

}
