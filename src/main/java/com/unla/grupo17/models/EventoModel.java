package com.unla.grupo17.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.unla.grupo17.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventoModel {

	private int idEvento;

	private Dispositivo dispositivo;
	private String descripcion;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime fechaHoraRegistro;

	public EventoModel(int idEvento, Dispositivo dispositivo, String descripcion, LocalDateTime fechaHoraRegistro) {
		this.idEvento = idEvento;
		this.dispositivo = dispositivo;
		this.descripcion = descripcion;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
}
