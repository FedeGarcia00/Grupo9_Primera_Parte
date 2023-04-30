package modelo;

public class PersonaJuridica extends Abonado {

	public PersonaJuridica(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public double aplicarDescuentoCantidad(double monto, int cantidad) {
		return cantidad < 3 ? monto : monto / 2;
	}

}
