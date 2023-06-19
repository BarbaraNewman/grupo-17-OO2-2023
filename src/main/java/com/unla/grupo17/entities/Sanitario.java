package com.unla.grupo17.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Sanitario extends Dispositivo{
private String nroDeLugar;
private int cantPersonas;
private int cantLabatorios;
private int nroPuertas;

}
