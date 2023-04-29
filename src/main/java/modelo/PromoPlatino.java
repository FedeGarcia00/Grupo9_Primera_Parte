package modelo;

public class PromoPlatino extends Promocion
{
	//DD
	@Override
	public double getDescuentoVivienda(double monto) {
		return monto*0.7;
	}

	@Override
	public double getDescuentoComercio(double monto) {
		return monto*0.65;
	}

}
