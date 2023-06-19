package com.unla.grupo17.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	private LocalDateTime fechaHora;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAlumbrado", nullable = true)
	private Alumbrado alumbrado;

}
