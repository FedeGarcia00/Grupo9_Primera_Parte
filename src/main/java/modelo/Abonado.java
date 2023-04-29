package modelo;

import java.util.ArrayList;

public abstract class Abonado implements IFactura
{
	private String nombre;
	private String dni;
	private ArrayList<Domicilio> listaDomicilios = new ArrayList<Domicilio>();	
	private ArrayList<Monitoreo> listaMonitoreos = new ArrayList<Monitoreo>();
	
	public Abonado(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public void agregarMonitoreo(String domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String servicio, String promo) 
	{
		IFactura monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento, servicio, promo);
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
