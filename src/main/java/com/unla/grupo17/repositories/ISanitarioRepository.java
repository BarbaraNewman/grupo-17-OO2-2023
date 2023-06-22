package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Sanitario;

@Repository("sanitarioRepository")

public interface ISanitarioRepository extends JpaRepository<Sanitario, Serializable> {
	public abstract Sanitario findByIdDispositivo(int idDispositivo);
}
