package modelo;

public abstract class Monitoreo implements IFactura
{
	private static final double PRECIO_CAMARA = 3000;
	private static final double PRECIO_BOTON = 2000;
	private static final double PRECIO_ACOMPANAMIENTO = 7500;
	
	private static int siguienteId = 0;
	
	private Domicilio domicilio;
	private int id;
	private int cantCamaras;
	private int cantBotones;
	private boolean movilAcompanamiento;
	
	
	
	public Monitoreo(Domicilio dom, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		this.domicilio = dom;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.movilAcompanamiento = movilAcompanamiento;
		this.id = ++siguienteId;
	}

	//Template
	public double getPrecio(IPromocion promo)
	{
		double precio = this.valorServicioCamara() + this.valorServicioBoton() + this.valorServicioAcompanamiento();
		
		return this.aplicarDescuento(precio + this.getPrecioBase(), promo);
	}
	
	public double getPrecio()
	{
		return this.getPrecio(null);
	}
	
	
	public abstract double aplicarDescuento(double monto, IPromocion promo);
	
	public abstract double getPrecioBase();
	

	public double valorServicioCamara()
	{
		return Monitoreo.PRECIO_CAMARA * this.cantCamaras;
	}
	
	public double valorServicioBoton()
	{
		return Monitoreo.PRECIO_BOTON * this.cantBotones;
	}
	
	public double valorServicioAcompanamiento()
	{
		return this.movilAcompanamiento ? 7500 : 0;
	}
	
	public double getPrecioCamara() {
		return Monitoreo.PRECIO_CAMARA;
	}
	public int getCantCamaras() {
		return cantCamaras;
	}
	public double getPrecioBoton() {
		return Monitoreo.PRECIO_BOTON;
	}
	public int getCantBotones() {
		return cantBotones;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	
}
