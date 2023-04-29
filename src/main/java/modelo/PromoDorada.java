package modelo;

public class PromoDorada extends Promocion
{
	public static PromoDorada instancia=null;
	//DD
	@Override
	public double getDescuentoVivienda(double monto) {
		return monto - 1500.0;
	}

	@Override
	public double getDescuentoComercio(double monto) {
		return monto - 2500.0;
	}

	public static PromoDorada getInstancia() 
	{
		if(instancia == null)
			instancia = new PromoDorada();
		
		return instancia;
	}

}
