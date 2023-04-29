package modelo;

import java.util.ArrayList;

//Singleton
public class Empresa 
{
	private static Empresa instancia = null;
	public ArrayList<Abonado> listaAbonados = new ArrayList<Abonado>();	
	private IPromocion promo = null;
	
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

	public void agregarAbonado(String tipo, String nombre, String dni)
	{	
		Abonado abonado = AbonadoFactory.crearAbonado(tipo, nombre, dni); 
		listaAbonados.add(abonado);
	}

	public Abonado getAbonado(String dni)
	{
		Abonado respuesta = null;

		return respuesta;
	}

	public IPromocion getPromo() {
		return promo;
	}

	public void setPromo(IPromocion promo) {
		this.promo = promo;
	}
	
	
}
