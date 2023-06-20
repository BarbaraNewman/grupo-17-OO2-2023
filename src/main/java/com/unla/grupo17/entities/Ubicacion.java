package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ubicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUbicacion;

	@NotBlank(message = "Nombre es un campo obligatorio")
	private String nombre;
	private String descripcion;
}
