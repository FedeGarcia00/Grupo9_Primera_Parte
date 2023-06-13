package controlador;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Abonado;
import modelo.Domicilio;
import modelo.Empresa;
import modelo.GestorVisitas;
import modelo.IFactura;
import modelo.Monitoreo;
import modelo.Tecnico;
import persistencia.Persistencia;
import vista.IVista;
import vista.Ventana;

public class controlador implements ActionListener, Observer {

  private Empresa empresa;
  private GestorVisitas gestorVisitas = new GestorVisitas();
  private Persistencia persistencia = new Persistencia();
  private IVista vista;

  public controlador() {
    this.vista = new Ventana();
    this.vista.setActionListener(this);
  }

  public IVista getVista() {
    return vista;
  }

  public void setVista(IVista vista) {
    this.vista = vista;
    this.vista.setActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String comando = e.getActionCommand();

    // aca handleamos todos lops botones
    if (comando.equalsIgnoreCase("iniciarJornada")) {
      try {
        this.empresa = (Empresa) persistencia.leer();
      } catch (ClassNotFoundException e1) {
        //e1.printStackTrace();
      } catch (IOException e1) {
        //e1.printStackTrace();
      }
      if (empresa == null) empresa = Empresa.getInstancia();
      this.vista.iniciarJornada(
          new ArrayList<Object>(this.empresa.getListaAbonados())
        );
    } else if (comando.equalsIgnoreCase("finalizarJornada")) {
      try {
        this.persistencia.escribir(this.empresa);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      this.vista.finalizarJornada(); // hay que hacer esta funcion en vista que deshabilite los botones para
      // operar

    } else if (comando.equalsIgnoreCase("agregarAbonado")) {
      Abonado abonado =
        this.empresa.agregarAbonado(
            this.vista.getTipoAbonado(),
            this.vista.getNombreAbonado(),
            this.vista.getDNI_empresa()
          );
      if (abonado != null) {
        this.vista.setLogsEmpresa("Se agrego el abonado con exito");
      } else {
        this.vista.setLogsEmpresa("No se pudo agregar el abonado");
      }
      this.vista.updateAbonados_abonados(
          new ArrayList<Object>(this.empresa.getListaAbonados())
        );
      this.vista.updateAbonados_tecnicos(
          new ArrayList<Object>(this.empresa.getListaAbonados())
        );
    } else if (comando.equalsIgnoreCase("actualizarMesFacturacion")) {
      this.empresa.actualizarMes();
      Abonado abonado = (Abonado) this.vista.getAbonado_abonados();
      this.vista.setComboFacturas_abonados(
          new ArrayList<Object>(abonado.getFacturas())
        );
      this.vista.setLogsEmpresa("Se generaron las nuevas facturas");
    } else if (comando.equalsIgnoreCase("agregarMonitoreo")) {
      Abonado abonado = (Abonado) this.vista.getAbonado_abonados();
      Domicilio domicilio = new Domicilio(
        this.vista.getCalle(),
        this.vista.getNro()
      );

      try {
        try {
          abonado.agregarMonitoreo(
            domicilio,
            this.vista.getCamaras(),
            this.vista.getBotones(),
            this.vista.getMovilAcompaniamiento(),
            this.vista.getTipoServicio(),
            this.vista.getPromo()
          );

          this.vista.setComboMonitoreo_abonados(
              new ArrayList<Object>(abonado.getMonitoreos())
            );
          this.vista.setComboMonitoreo_tecnicos(
              new ArrayList<Object>(abonado.getMonitoreos())
            );
        } catch (PersonaFisicaAccionInvalidaException e1) {
          e1.printStackTrace();
        }
        this.vista.setLogsAbonado(
            "Se agrego correctamente el servicio de monitoreo"
          );
      } catch (DomicilioDuplicadoException e1) {
        this.vista.setLogsAbonado("Ya hay un servicio en ese domicilio");
        e1.printStackTrace();
      }
    } else if (comando.equalsIgnoreCase("bajaMonitoreo")) {
      Abonado abonado;
      try {
        abonado = (Abonado) this.vista.getAbonado_abonados();
        try {
          abonado.bajaServicioContratado(
            ((Monitoreo) this.vista.getMonitoreo_abonados()).getId()
          );
        } catch (PersonaFisicaAccionInvalidaException e1) {
          e1.printStackTrace();
        }
        this.vista.setLogsAbonado("Se dio de baja el monitoreo");
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    } else if (comando.equalsIgnoreCase("pagarFactura")) {
      Abonado abonado = (Abonado) this.vista.getAbonado_abonados();
      IFactura factura = (IFactura) this.vista.getFactura_abonados();
      try {
        double precio = abonado.pagarFactura(factura, "Efectivo");
        String log = "Se pago la factura con un total de " + precio;
        this.vista.setLogsAbonado(log);
      } catch (PersonaFisicaAccionInvalidaException e1) {
        this.vista.setLogsAbonado(
            "El abonado es moroso, no se puso pagar la factura"
          );
        e1.printStackTrace();
      }
    } else if (comando.equalsIgnoreCase("agregarTecnico")) {
      this.empresa.altaTecnico(this.vista.getNombreTecnico());
      this.vista.setLogsTecnicos("Se agrego correctamente el tecnico");
      this.vista.setComboTecnicos_tecnicos(
          new ArrayList<Object>(empresa.getListaTecnicos())
        );
    } else if (comando.equalsIgnoreCase("despedirTecnico")) {
      this.empresa.bajaTecnico(
          ((Tecnico) this.vista.getTecnico_tecnicos()).getIdTecnico()
        );
      this.vista.setLogsTecnicos("Se dio de baja el tecnico");
    } else if (comando.equalsIgnoreCase("solicitarTecnico")) {
      this.gestorVisitas.solicitarTecnico(
          (Monitoreo) this.vista.getMonitoreo_tecnicos()
        );
    } else if (comando.equalsIgnoreCase("cargaDatosAbonado")) {
      Abonado abonado = (Abonado) this.vista.getAbonado_abonados();
      this.vista.setComboMonitoreo_abonados(
          new ArrayList<Object>(abonado.getMonitoreos())
        );
      this.vista.setComboFacturas_abonados(
          new ArrayList<Object>(abonado.getFacturas())
        );
      this.vista.setComboMonitoreo_tecnicos(
          new ArrayList<Object>(abonado.getMonitoreos())
        );
    } else if (comando.equalsIgnoreCase("cargaDatosMonitoreos")) {
      Abonado abonado = (Abonado) this.vista.getAbonado_tecnicos();
      this.vista.setComboMonitoreo_tecnicos(
          new ArrayList<Object>(abonado.getMonitoreos())
        );
    } else if (comando.equalsIgnoreCase("cargaDatosTecnicos")) {
      this.vista.setComboTecnicos_tecnicos(
          new ArrayList<Object>(this.empresa.getListaTecnicos())
        );
    }

    this.vista.actualizarDatos();
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    this.vista.setLogsTecnicos(arg1.toString());
  }
}
