package modelo;

public class MonitoreoVivienda extends Monitoreo {
	private static final double VALOR_BASE = 8500;


	public MonitoreoVivienda(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) {
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
	}

	@Override
	public double aplicarDescuento(double monto, IPromocion promo) {
		return promo == null ? monto : promo.getDescuentoVivienda(monto);
	}

	@Override
	public double getPrecioBase() {
		return MonitoreoVivienda.VALOR_BASE;
	}

}