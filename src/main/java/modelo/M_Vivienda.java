package modelo;

public class M_Vivienda extends Monitoreo 
{
	private final float valorBase = 8500;
	public M_Vivienda(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String promo) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento, promo);
		this.precio = super.getPrecio() + this.valorBase;
	}


}
