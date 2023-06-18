package com.unla.grupo17;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.SensorContenedor;
import com.unla.grupo17.services.implementation.DispositivoService;
import com.unla.grupo17.services.implementation.EventoService;
import com.unla.grupo17.services.implementation.SensorContenedorService;

@SpringBootTest
class CreacionEventosTest {

	@Autowired
	private DispositivoService dispositivoService;

	@Autowired
	private SensorContenedorService sensorContenedorService;

	@Autowired
	private EventoService eventoService;

	// @Test
	// void contextLoads() {}

	@Test
	public void leerMetricas() {
		List<SensorContenedor> metricasSensorContenedor = sensorContenedorService.getAll();

		for (SensorContenedor metricaSensor : metricasSensorContenedor) {
			// Realiza las operaciones deseadas con cada registro de métrica
			System.out.println(metricaSensor.toString());
			Evento evento = new Evento();
			evento.setDescripcion(metricaSensor.toString());
			///////////////////////////
			evento.setDispositivo(null);
			///////////////////////////
			evento.setFechaHoraRegistro(LocalDateTime.now());
			eventoService.insertOrUpdate(evento);

		}
	}

}
