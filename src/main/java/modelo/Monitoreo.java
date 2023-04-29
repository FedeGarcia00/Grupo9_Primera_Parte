package modelo;

public abstract class Monitoreo {
	private static final double PRECIO_CAMARA = 3000;
	private static final double PRECIO_BOTON = 2000;
	private static final double PRECIO_ACOMPANAMIENTO = 7500;

	private static int siguienteId = 0;

	private String domicilio;
	private int id;
	private int cantCamaras;
	private int cantBotones;
	private boolean movilAcompanamiento;
	private double precio;

	public Monitoreo(String dom, int cantCamaras, int cantBotones, boolean movilAcompanamiento, Promocion promo) {
		this.domicilio = dom;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.movilAcompanamiento = movilAcompanamiento;
		this.precio = calculaPrecio(promo);
		this.id = ++siguienteId;
	}

	public Monitoreo(String dom, int cantCamaras, int cantBotones, boolean movilAcompanamiento) {
		this.domicilio = dom;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.movilAcompanamiento = movilAcompanamiento;
		this.precio = calculaPrecio();
		this.id = ++siguienteId;
	}

	// Template
	public double calculaPrecio(Promocion promo) {
		double precio = this.getPrecioBase() + this.valorServicioCamara() + this.valorServicioBoton()
				+ this.valorServicioAcompanamiento();
		return this.aplicarDescuento(precio, promo);
	}

	public double calculaPrecio() {
		double precio = this.getPrecioBase() + this.valorServicioCamara() + this.valorServicioBoton()
				+ this.valorServicioAcompanamiento();
		return precio;
	}

	public abstract double aplicarDescuento(double monto, Promocion promo);

	public abstract double getPrecioBase();

	public double valorServicioCamara() {
		return Monitoreo.PRECIO_CAMARA * this.cantCamaras;
	}

	public double valorServicioBoton() {
		return Monitoreo.PRECIO_BOTON * this.cantBotones;
	}

	public double valorServicioAcompanamiento() {
		return this.movilAcompanamiento ? Monitoreo.PRECIO_ACOMPANAMIENTO : 0;
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

	public String getDomicilio() {
		return domicilio;
	}

	public double getPrecio() {
		return precio;
	}

	public int getId() {
		return id;
	}
}
