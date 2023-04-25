package modelo;

import java.util.ArrayList;

public abstract class Abonado implements IMonitoreo
{
	private String nombre;
	private int dni;
	private ArrayList<Domicilio> listaDomicilios = new ArrayList<Domicilio>();	
	private ArrayList<IMonitoreo> listaMonitoreos = new ArrayList<IMonitoreo>();
}
