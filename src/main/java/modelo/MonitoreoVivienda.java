package modelo;

public class MonitoreoVivienda extends Monitoreo 
{
	private static final double VALOR_BASE= 8500;
	
	public MonitoreoVivienda(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	}
	
	//DD
	@Override
	public double aplicarDescuento(double monto, IPromocion promo) {
		// TODO Auto-generated method stub
		return promo == null ? monto : promo.getDescuentoVivienda(monto);
	}

	@Override
	public double getPrecioBase() {
		// TODO Auto-generated method stub
		return MonitoreoVivienda.VALOR_BASE;
	}


}
