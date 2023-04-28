package modelo;

public class M_Comercio extends Monitoreo 
{
	private final float valorBase = 10000;
	public M_Comercio(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		this.precioFinal = super.getPrecioFinal() + this.valorBase;
	}


}
