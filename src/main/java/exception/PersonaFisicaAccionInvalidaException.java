package exception;

import modelo.PersonaFisica;

public class PersonaFisicaAccionInvalidaException extends Exception {

  PersonaFisica persona;

  public PersonaFisicaAccionInvalidaException(PersonaFisica persona) {
    super("Operacion invalida");
    this.persona = persona;
  }

  public PersonaFisica getPersonaFisica() {
    return persona;
  }
}
