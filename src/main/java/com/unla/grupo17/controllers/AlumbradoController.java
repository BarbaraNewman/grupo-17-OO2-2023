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

import com.unla.grupo17.entities.Alumbrado;
import com.unla.grupo17.helpers.ViewRouteHelper;
import com.unla.grupo17.services.IAlumbradoService;

@Controller
@RequestMapping("dispositivo/alumbrado")
public class AlumbradoController {
	@Autowired
	@Qualifier("alumbradoService")
	private IAlumbradoService alumbradoService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_ALUMBRADO_INDEX);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		mAV.addObject("username", username);

		List<Alumbrado> alumbrados = alumbradoService.getall();

		mAV.addObject("alumbrados", alumbrados);
		mAV.addObject("alumbrado", new Alumbrado());

		return mAV;
	}

}
