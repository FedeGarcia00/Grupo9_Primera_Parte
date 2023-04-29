package modelo;

public class MonitoreoComercio extends Monitoreo 
{
	private static final double VALOR_BASE = 10000;
	
	public MonitoreoComercio(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	}
	
	//DD
	@Override
	public double aplicarDescuento(double monto, IPromocion promo) {
		// TODO Auto-generated method stub
		return promo == null ? monto : promo.getDescuentoComercio(monto);
	}
	
	@Override
	public double getPrecioBase() {
		// TODO Auto-generated method stub
		return MonitoreoComercio.VALOR_BASE ;
	}

	
	
	
}
