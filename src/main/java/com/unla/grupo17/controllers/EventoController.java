package com.unla.grupo17.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.components.CronCreateEventosSensorContenedor;
import com.unla.grupo17.entities.Evento;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IEventoService;

@Controller
@RequestMapping("evento")
public class EventoController {

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@Autowired
	private CronCreateEventosSensorContenedor cronCreateEventosSensorContenedor;

	// Obtencion del nombre de Usuario
	private String getLoggedUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_INDEX); // Vista

		mAV.addObject("username", getLoggedUsername());
		List<Evento> eventos = eventoService.getAll();
		mAV.addObject("eventos", eventos);
		mAV.addObject("evento", new Evento());

		return mAV;
	}

	@GetMapping("/obtenerMetricas")
	public RedirectView create() {
		// Solicita Metricas SensorContenedor
		cronCreateEventosSensorContenedor.leerMetricasCrearEventos();

		return new RedirectView(ViewRouteHelper.EVENTO_ROOT);
	}

}
