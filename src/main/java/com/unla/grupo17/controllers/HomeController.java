package com.unla.grupo17.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {

	// Obtencion del nombre de Usuario
	private String getLoggedUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	// GET ejemplo SERVER/index
	// Si se agrega .html al final, funciona igual
	@GetMapping({ "/index", "/index.html" })
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX); // Vista

		mAV.addObject("username", getLoggedUsername());

		return mAV;
	}

	@GetMapping("")
	public RedirectView toIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}

}
