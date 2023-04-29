package modelo;

public class PromoDorada implements IPromocion
{
	//DD
	@Override
	public double getDescuentoVivienda(double monto) {
		// TODO Auto-generated method stub
		return monto-1500;
	}

	@Override
	public double getDescuentoComercio(double monto) {
		// TODO Auto-generated method stub
		return monto-2500;
	}

}
