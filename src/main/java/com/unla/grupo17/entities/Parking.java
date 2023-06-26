package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor
public class Parking extends Dispositivo {

	@NotNull(message = "El campo 'Numero de lugar' es requerido.")
	@Min(value = 1, message = "Numero de lugar debe ser mayor a 1.")
	private int nroLugar;
    
}
