package modelo;

public class PromoPlatino implements IPromocion
{
	//DD
	@Override
	public double getDescuentoVivienda(double monto) {
		// TODO Auto-generated method stub
		return monto*0.7;
	}

	@Override
	public double getDescuentoComercio(double monto) {
		// TODO Auto-generated method stub
		return monto*0.65;
	}

}
