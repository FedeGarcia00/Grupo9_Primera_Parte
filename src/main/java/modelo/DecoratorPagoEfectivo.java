package modelo;

public class DecoratorPagoEfectivo extends DecoratorPago {

    public DecoratorPagoEfectivo(IFactura encapsulado) {
		super(encapsulado);
        this.precioFinal = encapsulado.getPrecio()*0.8;
	}
}
