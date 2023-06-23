package com.unla.grupo17.components;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.grupo17.entities.SensorContenedor;
import com.unla.grupo17.services.ISensorContenedorService;

@Component
public class SimSensorContenedor {

	@Autowired
	private ISensorContenedorService sensorContenedorService;

	// Tarea programada
	@Scheduled(fixedDelay = (1 * 10 * 1000)) // 10seg = (1min * 10seg * 1000ms)
	public void cronoModificarMetricasSensor() {
		// Se llama al metodo de modificacion de metricas
		modificarMetricasSensor();
	}

	public void modificarMetricasSensor() {
		// Se modifican los valores del sensor de forma aleatoria

		List<SensorContenedor> metricasSensorContenedor = sensorContenedorService.getContenedorByActive();

		for (SensorContenedor sensorContenedor : metricasSensorContenedor) {
			sensorContenedor.setNivelLlenado(generarNumeroAleatorio(0, 100));
			sensorContenedor.setNivelBateria(generarNumeroAleatorio(0, sensorContenedor.getNivelBateria()));
			sensorContenedorService.insertOrUpdate(sensorContenedor);
		}

	}

	public int generarNumeroAleatorio(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
}
