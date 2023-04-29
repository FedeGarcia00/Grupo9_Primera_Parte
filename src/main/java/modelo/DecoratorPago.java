package modelo;

public abstract class DecoratorPago implements IFactura {
	private IFactura encapsulado;
	double precioFinal;

	public DecoratorPago(IFactura encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}
	
	public double getPrecioFinal()
	{
		return this.precioFinal;
	}
}
