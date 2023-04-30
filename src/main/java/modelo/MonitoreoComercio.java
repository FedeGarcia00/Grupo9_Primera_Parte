package modelo;

public class MonitoreoComercio extends Monitoreo {
	private static final double VALOR_BASE = 10000;


	public MonitoreoComercio(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) {
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	}

	@Override
	public double aplicarDescuento(double monto, IPromocion promo) {
		return promo == null ? monto : promo.getDescuentoComercio(monto);
	}

	@Override
	public double getPrecioBase() {
		return MonitoreoComercio.VALOR_BASE;
	}


}
