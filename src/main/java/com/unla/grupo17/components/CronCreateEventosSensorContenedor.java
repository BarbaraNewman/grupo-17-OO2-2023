package com.unla.grupo17.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.entities.SensorContenedor;
import com.unla.grupo17.services.IEventoService;
import com.unla.grupo17.services.ISensorContenedorService;

@Component
public class CronCreateEventosSensorContenedor {

	@Autowired
	private ISensorContenedorService sensorContenedorService;

	@Autowired
	private IEventoService eventoService;

	// Tarea programada
	@Scheduled(fixedDelay = (60 * 60 * 1000)) // 1hr = (60min * 60seg * 1000ms)
	public void cronoLeerMetricasCrearEventos() {
		leerMetricasCrearEventos();
	}

	public void leerMetricasCrearEventos() {
		// Se leen las metricas
		List<SensorContenedor> metricasSensorContenedor = sensorContenedorService.getAll();
		// Por cada metrica, se crea un evento
		for (SensorContenedor sensorContenedor : metricasSensorContenedor) {
			Evento evento = new Evento();
			evento.setFechaHoraRegistro(LocalDateTime.now());
			evento.setDispositivo(sensorContenedor.getContenedor());
			evento.setDescripcion(sensorContenedor.toString());

			eventoService.insertOrUpdate(evento);
		}

	}
}
