package com.unla.grupo17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo17.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.UBICACION_INDEX); // Vista
		return modelAndView;
	}

}
