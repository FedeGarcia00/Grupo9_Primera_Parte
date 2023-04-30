package modelo;

public class AbonadoNoPoseeDomicilioException extends Exception {
    Domicilio domicilio;

    public AbonadoNoPoseeDomicilioException(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getMensaje() {
        return "El abonado no posee un domicilio en la dirección " + this.domicilio.toString();
    }

}