package com.unla.grupo17.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alumbrado extends Dispositivo {
	
	@Column(columnDefinition = "boolean default false")
	private boolean estadoLuces;
	
	@NotBlank(message = "El control de alumbrado no puede estar en blanco")
    private String controlDeAlumbrado;

}
