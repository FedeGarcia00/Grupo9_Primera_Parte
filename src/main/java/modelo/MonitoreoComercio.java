package modelo;

public class MonitoreoComercio extends Monitoreo 
{
	private static final double VALOR_BASE = 10000;
	
	public MonitoreoComercio(String domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	}
	
	//DD
	@Override
	public double aplicarDescuento(double monto, Promocion promo) {
		return promo == null ? monto : promo.getDescuentoComercio(monto);
	}
	
	@Override
	public double getPrecioBase() {
		return MonitoreoComercio.VALOR_BASE ;
	}

	
	
	
}
