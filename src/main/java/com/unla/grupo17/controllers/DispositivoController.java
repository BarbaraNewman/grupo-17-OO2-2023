package com.unla.grupo17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo17.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_INDEX); // Vista
		return mAV;
	}

}
