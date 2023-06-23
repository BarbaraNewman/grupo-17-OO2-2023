package com.unla.grupo17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.components.CronCreateEventosSensorContenedor;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IEventoService;
import com.unla.grupo17.services.IUbicacionService;

@Controller
@RequestMapping("evento")
public class EventoController {

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;

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
		mAV.addObject("eventos", eventoService.getAllByOrderByFechaHoraRegistroDesc());
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/obtenerMetricas")
	public RedirectView create() {
		// Solicita Metricas SensorContenedor
		cronCreateEventosSensorContenedor.leerMetricasCrearEventos();

		return new RedirectView(ViewRouteHelper.EVENTO_ROOT);
	}

	@GetMapping("/{idEvento}")
	public ModelAndView get(@PathVariable("idEvento") int idEvento) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_DETAILS);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("evento", eventoService.findByIdEvento(idEvento));
		return mAV;
	}

	@GetMapping("/dispositivos/{activo}")
	public ModelAndView getDispositivoActivo(@PathVariable("activo") boolean activo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_INDEX);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("eventos", eventoService.getEventosByDispositivoActivo(activo));
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		return mAV;
	}

	@GetMapping("/ubicacion/{idUbicacion}")
	public ModelAndView getUbicacion(@PathVariable("idUbicacion") int idUbicacion) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_INDEX);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("eventos", eventoService.getEventosByUbicacion(idUbicacion));
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		return mAV;
	}

}
