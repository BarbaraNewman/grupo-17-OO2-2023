package com.unla.grupo17.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.entities.Ubicacion;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IEventoService;
import com.unla.grupo17.services.IUbicacionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	// Obtencion del nombre de Usuario
	private String getLoggedUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_INDEX); // Vista

		mAV.addObject("username", getLoggedUsername());
		List<Ubicacion> ubicaciones = ubicacionService.getAll();
		mAV.addObject("ubicaciones", ubicaciones);
		mAV.addObject("ubicacion", new Ubicacion());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_NEW);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("ubicacion", new Ubicacion());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("ubicacion") Ubicacion ubicacion, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_NEW);

		mAV.addObject("username", getLoggedUsername());

		if (bindingResult.hasErrors()) {
			mAV.addObject("error", "Ha ocurrido un error en la validación");
		} else {
			ubicacionService.insertOrUpdate(ubicacion);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.UBICACION_ROOT));
		}

		return mAV;
	}

	@GetMapping("/{idUbicacion}")
	public ModelAndView get(@PathVariable("idUbicacion") int idUbicacion) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_UPDATE);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("ubicacion", ubicacionService.findByIdUbicacion(idUbicacion));
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@Valid @ModelAttribute("ubicacion") Ubicacion ubicacion) {
		if (ubicacion.getIdUbicacion() > 0) {
			ubicacion.setNombre(ubicacion.getNombre());
			ubicacion.setDescripcion(ubicacion.getDescripcion());
		}
		ubicacionService.insertOrUpdate(ubicacion);
		return new RedirectView(ViewRouteHelper.UBICACION_ROOT);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{idUbicacion}")
	public RedirectView delete(@PathVariable("idUbicacion") int idUbicacion) {
		ubicacionService.remove(idUbicacion);
		return new RedirectView(ViewRouteHelper.UBICACION_ROOT);
	}

	@GetMapping("/{idUbicacion}/eventos")
	public ModelAndView getEventos(@PathVariable("idUbicacion") int idUbicacion) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_EVENTO);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("eventos", eventoService.getEventosByUbicacion(idUbicacion));

		return mAV;
	}

}
