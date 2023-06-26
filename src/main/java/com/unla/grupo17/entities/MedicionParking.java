package com.unla.grupo17.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medicionParking")
public class MedicionParking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idMedicionParking;

	@Column(name = "ocupado")
	protected boolean ocupado;

	@Column(name = "hora")
	protected LocalDateTime hora;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDispositivo", nullable = true)
	protected Parking parking;

	@Column(name = "createdAt")
	@CreationTimestamp
	protected LocalDateTime createdAt;

	public MedicionParking(int idMedicionParking, boolean ocupado, LocalDateTime hora) {
		this.ocupado = ocupado;
		this.hora = hora;
	}

	public MedicionParking(boolean ocupado, LocalDateTime hora) {
		this.ocupado = ocupado;
		this.hora = hora;
	}
}
