package modelo;

public abstract class Monitoreo implements IMonitoreo
{
	private Domicilio domicilio;
	public static int siguienteId=0;
	private int id;
	private final float precioCamara = 3000;
	private int cantCamaras;
	private final float precioBoton = 2000;
	private int cantBotones;
	private boolean movilAcompanamiento;
	private int precioFinal;
	
	public Monitoreo(Domicilio dom, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		this.domicilio = dom;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.movilAcompanamiento = movilAcompanamiento;
		this.id = ++siguienteId;
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
	
	public abstract float valorServicioTotal();
	
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
