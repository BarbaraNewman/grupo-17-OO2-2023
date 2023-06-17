package com.unla.grupo17.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Contenedor extends Dispositivo {
	private boolean reciclable;
	private int capacidad;
	private boolean lleno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSensor", nullable=true)
	private SensorContenedor sensor;

}
