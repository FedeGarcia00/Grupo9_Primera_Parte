package modelo;

public class DecoratorPagoCheque extends DecoratorPago {
	
	public DecoratorPagoCheque(IFactura encapsulado) {
		super(encapsulado);
		this.precioFinal = this.precio*1.1;
	}

	public double getPrecioFinal()
	{
		return this.precioFinal;
	}
}
