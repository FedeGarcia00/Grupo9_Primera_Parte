package modelo;

public class MonitoreoFactory  {
	
	//Aca atributos
	
	//Constructor

	public static IFactura crearMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String servicio) 
	{	
		IFactura encapsulado= null ;
		IFactura respuesta = null ;
	   
		if (servicio.equalsIgnoreCase("comercio"))
	        encapsulado = new MonitoreoComercio(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	    else 
			if (servicio.equalsIgnoreCase("vivienda"))
	        	encapsulado = new MonitoreoVivienda(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	    return respuesta;
	}
}
