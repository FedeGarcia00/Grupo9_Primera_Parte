package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

//import modelo.IBuscaminas;

public interface IVista {
  void setActionListener(ActionListener actionListener);

  // primera pestaña

  void iniciarJornada(ArrayList<Object> ListaAbonados);

  void finalizarJornada();

  void actualizarMes();

  String getNombreAbonado();

  String getDNI_empresa();

  String getTipoAbonado();

  void setLogsEmpresa(String string);

  // segunda pestaña

  Object getAbonado_abonados();

  String getDNI_abonados(); // de la combo

  void updateAbonados_abonados(ArrayList<Object> ListaAbonados);

  void setComboMonitoreo_abonados(ArrayList<Object> arrayList);

  void setComboFacturas_abonados(ArrayList<Object> arrayList);

  String getCalle();

  int getNro();

  String getTipoServicio();

  int getCamaras();

  int getBotones();

  boolean getMovilAcompaniamiento();

  Object getMonitoreo_abonados();

  Object getFactura_abonados();

  void setLogsAbonado(String string);

  // tercera pestaña

  Object getAbonado_tecnicos();

  void updateAbonados_tecnicos(ArrayList<Object> ListaAbonados);

  void setComboMonitoreo_tecnicos(ArrayList<Object> arrayList);

  void setComboTecnicos_tecnicos(ArrayList<Object> arrayList);

  Object getTecnico_tecnicos();

  String getNombreTecnico();

  Object getMonitoreo_tecnicos();

  void setLogsTecnicos(String string);
  String getPromo();

  //generales

  public void actualizarDatos();
}
