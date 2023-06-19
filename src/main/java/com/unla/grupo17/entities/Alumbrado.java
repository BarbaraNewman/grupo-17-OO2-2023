package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alumbrado extends Dispositivo {
	private boolean estadoLuces;
	private long tiempoEncendido;
	private long tiempoApagado;
	private boolean umbralLuminosidad;

}
