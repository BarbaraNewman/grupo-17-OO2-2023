package com.unla.grupo17.helpers;

public class ViewRouteHelper {
	// VIEWS //
	// HOME
	public final static String INDEX = "/home/index"; // nombre del template .html

	// UBICACION
	public final static String UBICACION_INDEX = "/ubicacion/index";
	public final static String UBICACION_NEW = "/ubicacion/new";
	public final static String UBICACION_UPDATE = "/ubicacion/update";
	public final static String UBICACION_EVENTO = "/ubicacion/events";

	// EVENTO
	public final static String EVENTO_INDEX = "/evento/index";
	public final static String EVENTO_DETAILS = "/evento/details";

	// DISPOSITIVO
	public final static String DISPOSITIVO_INDEX = "dispositivo/index";
	public final static String DISPOSITIVO_EVENTO = "dispositivo/events";

	// CONTENEDOR
	public final static String DISPOSITIVO_CONTENEDOR_INDEX = "/contenedor/index";
	public final static String DISPOSITIVO_CONTENEDOR_NEW = "/contenedor/new";
	public final static String DISPOSITIVO_CONTENEDOR_UPDATE = "/contenedor/update";

	// PARKING
	public final static String DISPOSITIVO_PARKING_INDEX = "/parking/index";
	public final static String DISPOSITIVO_PARKING_NEW = "/parking/new";
	public final static String DISPOSITIVO_PARKING_UPDATE = "/parking/update";

	// USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";

	/////////////////
	// REDIRECTION //
	public final static String ROUTE_INDEX = "/index";
	public final static String UBICACION_ROOT = "/ubicacion";
	public final static String EVENTO_ROOT = "/evento";

	public final static String DISPOSITIVO_CONTENEDOR_ROOT = "/dispositivo/contenedor";
	public final static String DISPOSITIVO_PARKING_ROOT = "/dispositivo/parking";
}
