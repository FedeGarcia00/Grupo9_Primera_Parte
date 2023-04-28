package prueba;

import modelo.Empresa;
import modelo.Abonado;

public class prueba {

public static void main(String[] args) {
    
}
    Empresa empresa = Empresa.getInstancia()
    
    empresa.agregarAbonado("PersonaJuridica", "Juancito", "20456789");
    empresa.agregarAbonado("PersonaFisica", "Pablito", "30123456");

    Abonado abonado = empresa.getAbonado(20456789);

    abonado.agregarMonitoreo("Funes 1234", 2, 3, true, "comercio", "tarjeta");
    abonado.agregarMonitoreo("Chaco 3456", 4, 1, false, "vivienda", "cheque");
}
