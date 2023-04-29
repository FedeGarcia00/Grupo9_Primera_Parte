package prueba;

import modelo.Empresa;
import modelo.Abonado;

public class prueba {

public static void main(String[] args) {
    
}
    Empresa empresa = Empresa.getInstancia()
    
    empresa.agregarAbonado("PersonaJuridica", "Juancito", "20456789", "tarjeta");
    empresa.agregarAbonado("PersonaFisica", "Pablito", "30123456", "cheque");

    Abonado abonado = empresa.getAbonado("20456789");

    abonado.agregarMonitoreo("Funes 1234", 2, 3, true, "comercio", "dorada");
    abonado.agregarMonitoreo("Chaco 3456", 4, 1, false, "vivienda", "platino");
    abonado.agregarMonitoreo("San Juan 3487", 1, 0, false, "vivienda", "");


}
