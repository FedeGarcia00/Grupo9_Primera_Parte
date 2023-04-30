package modelo;

public class PersonaFisica extends Abonado {

	public PersonaFisica(String nombre, String dni) {
		super(nombre, dni);
	}

	@Override
	public double aplicarDescuentoCantidad(double monto, int cantidad) {
		return monto;
	}

	public PersonaFisica clone() {
		try {
			PersonaFisica personaFisicaClonada = (PersonaFisica) super.clone();
			return personaFisicaClonada;
		} catch (CloneNotSupportedException e) { // Nunca va a entrar aca
			throw new RuntimeException(e);
		}
	}

}