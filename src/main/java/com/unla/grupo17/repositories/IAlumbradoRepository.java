package com.unla.grupo17.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo17.entities.Alumbrado;

@Repository("alumbradoRepository")
public interface IAlumbradoRepository extends JpaRepository<Alumbrado, Serializable> {

	public abstract Alumbrado findByIdDispositivo(int idDispositivo);

}