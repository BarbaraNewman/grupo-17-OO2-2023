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
public class SensorContenedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSensor;
	private String modelo;
	private String numeroSerie;

	@Min(value = 0, message = "El nivel de batería debe ser igual o mayor a 0.")
	@Max(value = 100, message = "El nivel de batería debe ser igual o menor a 100.")
	private int nivelBateria;

	@Min(value = 0, message = "El nivel de llenado debe ser igual o mayor a 0.")
	@Max(value = 100, message = "El nivel de llenado debe ser igual o menor a 100.")
	private int nivelLlenado;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idContenedor", nullable = true)
	private Contenedor contenedor;

	public String getMensajeEstado() {
		return "Nivel de llenado " + this.getNivelLlenado() + "% | Batería " + this.getNivelBateria() + "% ("
				+ this.getDiasBateriaRestante() + " días restantes)";
	}

	public int getDiasBateriaRestante() {
		int diasVidaUtil = (365); // Duracion de bateria al 100% = 1 Año
		float diasRestantes = (this.getNivelBateria() / 100.0f) * diasVidaUtil;
		return Math.round(diasRestantes);
	}

}
