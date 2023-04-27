package modelo;

public class MonitoreoFactory  {
	
	//Aca atributos
	
	//Constructor

	public static IMonitoreo getMonitoreo(String servicio, String pago) {
		
		IMonitoreo encapsulado= null ;
		IMonitoreo respuesta = null ;
	   
		if (servicio.equalsIgnoreCase("comercio"))
	        encapsulado = new M_Comercio(atributos);
	    else if (servicio.equalsIgnoreCase("vivienda"))
	        encapsulado = new M_Vivienda(atributos);

	    if (encapsulado != null)
	    {
	        if (pago.equalsIgnoreCase("efectivo"))
	            respuesta = new DecoratorPagoEfectivo(encapsulado);
	        else if (pago.equalsIgnoreCase("cheque"))
	            respuesta = new DecoratorPagoCheque(encapsulado);
	        else if (pago.equalsIgnoreCase("tarjeta"))
	            respuesta = new DecoratorPagoTarjeta(encapsulado);

	    }

	    return respuesta;
		
	}


}
