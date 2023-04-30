package modelo;

public class PersonaJuridica extends Abonado {

	public PersonaJuridica(String nombre, String dni) {
		super(nombre, dni);
	}

	@Override
	public double aplicarDescuentoCantidad(double monto, int cantidad) {
		return cantidad < 3 ? monto : monto / 2;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Los abonados de tipo persona juridica no son clonables");
	}
}
