package com.unla.grupo17.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SensorContenedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSensor;
	private String modelo;
	private String numeroSerie;
	private int nivelBateria;
	private int nivelLlenado;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idContenedor", nullable = true)
	private Contenedor contenedor;

}
