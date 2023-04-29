package modelo;

public class MonitoreoFactory {

	// Aca atributos

	// Constructor

	public static Monitoreo crearMonitoreo(String domicilio, int cantCamaras, int cantBotones,
			boolean movilAcompanamiento, String servicio) {
		Monitoreo respuesta = null;
		if (servicio.equalsIgnoreCase("comercio"))
			respuesta = new MonitoreoComercio(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		else if (servicio.equalsIgnoreCase("vivienda"))
			respuesta = new MonitoreoVivienda(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		return respuesta;
	}

	public static Monitoreo crearMonitoreo(String domicilio, int cantCamaras, int cantBotones,
			boolean movilAcompanamiento, String servicio, Promocion promo) {
		Monitoreo respuesta = null;
		if (servicio.equalsIgnoreCase("comercio"))
			respuesta = new MonitoreoComercio(domicilio, cantCamaras, cantBotones, movilAcompanamiento, promo);
		else if (servicio.equalsIgnoreCase("vivienda"))
			respuesta = new MonitoreoVivienda(domicilio, cantCamaras, cantBotones, movilAcompanamiento, promo);
		return respuesta;
	}
}
