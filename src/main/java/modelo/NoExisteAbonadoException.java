package modelo;

public class NoExisteAbonadoException extends Exception {
    String dni;

    public NoExisteAbonadoException(String dni) {
        this.dni = dni;
    }

    public String getMensaje() {
        return "No existe un abonado con el dni " + this.dni;
    }

}