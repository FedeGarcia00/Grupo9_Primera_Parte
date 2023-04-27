package modelo;

import java.util.ArrayList;

// con Singleton
public class Empresa 
{
	private static Empresa instancia = null;
	public ArrayList<Abonado> listaAbonados = new ArrayList<Abonado>();	
	
	private Empresa()
	{
		//...
	}
	
	public static Empresa getInstancia() 
	{
		if(instancia == null)
			instancia = new Empresa();
		
		return instancia;
	}
}
