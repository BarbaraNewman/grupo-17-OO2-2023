package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.MedicionParking;

@Repository("medicionParkingRepository")
public interface IMedicionParkingRepository extends JpaRepository<MedicionParking, Serializable> {

	public abstract MedicionParking findByIdMedicionParking(int idMedicionParking);

}
