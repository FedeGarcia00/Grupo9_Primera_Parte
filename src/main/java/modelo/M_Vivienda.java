package modelo;

public class M_Vivienda extends Monitoreo 
{
	private final float valorBase = 8500;
	public M_Vivienda(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		this.precioFinal = super.getPrecioFinal() + this.valorBase;
	}


}
