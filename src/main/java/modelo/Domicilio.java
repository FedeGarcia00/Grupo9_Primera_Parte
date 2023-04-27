package modelo;

public class Domicilio 
{
	private String calle;
	private int nro;
	
	public Domicilio(String calle, int nro) 
	{
		this.calle = calle;
		this.nro = nro;
	}

	public String getCalle() {
		return calle;
	}
	public int getNro() {
		return nro;
	}
}
