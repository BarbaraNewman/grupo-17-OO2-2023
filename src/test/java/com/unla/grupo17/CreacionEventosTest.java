package com.unla.grupo17;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.SensorAlumbrado;
import com.unla.grupo17.entities.SensorContenedor;
import com.unla.grupo17.services.IEventoService;
import com.unla.grupo17.services.ISensorAlumbradoService;
import com.unla.grupo17.services.ISensorContenedorService;

@SpringBootTest
class CreacionEventosTest {

	@Autowired
	private ISensorContenedorService sensorContenedorService;

	@Autowired
	private ISensorAlumbradoService sensorAlumbradoService;

	@Autowired
	private IEventoService eventoService;

	// @Test
	// void contextLoads() {}

	@Test
	public void leerMetricas() {
		// Lectura y creacion de Eventos para los Contenedores
		List<SensorContenedor> metricasSensorContenedor = sensorContenedorService.getAll();
		for (SensorContenedor sensorContenedor : metricasSensorContenedor) {
			Evento evento = new Evento();
			evento.setFechaHoraRegistro(LocalDateTime.now());
			evento.setDescripcion(sensorContenedor.toString());
			evento.setDispositivo(sensorContenedor.getContenedor());
			eventoService.insertOrUpdate(evento);

			///////////////////////////////////

		}

		List<SensorAlumbrado> metricasSensorAlumbrado = sensorAlumbradoService.getAll();
		for (SensorAlumbrado sensorAlumbrado : metricasSensorAlumbrado) {
			Evento evento = new Evento();
			evento.setFechaHoraRegistro(LocalDateTime.now());
			evento.setDescripcion(sensorAlumbrado.toString());
			evento.setDispositivo(sensorAlumbrado.getAlumbrado());
			eventoService.insertOrUpdate(evento);
		}
	}

}
