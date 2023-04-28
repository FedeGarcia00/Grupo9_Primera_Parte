package modelo;

public abstract class DecoratorPago implements IFactura {
	private IFactura encapsulado;

	public DecoratorPago(IFactura encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}
	
}
