package com.unla.grupo17.services;

import java.util.List;

import com.unla.grupo17.entities.MedicionParking;

public interface IMedicionParkingService {

	List<MedicionParking> getAll();

	public abstract MedicionParking findByIdMedicionParking(int idMedicionParking);
	

}
