package modelo;

public class M_Comercio extends Monitoreo 
{
	private final float valorBase = 10000;
	public M_Comercio(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento, String promo) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento, promo);
		this.precio = super.getPrecio() + this.valorBase;
	}


}
