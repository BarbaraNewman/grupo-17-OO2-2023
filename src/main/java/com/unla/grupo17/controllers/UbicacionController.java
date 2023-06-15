package com.unla.grupo17.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.entities.Ubicacion;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IUbicacionService;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_INDEX); // Vista

		List<Ubicacion> ubicaciones = ubicacionService.getAll();

		mAV.addObject("ubicaciones", ubicaciones);
		mAV.addObject("ubicacion", new Ubicacion());

		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_NEW);
		mAV.addObject("ubicacion", new Ubicacion());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("ubicacion") Ubicacion ubicacion) {
		ubicacionService.insertOrUpdate(ubicacion);
		return new RedirectView(ViewRouteHelper.UBICACION_ROOT);
	}

	@GetMapping("/{idUbicacion}")
	public ModelAndView get(@PathVariable("idUbicacion") int idUbicacion) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UBICACION_UPDATE);
		mAV.addObject("ubicacion", ubicacionService.findByIdUbicacion(idUbicacion));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("ubicacion") Ubicacion ubicacion) {
		if (ubicacion.getIdUbicacion() > 0) {
			ubicacion.setNombre(ubicacion.getNombre());
			ubicacion.setDescripcion(ubicacion.getDescripcion());
		}
		ubicacionService.insertOrUpdate(ubicacion);
		return new RedirectView(ViewRouteHelper.UBICACION_ROOT);
	}

	@PostMapping("/delete/{idUbicacion}")
	public RedirectView delete(@PathVariable("idUbicacion") int idUbicacion) {
		ubicacionService.remove(idUbicacion);
		return new RedirectView(ViewRouteHelper.UBICACION_ROOT);
	}

}