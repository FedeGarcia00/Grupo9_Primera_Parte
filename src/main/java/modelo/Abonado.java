package modelo;

import java.util.ArrayList;

public abstract class Abonado {
	protected String nombre;
	protected String dni;
	private ArrayList<String> listaDomicilios = new ArrayList<String>();
	private ArrayList<Monitoreo> listaMonitoreos = new ArrayList<Monitoreo>();

	public void agregarMonitoreo(String domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento,
			String servicio, Promocion promo) {
		Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento,
				servicio, promo);
		listaMonitoreos.add(monitoreo);
		listaDomicilios.add(domicilio);
	}

	public void agregarMonitoreo(String domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento,
			String servicio) {
		Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento,
				servicio);
		listaMonitoreos.add(monitoreo);
		listaDomicilios.add(domicilio);
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDni() {
		return this.dni;
	}

	public ArrayList<Monitoreo> getListaMonitoreos() {
		return listaMonitoreos;
	}

}
