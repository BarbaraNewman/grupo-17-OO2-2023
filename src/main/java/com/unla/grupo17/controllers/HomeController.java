package com.unla.grupo17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo17.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/") 
public class HomeController {
	//GET ejemplo SERVER/index
    @GetMapping("/index")
    public String index() {
        return ViewRouteHelper.INDEX; // Vista
    }
    
    //Redireccion al entrar a la direccion del server
//    @GetMapping("/")
//	public RedirectView redirectToHomeIndex() {
//		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
//	}

}
