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

import com.unla.grupo17.entities.Contenedor;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IContenedorService;

@Controller
@RequestMapping("dispositivo/contenedor")
public class ContenedorController {

	@Autowired
	@Qualifier("contenedorService")
	private IContenedorService contenedorService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_CONTENEDOR_INDEX); // Vista

		// Obtencion del nombre de Usuario
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		mAV.addObject("username", username);

		List<Contenedor> contenedores = contenedorService.getAll();

		mAV.addObject("contenedores", contenedores);
		mAV.addObject("contenedor", new Contenedor());

		return mAV;
	}

}
