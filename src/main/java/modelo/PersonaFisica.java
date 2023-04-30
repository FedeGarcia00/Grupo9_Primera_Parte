package modelo;

public class PersonaFisica extends Abonado {
	
	public PersonaFisica(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public double aplicarDescuentoCantidad(double monto, int cantidad) {
		return monto;
	}
	
}