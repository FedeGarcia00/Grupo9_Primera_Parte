package modelo;

public class DecoratorPagoCheque extends DecoratorPago {

	public DecoratorPagoCheque(IFactura encapsulado) {
		super(encapsulado);
		this.precioFinal = encapsulado.getPrecio() * 1.1;
	}

}
