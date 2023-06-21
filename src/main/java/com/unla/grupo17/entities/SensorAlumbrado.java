package com.unla.grupo17.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SensorAlumbrado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSensor;
	
	@Min(value = 0, message = "El nivel de luminosidad debe ser igual o mayor a 0.")
	@Max(value = 100, message = "El nivel de luminosidad debe ser igual o menor a 100.")
	private int umbralLuminosidad;
	
	private long tiempoApagadoEncendido;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAlumbrado", nullable = true)
	private Alumbrado alumbrado;

}
