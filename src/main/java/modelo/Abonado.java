package modelo;

import java.util.ArrayList;

public abstract class Abonado implements IFactura
{
	private String nombre;
	private int dni;
	private ArrayList<Domicilio> listaDomicilios = new ArrayList<Domicilio>();	
	private ArrayList<IFactura> listaMonitoreos = new ArrayList<IFactura>();
	
	public Abonado(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public void agregarMonitoreo(String domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String servicio, String promo) 
	{
		IFactura monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento, servicio, promo);	
	}

	
}
