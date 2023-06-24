package com.unla.grupo17.entities;

import jakarta.persistence.Column;
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
public class Contenedor extends Dispositivo {
	@Column(columnDefinition = "boolean default false")
	private boolean reciclable;

	@NotNull(message = "La capacidad no puede ser nula")
	@Min(value = 1, message = "La capacidad debe ser mayor o igual a 1")
	private int capacidad;

	@Column(columnDefinition = "boolean default false")
	private boolean lleno;

}
