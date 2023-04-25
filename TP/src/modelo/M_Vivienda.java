package modelo;

public class M_Vivienda extends Monitoreo 
{
	private final float valorBase = 8500;
	public M_Vivienda(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento) 
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
