package modelo;

public class M_Comercio extends Monitoreo 
{
	private final float valorBase = 10000;
	public M_Comercio(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
	{
		super(domicilio, cantCamaras, cantBotones, movilAcompanamiento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float valorServicioTotal() {
		// TODO Auto-generated method stub
		return this.valorBase + super.valorServicioAcompanamiento()+super.valorServicioBoton()+super.valorServicioCamara();
	}
}
