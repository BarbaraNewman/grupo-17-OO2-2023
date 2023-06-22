package com.unla.grupo17.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContenedorModel extends DispositivoModel {
	private boolean reciclable;
	private int capacidad;
	private boolean lleno;

}
