package com.unla.grupo17.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContenedorModel extends DispositivoModel {
	private int idDispositivo;
	private boolean reciclable;
	private int capacidad;
	private boolean lleno;

	public ContenedorModel(int idDispositivo, boolean reciclable, int capacidad, boolean lleno) {
		this.setIdDispositivo(idDispositivo);
		this.reciclable = reciclable;
		this.capacidad = capacidad;
		this.lleno = lleno;
	}

}
