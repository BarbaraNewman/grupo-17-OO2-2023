package com.unla.grupo17.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDispositivo;
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUbicacion", nullable = true)
	private Ubicacion ubicacion;

	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;
	private boolean activo;

}
