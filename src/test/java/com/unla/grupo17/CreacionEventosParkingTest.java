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

	// @Test
	// void contextLoads() {}
//
//	@Test
//	public void leerMetricas() {
//		// Lectura y creacion de Eventos para el parking
//		List<MedicionParking> medicionesParking = medicionParkingService.getAll();
//		for (MedicionParking medicionParking : medicionesParking) {
//			Evento evento = new Evento();
//			evento.setFechaHoraRegistro(LocalDateTime.now());
//			evento.setDescripcion(medicionParking.toString());
//			evento.setDispositivo(medicionParking.getParking());
//			eventoService.insertOrUpdate(evento);
//
//		}
//	}

	@Test
	public void leerMetricas() {
		// Lectura y creacion de Eventos para el parking
		List<MedicionParking> medicionesParking = medicionParkingService.getAll();

		for (MedicionParking medicionParking : medicionesParking) {
			if (this.existeEventoXMetrica(medicionParking) == false) {
				Evento evento = new Evento();
				evento.setFechaHoraRegistro(LocalDateTime.now());
				if (medicionParking.isOcupado() == true) {
					evento.setDescripcion("Se ocupo el lugar nro: " + medicionParking.getParking().getNroLugar());
				} else {
					evento.setDescripcion("Se libero el lugar nro: " + medicionParking.getParking().getNroLugar());
				}
//				if (medicionParking.isOcupado() == true) {
//					evento.setDescripcion("Se ocupo el lugar");
//				} else {
//					evento.setDescripcion("Se libero el lugar");
//				}
				evento.setDispositivo(medicionParking.getParking());
				eventoService.insertOrUpdate(evento);
			}
		}

	}

	public boolean existeEventoXMetrica(MedicionParking medicionParking) {

		List<Evento> eventos = eventoService.getAll();

		boolean existeEvento = false;
		
		List<Evento> eventosAux = eventoService.findByUltimoIdDispositivoEvento(medicionParking.getParking().getIdDispositivo());
		
		Evento eventoAux = eventosAux.get(eventosAux.size() - 1);
		
		if ((eventoAux.getDescripcion().equals("Se ocupo el lugar") && medicionParking.isOcupado() == true)
				|| (eventoAux.getDescripcion().equals("Se libero el lugar") && medicionParking.isOcupado() == false)) {
			existeEvento = true;
		}

		return existeEvento;

	}
}