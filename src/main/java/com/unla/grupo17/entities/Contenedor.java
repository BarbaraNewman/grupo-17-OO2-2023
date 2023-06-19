package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contenedor extends Dispositivo {
	private boolean reciclable;
	private int capacidad;
	private boolean lleno;

}
