package modelo;

import java.util.ArrayList;

//Singleton
public class Empresa 
{
	private static Empresa instancia = null;
	public ArrayList<Abonado> listaAbonados = new ArrayList<Abonado>();	
	public ArrayList<IFactura> listaFacturas = new ArrayList<IFactura>();	
	private Promocion promo = null;
	
	private Empresa(){
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

	public Promocion getPromo() {
		return this.promo;
	}

	public void setPromo(Promocion promo) {
		this.promo = promo;
	}

	public void newFactura(String dni, String metodoPago) {
		//get abonado con dni
		Abonado abonado = buscaAbonado(dni);	
		IFactura factura = FacturaFactory.crearFactura(abonado, metodoPago);
		listaFacturas.add(factura);
	}
	
	private Abonado buscaAbonado(String dni){
		Abonado abonadoEncontrado = null;

		for (Abonado abonado : listaAbonados) {
			if (abonado.getDni().equalsIgnoreCase(dni)) {
				abonadoEncontrado = abonado;
				break;
			}
		}
		return abonadoEncontrado;
	}
		
}