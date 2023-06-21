package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Parking;

@Repository("parkingRepository")
public interface IParkingRepository extends JpaRepository<Parking, Serializable> {

	public abstract Parking findByIdDispositivo(int idDispositivo);

}
