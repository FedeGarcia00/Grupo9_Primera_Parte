package modelo;

import java.util.Iterator;

public abstract class DecoratorPago implements IFactura {

	private IFactura encapsulado;
	double precioFinal;

	public DecoratorPago(IFactura encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	public double getPrecioFinal() {
		return this.precioFinal;
	}

	public IFactura getEncapsulado() {
		return encapsulado;
	}

	public double getPrecio() {
		return encapsulado.getPrecio();
	}

	public Abonado getAbonado() {
		return encapsulado.getAbonado();
	}

	@Override
	public String toString() {
		// Nombre abonado y dni
		// medio de pago
		// For eac precio de cada servicio,
		// precio total con y sin descuento
		Abonado abonado = getAbonado();
		String factura = "";
		Iterator<Monitoreo> iterator = abonado.getListaMonitoreos().iterator();

		factura += "Nombre: " + abonado.getNombre() + "\n" + "Dni: " + abonado.getDni() + "\n";

		while (iterator.hasNext()) {
			Monitoreo monitoreo = iterator.next();
			factura += "[" + monitoreo.getId() + "] - Direccion: " + monitoreo.getDomicilio() + " $"
					+ monitoreo.getPrecio() + "\n";
		}
		factura += "Precio sin descuento: " + encapsulado.getPrecio() + "\n";
		factura += "Precio con descuento: " + getPrecioFinal();
		return factura;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		DecoratorPago clonado = null;
		clonado = (DecoratorPago) super.clone();
		clonado.encapsulado = (IFactura) this.encapsulado.clone();
		return clonado;
	}
}
