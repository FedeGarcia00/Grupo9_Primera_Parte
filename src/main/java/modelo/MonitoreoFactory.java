package modelo;

public class MonitoreoFactory {

	public static Monitoreo crearMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones,
			boolean movilAcompanamiento, String servicio) {
		Monitoreo respuesta = null;
		if (servicio.equalsIgnoreCase("comercio"))
			respuesta = new MonitoreoComercio(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		else if (servicio.equalsIgnoreCase("vivienda"))
			respuesta = new MonitoreoVivienda(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		return respuesta;
	}

}
