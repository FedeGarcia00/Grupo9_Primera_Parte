package modelo;

public class NoExisteFacturaAbonadoException extends Exception {
    String dni;

    public NoExisteFacturaAbonadoException(String dni) {
        this.dni = dni;
    }

    public String getMensaje() {
        return "No existe factura para el abonado con el dni: " + this.dni;
    }
}
