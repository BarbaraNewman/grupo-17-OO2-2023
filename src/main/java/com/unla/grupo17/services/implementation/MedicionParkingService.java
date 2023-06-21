package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.MedicionParking;
import com.unla.grupo17.repositories.IMedicionParkingRepository;
import com.unla.grupo17.services.IMedicionParkingService;

@Service("medicionParkingService")
public class MedicionParkingService implements IMedicionParkingService {

	@Autowired
	@Qualifier("medicionParkingRepository")
	private IMedicionParkingRepository medicionParkingRepository;

	@Override
	public List<MedicionParking> getAll() {
		return medicionParkingRepository.findAll();
	}

	@Override
	public MedicionParking findByIdMedicionParking(int idMedicionParking) {
		return medicionParkingRepository.findByIdMedicionParking(idMedicionParking);
	}

}
