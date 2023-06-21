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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo17.entities.Contenedor;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IContenedorService;
import com.unla.grupo17.services.IUbicacionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("dispositivo/contenedor")
public class ContenedorController {

	@Autowired
	@Qualifier("contenedorService")
	private IContenedorService contenedorService;

	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;

	// Obtencion del nombre de Usuario
	private String getLoggedUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_CONTENEDOR_INDEX); // Vista

		mAV.addObject("username", getLoggedUsername());
		List<Contenedor> contenedores = contenedorService.getAll();
		mAV.addObject("contenedores", contenedores);
		mAV.addObject("contenedor", new Contenedor());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_CONTENEDOR_NEW);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("contenedor", new Contenedor());
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("contenedor") Contenedor contenedor, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_CONTENEDOR_NEW);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		if (bindingResult.hasErrors()) {
			mAV.addObject("error", "Ha ocurrido un error en la validación");
		} else {
			contenedorService.insertOrUpdate(contenedor);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.DISPOSITIVO_CONTENEDOR_ROOT, true, false));
		}

		return mAV;
	}

}
