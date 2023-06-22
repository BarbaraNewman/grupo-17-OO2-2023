package com.unla.grupo17.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo17.entities.Parking;
import com.unla.grupo17.entities.Ubicacion;
import com.unla.grupo17.repositories.IParkingRepository;
import com.unla.grupo17.services.IParkingService;

@Service("parkingService")
public class ParkingService implements IParkingService {

	@Autowired
	@Qualifier("parkingRepository")
	private IParkingRepository parkingRepository;

	@Override
	public List<Parking> getAll() {
		return parkingRepository.findAll();
	}

	@Override
	public Parking findByIdDispositivo(int idDispositivo) {
		return parkingRepository.findByIdDispositivo(idDispositivo);
	}
	
	@Override
	public Parking insertOrUpdate(Parking parking) {
		return parkingRepository.save(parking);
	}

}
