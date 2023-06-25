package com.unla.grupo17.controllers;

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

import com.unla.grupo17.entities.SensorContenedor;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IContenedorService;
import com.unla.grupo17.services.ISensorContenedorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("sensor/contenedor")
public class SensorContenedorController {

	@Autowired
	@Qualifier("contenedorService")
	private IContenedorService contenedorService;

	@Autowired
	@Qualifier("sensorContenedorService")
	private ISensorContenedorService sensorContenedorService;

	// Obtencion del nombre de Usuario
	private String getLoggedUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_CONTENEDOR_INDEX); // Vista

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("sensores", sensorContenedorService.getAll());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_CONTENEDOR_NEW);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("sensorContenedor", new SensorContenedor());
		mAV.addObject("contenedores", sensorContenedorService.getContenedoresNuloBySensorContenedor());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("sensorContenedor") SensorContenedor sensorContenedor,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_CONTENEDOR_NEW);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("contenedores", sensorContenedorService.getContenedoresNuloBySensorContenedor());

		if (bindingResult.hasErrors()) {
			mAV.addObject("error", "Ha ocurrido un error en la validación");
		} else {
			sensorContenedorService.insertOrUpdate(sensorContenedor);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.SENSOR_CONTENEDOR_ROOT));
		}

		return mAV;
	}

	@GetMapping("/{idSensor}")
	public ModelAndView get(@PathVariable("idSensor") int idSensor) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_CONTENEDOR_UPDATE);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("contenedores", sensorContenedorService.getContenedoresNuloBySensorContenedor());
		mAV.addObject("sensorContenedor", sensorContenedorService.findByIdSensor(idSensor));

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("idSensor") SensorContenedor sensorContenedor,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_CONTENEDOR_UPDATE);

		mAV.addObject("username", getLoggedUsername());
		mAV.addObject("contenedores", sensorContenedorService.getContenedoresNuloBySensorContenedor());
		if (sensorContenedor.getIdSensor() > 0) {
			sensorContenedor.setModelo(sensorContenedor.getModelo());
			sensorContenedor.setNumeroSerie(sensorContenedor.getNumeroSerie());
			sensorContenedor.setNivelBateria(sensorContenedor.getNivelBateria());
			sensorContenedor.setNivelLlenado(sensorContenedor.getNivelLlenado());
			sensorContenedor.setContenedor(sensorContenedor.getContenedor());

		}

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error en la validación");
		} else {
			sensorContenedorService.insertOrUpdate(sensorContenedor);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.SENSOR_CONTENEDOR_ROOT));
		}
		return mAV;
	}

}
