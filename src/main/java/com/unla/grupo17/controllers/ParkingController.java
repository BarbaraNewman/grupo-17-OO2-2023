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

import com.unla.grupo17.entities.Parking;
import com.unla.grupo17.entities.Ubicacion;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IParkingService;
import com.unla.grupo17.services.IUbicacionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dispositivo/parking")
public class ParkingController {

	@Autowired
	@Qualifier("parkingService")
	private IParkingService parkingService;
	
	@Autowired
	@Qualifier("ubicacionService")
	private IUbicacionService ubicacionService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_PARKING_INDEX); // Vista

		List<Parking> parkings = parkingService.getAll();

		mAV.addObject("parkings", parkings);
		mAV.addObject("parking", new Parking());

		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_PARKING_NEW);
		mAV.addObject("parking", new Parking());
		mAV.addObject("ubicaciones", ubicacionService.getAll());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("parking") Parking parking, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_PARKING_NEW);
		mAV.addObject("ubicaciones", ubicacionService.getAll());

		if (bindingResult.hasErrors()) {
			mAV.addObject("error", "Ha ocurrido un error en la validación");
		} else {
			parkingService.insertOrUpdate(parking);
			redirectAttributes.addFlashAttribute("success", "Entidad creada correctamente");
			return new ModelAndView(new RedirectView(ViewRouteHelper.DISPOSITIVO_PARKING_ROOT, true, false));
		}

		return mAV;
	}
	
	@GetMapping("/{idDispositivo}")
	public ModelAndView get(@PathVariable("idDispositivo") int idDispositivo) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_PARKING_UPDATE);
		mAV.addObject("parking", parkingService.findByIdDispositivo(idDispositivo));
		return mAV;
	}

}
