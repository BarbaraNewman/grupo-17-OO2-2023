package com.unla.grupo17.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo17.entities.Sanitario;
import com.unla.grupo17.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/dispositivo/sanitario")
public class SanitarioController {

	@Autowired
	@Qualifier("sanitarioService")
	private ISanitarioService sanitarioService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SANITARIO_INDEX); // Vista

		List<Sanitario> sanitario = sanitarioService.getAll();

		mAV.addObject("sanitarios", sanitarios);
		mAV.addObject("sanitario", new Sanitario());

		return mAV;
	}

}