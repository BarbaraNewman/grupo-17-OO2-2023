package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sanitario extends Dispositivo {
	@NotNull(message = "este campo es requerido.")
	private String nroDeLugar;
	@NotNull(message = "Este campo es requerido.")
private int cantPersonas;
	@Min(value = 0, message = "Numero de labatorios debe ser mayor a 0.")

	private int cantLabatorios;
	@Min(value = 0, message = "Numero de puertas debe ser mayor a 0.")

	private int nroPuertas;

}
