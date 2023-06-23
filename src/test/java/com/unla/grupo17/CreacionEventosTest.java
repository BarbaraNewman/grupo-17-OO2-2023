package com.unla.grupo17;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.SensorAlumbrado;
import com.unla.grupo17.services.IEventoService;
import com.unla.grupo17.services.ISensorAlumbradoService;

@SpringBootTest
class CreacionEventosTest {

	@Autowired
	private ISensorAlumbradoService sensorAlumbradoService;

	@Autowired
	private IEventoService eventoService;

	@Test
	public void leerMetricas() {

		List<SensorAlumbrado> metricasSensorAlumbrado = sensorAlumbradoService.getAll();
		for (SensorAlumbrado sensorAlumbrado : metricasSensorAlumbrado) {

			Evento evento = new Evento();

			/*
			 * Encendido (true): Luminosidad de 20 indica la necesidad de encender las
			 * luces. Si la medición de luminosidad es menor o igual a ese valor, las luces
			 * se encenderán.
			 * 
			 * Apagado (false): Luminosidad de 80 indica suficiente iluminación natural. Si
			 * la medición de luminosidad es mayor o igual a ese valor, las luces se
			 * apagarán.
			 */
			if (sensorAlumbrado.getUmbralLuminosidad() <= 20) {
				sensorAlumbrado.getAlumbrado().setEstadoLuces(true);
			} else if (sensorAlumbrado.getUmbralLuminosidad() >= 80) {
				sensorAlumbrado.getAlumbrado().setEstadoLuces(false);
			}

			/*
			 * "Funcionando normalmente": Si las horas acumuladas están dentro de un rango
			 * aceptable, indica que las luces están funcionando correctamente y no se
			 * requieren acciones adicionales.
			 * 
			 * "Mantenimiento requerido": Si las horas acumuladas superan un límite
			 * establecido, indica que es necesario realizar un mantenimiento en las luces,
			 * como reemplazo de componentes o verificación de su estado general.
			 */
			if (sensorAlumbrado.getTiempoApagadoEncendido() == 11
					|| sensorAlumbrado.getTiempoApagadoEncendido() == 13) {
				sensorAlumbrado.getAlumbrado().setControlDeAlumbrado("Funcionando Correctamente");
			} else {
				sensorAlumbrado.getAlumbrado().setControlDeAlumbrado("Mantenimiento Requerido");
			}

			evento.setFechaHoraRegistro(LocalDateTime.now());
			evento.setDescripcion("Estado de las luces: " + sensorAlumbrado.getAlumbrado().isEstadoLuces()
					+ " Control de Alumbrado: " + sensorAlumbrado.getAlumbrado().getControlDeAlumbrado());
			evento.setDispositivo(sensorAlumbrado.getAlumbrado());
			eventoService.insertOrUpdate(evento);
		}
	}

}
