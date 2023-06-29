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

import com.unla.grupo17.entities.Sanitario;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.ISanitarioService;
import com.unla.grupo17.services.IUbicacionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dispositivo/sanitario")
public class SanitarioController {

	@Autowired
	@Qualifier("sanitarioService")
	private ISanitarioService sanitarioService;

	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_SANITARIO_INDEX); // Vista
		// Obtencion del nombre de Usuario
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		mAV.addObject("username", username);

		List<Sanitario> sanitarios = sanitarioService.getAll();

		mAV.addObject("sanitarios", sanitarios);
		mAV.addObject("sanitario", new Sanitario());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_SANITARIO_NEW);
		mAV.addObject("sanitario", new Sanitario());
		mAV.addObject("ubicaciones", ubicacionService.getAll());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("sanitario") Sanitario sanitario, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_SANITARIO_NEW);
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		if (bindingResult.hasErrors()) {
			mAV.addObject("error", "Ha ocurrido un error en la validación");
		} else {
			sanitarioService.insertOrUpdate(sanitario);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.DISPOSITIVO_SANITARIO_ROOT, true, false));
		}

		return mAV;
	}

	@GetMapping("/{idDispositivo}")
	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_SANITARIO_UPDATE);
		mAV.addObject("sanitario", sanitarioService.findByIdDispositivo(idDispositivo));
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@Valid @ModelAttribute("sanitario") Sanitario sanitario) {
		if (sanitario.getIdDispositivo() > 0) {
			sanitario.setNombre(sanitario.getNombre());
			sanitario.setUbicacion(sanitario.getUbicacion());
			sanitario.setActivo(sanitario.isActivo());
		}
		sanitarioService.insertOrUpdate(sanitario);
		return new RedirectView(ViewRouteHelper.DISPOSITIVO_SANITARIO_ROOT);
	}

}
