package modelo;

public class PromoPlatino implements IPromocion {
	public static PromoPlatino instancia = null;
	
	@Override
	public double getDescuentoVivienda(double monto) {
		return monto * 0.7;
	}

	@Override
	public double getDescuentoComercio(double monto) {
		return monto * 0.65;
	}

	public static PromoPlatino getInstancia() {
		if (instancia == null)
			instancia = new PromoPlatino();

		return instancia;
	}
}
