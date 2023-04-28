package modelo;

import java.util.ArrayList;

public abstract class Abonado implements IMonitoreo
{
	private String nombre;
	private int dni;
	private ArrayList<Domicilio> listaDomicilios = new ArrayList<Domicilio>();	
	private ArrayList<IMonitoreo> listaMonitoreos = new ArrayList<IMonitoreo>();
	
	public Abonado(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public void agregarServicio(String domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String servicio, String pago) {

		
	}

	
}
