package modelo;

public class AbonadoFactory  {
	
	//Aca atributos
	
	//Constructor

	public static Abonado crearAbonado(String tipo, String nombre, String dni) {
		
		Abonado respuesta = null;
	   
		if (tipo.equalsIgnoreCase("PersonaFisica"))
	        respuesta = new PersonaFisica(nombre, dni);
	    else 
			if (tipo.equalsIgnoreCase("PersonaJuridica"))
	        	respuesta = new PersonaJuridica(nombre, dni);

	    return respuesta;
	}

}