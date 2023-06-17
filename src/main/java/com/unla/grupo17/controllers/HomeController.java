package com.unla.grupo17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	// GET ejemplo SERVER/index
	// Si se agrega .html al final, funciona igual
	@GetMapping({ "/index", "/index.html" })
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX); // Vista
		return mAV;
	}

	// Redireccion al entrar a la direccion del server
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}

}
