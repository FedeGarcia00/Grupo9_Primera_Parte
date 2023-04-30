package modelo;
/**
 * Clase que crea instancias de Monitoreo cuando se aplica alguna promición o cuando no las hay. <br>
 * Tiene métodos que calculan el precio del servicio contratado aplicando el descuento de la promoción 
 * o sin aplicar el descuento. <br>
 */
public abstract class Monitoreo {
	private static final double PRECIO_CAMARA = 3000;
	private static final double PRECIO_BOTON = 2000;
	private static final double PRECIO_ACOMPANAMIENTO = 7500;

	private static int siguienteId = 0;

	private Domicilio domicilio;
	private int id;
	private int cantCamaras;
	private int cantBotones;
	private boolean movilAcompanamiento;
	private IPromocion promo;
	
	/**
	 Crea una nueva instancia de Monitoreo con los parámetros especificados.<br>
	 *@param dom El domicilio del abonado que estara  sistema de monitoreo.<br> 
	 *@param cantCamaras La cantidad de cámaras de monitoreo que se instalarán en el domicilio.<br>
	 *@param cantBotones La cantidad de botones de pánico que quiere agregar el abonado.<br>
	 *@param movilAcompanamiento Indica si se solicita el servicio de acompañamiento móvil o no.<br>
	 */
	public Monitoreo(Domicilio dom, int cantCamaras, int cantBotones, boolean movilAcompanamiento) {
		this.domicilio = dom;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.movilAcompanamiento = movilAcompanamiento;
		this.id = ++siguienteId;
		this.promo = null;
	}

	/**
	 *Calcula el precio total de la contratación aplicando el descuento correspondiente a la promoción.<br>
	 *@return El precio total por los servicios contratados con el descuento de la promoción aplicado.<br>
	 */
	public double calculaPrecio() {
		double precio = this.getPrecioBase() + this.valorServicioCamara() + this.valorServicioBoton()
		+ this.valorServicioAcompanamiento();
		return this.aplicarDescuento(precio, this.promo);
	}
	
	public abstract double aplicarDescuento(double monto, IPromocion promo);

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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public int getId() {
		return id;
	}

	public IPromocion getPromo() {
		return promo;
	}

	public void setPromo(IPromocion promo) {
		this.promo = promo;
	}
}
