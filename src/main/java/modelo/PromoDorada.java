package modelo;

public class PromoDorada extends Promocion
{
	//DD
	@Override
	public double getDescuentoVivienda(double monto) {
		return monto - 1500.0;
	}

	@Override
	public double getDescuentoComercio(double monto) {
		return monto - 2500.0;
	}

}
