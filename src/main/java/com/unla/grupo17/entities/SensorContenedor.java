package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SensorContenedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSensor;
	private String modelo;
	private String numeroSerie;
	private int nivelBateria;
	private int nivelLlenado;

}
