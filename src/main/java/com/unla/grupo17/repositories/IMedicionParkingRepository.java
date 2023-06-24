package com.unla.grupo17.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.MedicionParking;

@Repository("medicionParkingRepository")
public interface IMedicionParkingRepository extends JpaRepository<MedicionParking, Serializable> {

	public abstract MedicionParking findByIdMedicionParking(int idMedicionParking);
	
	@Query("SELECT m FROM MedicionParking m WHERE m.parking.idDispositivo = (:idDispositivo)")
	public abstract List<MedicionParking> findByDispositivo(int idDispositivo);


}
