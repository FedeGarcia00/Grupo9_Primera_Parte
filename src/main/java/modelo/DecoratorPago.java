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

	public IFactura getEncapsulado() {
		return encapsulado;
	}

	public double getPrecio() {
		return encapsulado.getPrecio();
	}

	public String getAbonado() {
		return encapsulado.getAbonado();
	}
}
