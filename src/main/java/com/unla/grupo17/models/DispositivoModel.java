package com.unla.grupo17.models;

import com.unla.grupo17.entities.Ubicacion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class DispositivoModel {
	private int idDispositivo;
	private String nombre;

	private Ubicacion ubicacion;

}
