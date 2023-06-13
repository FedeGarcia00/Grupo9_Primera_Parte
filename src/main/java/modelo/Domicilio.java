package modelo;

import java.io.Serializable;

public class Domicilio implements Serializable {

  private String calle;
  private int numero;

  public Domicilio(String nombre, int nro) {
    this.calle = nombre;
    this.numero = nro;
  }

  public String getCalle() {
    return calle;
  }

  public int getNro() {
    return numero;
  }

  @Override
  public boolean equals(Object object) {
    Domicilio domicilio = (Domicilio) object;

    return (
      this.calle.trim().equalsIgnoreCase(domicilio.calle.trim()) &&
      this.numero == domicilio.numero
    );
  }

  @Override
  public String toString() {
    return calle + " " + numero;
  }

  public Domicilio clone() {
    Domicilio domicilioClonado = null;
    try {
      domicilioClonado = (Domicilio) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException();
    }

    return domicilioClonado;
  }
}
