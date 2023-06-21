package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.Parking;

public interface IParkingService {

	List<Parking> getAll();
	
	public abstract Parking findByIdDispositivo(int idDispositivo);

	public Parking insertOrUpdate(Parking parking);
}
