package modelo;

public abstract class DecoratorPago implements IMonitoreo {
	private IMonitoreo encapsulado;

	public DecoratorPago(IMonitoreo encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}
	
}
