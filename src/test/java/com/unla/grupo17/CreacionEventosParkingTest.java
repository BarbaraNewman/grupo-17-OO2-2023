package com.unla.grupo17;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import org.aspectj.weaver.MissingResolvedTypeWithKnownSignature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.MedicionParking;
import com.unla.grupo17.services.IEventoService;
import com.unla.grupo17.services.IMedicionParkingService;

@SpringBootTest
class CreacionEventosParkingTest {

	@Autowired
	private IMedicionParkingService medicionParkingService;

	@Autowired
	private IEventoService eventoService;

	@Test
	public void leerMetricas() {
		// Lectura y creacion de Eventos para el parking
		List<MedicionParking> medicionesParking = medicionParkingService.getAll();

		for (MedicionParking medicionParking : medicionesParking) {
			if (this.existeEventoXMetrica(medicionParking) == false) {
				Evento evento = new Evento();
				if (medicionParking.isOcupado() == true) {
					evento.setDescripcion("Se ocupo el lugar");
				} else {
					evento.setDescripcion("Se libero el lugar");
				}
				evento.setDispositivo(medicionParking.getParking());
				eventoService.insertOrUpdate(evento);
			}
		}

	}

	public boolean existeEventoXMetrica(MedicionParking medicionParking) {

		List<Evento> eventosParking = eventoService.getEventosByDispositivo(medicionParking.getParking());
		List<MedicionParking> medicionesParkingAux = medicionParkingService
				.findByDispositivo(medicionParking.getParking().getIdDispositivo());
		boolean existeEvento = false;

		if (eventosParking.size() == medicionesParkingAux.size()) {
			existeEvento = true;
		}

		return existeEvento;

	}
}