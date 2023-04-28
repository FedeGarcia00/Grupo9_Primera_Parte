package modelo;

public class MonitoreoFactory  {
	
	//Aca atributos
	
	//Constructor

	public static IFactura crearMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String servicio, String promo) 
	{	
		IFactura encapsulado= null ;
		IFactura respuesta = null ;
	   
		if (servicio.equalsIgnoreCase("comercio"))
	        encapsulado = new M_Comercio(domicilio, cantCamaras, cantBotones, movilAcompanamiento, promo);
	    else 
			if (servicio.equalsIgnoreCase("vivienda"))
	        	encapsulado = new M_Vivienda(domicilio, cantCamaras, cantBotones, movilAcompanamiento, promo);
	    return respuesta;
	}
}
