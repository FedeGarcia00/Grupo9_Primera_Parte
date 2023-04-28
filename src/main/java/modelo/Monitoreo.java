package modelo;

public abstract class Monitoreo implements IFactura
{
	protected Domicilio domicilio;
	private static int siguienteId=0;
	private int id;
	protected final float precioCamara = 3000;
	protected int cantCamaras;
	protected final float precioBoton = 2000;
	protected int cantBotones;
	protected boolean movilAcompanamiento;
	protected final float precioAcompanamiento = 7500;
	protected float precio;
	protected String promo;
	
	
	public Monitoreo(Domicilio dom, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String promo) 
	{
		this.domicilio = dom;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.movilAcompanamiento = movilAcompanamiento;
		this.promo = promo;
		this.id = ++siguienteId;
	}


	public float getPrecio(){
		return valorServicioCamara()+valorServicioBoton()+valorServicioAcompanamiento();
	}

	public float valorServicioCamara()
	{
		return this.precioCamara * this.cantCamaras;
	}
	
	public float valorServicioBoton()
	{
		return this.precioBoton * this.cantBotones;
	}
	
	public float valorServicioAcompanamiento()
	{
		return this.movilAcompanamiento ? 7500 : 0;
	}
	
	public float getPrecioCamara() {
		return precioCamara;
	}
	public int getCantCamaras() {
		return cantCamaras;
	}
	public float getPrecioBoton() {
		return precioBoton;
	}
	public int getCantBotones() {
		return cantBotones;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	
}
