package com.unla.grupo17.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.unla.grupo17.entities.Alumbrado;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IAlumbradoService;
import com.unla.grupo17.services.IUbicacionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("dispositivo/alumbrado")
public class AlumbradoController {
	@Autowired
	@Qualifier("alumbradoService")
	private IAlumbradoService alumbradoService;

	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_ALUMBRADO_INDEX);

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
//		mAV.addObject("username", username);

		List<Alumbrado> alumbrados = alumbradoService.getall();

		mAV.addObject("alumbrados", alumbrados);
		mAV.addObject("alumbrado", new Alumbrado());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_ALUMBRADO_NEW);
		mAV.addObject("alumbrado", new Alumbrado());
		mAV.addObject("ubicaciones", ubicacionService.getAll());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("alumbrado") Alumbrado alumbrado, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_ALUMBRADO_NEW);
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		if (bindingResult.hasErrors()) {
			mAV.addObject("error", "Ha ocurrido un error en la validación");
		} else {
			alumbradoService.insertOrUpdate(alumbrado);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.DISPOSITIVO_ALUMBRADO_ROOT, true, false));
		}

		return mAV;
	}

	@GetMapping("/{idDispositivo}")
	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_ALUMBRADO_UPDATE);
		mAV.addObject("alumbrado", alumbradoService.findByIdDispositivo(idDispositivo));
		return mAV;
	}
}
