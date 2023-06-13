package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ventana
  extends JFrame
  implements IVista, KeyListener, ActionListener, PropertyChangeListener {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private ActionListener actionListener;
  //private JPanel contentPanel;

  private JTextField fieldNombreAgregar_empresa;
  private JTextField fieldDNIAgregar_empresa;
  private JTextField fieldBotones_abonados;
  private JTextField fieldCamaras_abonados;
  private JTextField fieldNro_abonados;
  private JTextField fieldDomicilio_abonados;
  private JTextField fieldNombreAgregar_tecnicos;

  private JButton btnIniciarJornada_empresa;
  private JButton btnAgregar_empresa;
  private JButton btnFinalizarJornada_empresa;
  private JButton btnActualizarMesFacturacion_empresa;
  private JButton btnAgregarMonitoreo_abonados;
  private JButton btnBajaMonitoreo_abonados;
  private JButton btnPagarFactura_abonados;
  private JButton btnAgregar_tecnicos;
  private JButton btnDespedir_tecnicos;
  private JButton btnSolicitar_tecnicos;

  private JComboBox<Object> comboTipo_empresa;
  private JComboBox<Object> comboAbonado_abonados;
  private JComboBox<Object> comboFacturas_abonados;
  private JComboBox<Object> comboBajaMonitoreo_abonados;
  private JComboBox<Object> comboTipo_abonados;
  private JComboBox<Object> comboTecnicos_tecnicos;
  private JComboBox<Object> comboAbonado_tecnicos;
  private JComboBox<Object> comboMonitoreo_tecnicos;
  private JComboBox<Object> comboDespedir_tecnicos;
  private JComboBox<Object> comboPromo_abonados;

  private JCheckBox checkMovil_abonados;

  private JTextPane logs_tecnico;
  private JTextPane logs_abonados;
  private JTextPane logs_empresa;

  /**
   * Launch the application.
   */
  /**
   * Create the frame.
   */
  public Ventana() {
    // Crear la ventana
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(364, 573);

    JTabbedPane tabbedPane = new JTabbedPane();

    JPanel panelEmpresa = new JPanel();
    tabbedPane.addTab("Empresa", panelEmpresa);
    panelEmpresa.setLayout(null);

    btnIniciarJornada_empresa = new JButton("Iniciar jornada");
    btnIniciarJornada_empresa.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnIniciarJornada_empresa.setBounds(13, 11, 314, 37);
    panelEmpresa.add(btnIniciarJornada_empresa);

    btnFinalizarJornada_empresa = new JButton("Finalizar Jornada");
    btnFinalizarJornada_empresa.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnFinalizarJornada_empresa.setBounds(13, 54, 314, 37);
    panelEmpresa.add(btnFinalizarJornada_empresa);

    btnActualizarMesFacturacion_empresa =
      new JButton("Actualizar mes facturacion");
    btnActualizarMesFacturacion_empresa.setFont(
      new Font("Tahoma", Font.BOLD, 14)
    );
    btnActualizarMesFacturacion_empresa.setBounds(14, 97, 313, 37);
    panelEmpresa.add(btnActualizarMesFacturacion_empresa);

    JLabel lblNewLabel = new JLabel("Agregar abonado");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblNewLabel.setBounds(13, 145, 246, 39);
    panelEmpresa.add(lblNewLabel);

    JLabel lblNewLabel_1 = new JLabel("Nombre");
    lblNewLabel_1.setBounds(10, 182, 84, 14);
    panelEmpresa.add(lblNewLabel_1);

    fieldNombreAgregar_empresa = new JTextField();
    fieldNombreAgregar_empresa.setBounds(104, 179, 220, 20);
    panelEmpresa.add(fieldNombreAgregar_empresa);
    fieldNombreAgregar_empresa.setColumns(10);

    JLabel lblNewLabel_1_1 = new JLabel("DNI");
    lblNewLabel_1_1.setBounds(10, 213, 84, 14);
    panelEmpresa.add(lblNewLabel_1_1);

    fieldDNIAgregar_empresa = new JTextField();
    fieldDNIAgregar_empresa.setColumns(10);
    fieldDNIAgregar_empresa.setBounds(104, 210, 220, 20);
    panelEmpresa.add(fieldDNIAgregar_empresa);

    JLabel lblNewLabel_1_1_1_2 = new JLabel("Tipo");
    lblNewLabel_1_1_1_2.setBounds(6, 250, 93, 14);
    panelEmpresa.add(lblNewLabel_1_1_1_2);

    comboTipo_empresa = new JComboBox<Object>();
    comboTipo_empresa.setEnabled(true);
    comboTipo_empresa.setBounds(105, 246, 212, 22);
    panelEmpresa.add(comboTipo_empresa);

    btnAgregar_empresa = new JButton("Agregar");
    btnAgregar_empresa.setEnabled(true);
    btnAgregar_empresa.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnAgregar_empresa.setBounds(125, 279, 86, 22);
    panelEmpresa.add(btnAgregar_empresa);

    logs_empresa = new JTextPane();
    // logs_empresa.setDropMode(DropMode.ON);
    logs_empresa.setEditable(false);
    logs_empresa.setText("");
    logs_empresa.setBounds(0, 363, 343, 143);
    panelEmpresa.add(logs_empresa);

    // Agregar el panel de pestañas a la ventana
    getContentPane().add(tabbedPane);

    JPanel panelAbonados = new JPanel();
    tabbedPane.addTab("Abonados", panelAbonados);
    panelAbonados.setLayout(null);

    JLabel lblNewLabel_1_2_1 = new JLabel(
      "Seleccione un abonado para poder operar"
    );
    lblNewLabel_1_2_1.setBounds(10, 11, 323, 14);
    panelAbonados.add(lblNewLabel_1_2_1);

    JLabel lblNewLabel_1_2_1_1 = new JLabel("Abonado");
    lblNewLabel_1_2_1_1.setBounds(10, 36, 93, 14);
    panelAbonados.add(lblNewLabel_1_2_1_1);

    comboAbonado_abonados = new JComboBox<Object>();
    comboAbonado_abonados.setBounds(113, 32, 220, 22);
    panelAbonados.add(comboAbonado_abonados);

    JLabel lblAgregarMonitoreo = new JLabel("Agregar monitoreo");
    lblAgregarMonitoreo.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblAgregarMonitoreo.setBounds(10, 53, 246, 37);
    panelAbonados.add(lblAgregarMonitoreo);

    JLabel lblNewLabel_1_1_1 = new JLabel("Tipo");
    lblNewLabel_1_1_1.setBounds(10, 147, 93, 14);
    panelAbonados.add(lblNewLabel_1_1_1);

    JLabel lblNewLabel_1_2 = new JLabel("Domicilio");
    lblNewLabel_1_2.setBounds(10, 90, 93, 14);
    panelAbonados.add(lblNewLabel_1_2);

    JLabel lblNewLabel_1_2_4 = new JLabel("Numero");
    lblNewLabel_1_2_4.setBounds(10, 119, 93, 14);
    panelAbonados.add(lblNewLabel_1_2_4);

    fieldDomicilio_abonados = new JTextField();
    fieldDomicilio_abonados.setColumns(10);
    fieldDomicilio_abonados.setBounds(113, 87, 220, 20);
    panelAbonados.add(fieldDomicilio_abonados);

    btnAgregarMonitoreo_abonados = new JButton("Agregar");
    btnAgregarMonitoreo_abonados.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnAgregarMonitoreo_abonados.setBounds(137, 251, 86, 22);
    panelAbonados.add(btnAgregarMonitoreo_abonados);

    comboTipo_abonados = new JComboBox<Object>();
    comboTipo_abonados.setBounds(113, 143, 220, 22);
    panelAbonados.add(comboTipo_abonados);

    JLabel lblDarDeBaja = new JLabel("Dar de baja monitoreo");
    lblDarDeBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDarDeBaja.setBounds(11, 276, 284, 37);
    panelAbonados.add(lblDarDeBaja);

    comboBajaMonitoreo_abonados = new JComboBox<Object>();
    comboBajaMonitoreo_abonados.setBounds(114, 307, 220, 22);
    panelAbonados.add(comboBajaMonitoreo_abonados);

    JLabel lblNewLabel_1_1_1_1 = new JLabel("Monitoreo");
    lblNewLabel_1_1_1_1.setBounds(11, 311, 93, 14);
    panelAbonados.add(lblNewLabel_1_1_1_1);

    btnBajaMonitoreo_abonados = new JButton("Baja");
    btnBajaMonitoreo_abonados.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnBajaMonitoreo_abonados.setBounds(124, 340, 86, 22);
    panelAbonados.add(btnBajaMonitoreo_abonados);

    JLabel lblPagarFactura = new JLabel("Pagar factura");
    lblPagarFactura.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPagarFactura.setBounds(11, 349, 284, 37);
    panelAbonados.add(lblPagarFactura);

    JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Factura");
    lblNewLabel_1_1_1_1_1.setBounds(11, 384, 93, 14);
    panelAbonados.add(lblNewLabel_1_1_1_1_1);

    comboFacturas_abonados = new JComboBox<Object>();
    comboFacturas_abonados.setBounds(114, 380, 220, 22);
    panelAbonados.add(comboFacturas_abonados);

    btnPagarFactura_abonados = new JButton("Pagar");
    btnPagarFactura_abonados.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnPagarFactura_abonados.setBounds(124, 413, 86, 22);
    panelAbonados.add(btnPagarFactura_abonados);

    logs_abonados = new JTextPane();
    logs_abonados.setText("");
    logs_abonados.setEditable(true);
    // logs_abonados.setDropMode(DropMode.ON);
    logs_abonados.setBounds(0, 444, 343, 62);
    panelAbonados.add(logs_abonados);

    fieldCamaras_abonados = new JTextField();
    fieldCamaras_abonados.setEnabled(true);
    fieldCamaras_abonados.setColumns(10);
    fieldCamaras_abonados.setBounds(113, 202, 59, 20);
    panelAbonados.add(fieldCamaras_abonados);

    JLabel lblNewLabel_1_2_3 = new JLabel("Cant. camaras");
    lblNewLabel_1_2_3.setBounds(10, 205, 93, 14);
    panelAbonados.add(lblNewLabel_1_2_3);

    JLabel lblNewLabel_1_2_3_1 = new JLabel("Cant. botones");
    lblNewLabel_1_2_3_1.setBounds(10, 229, 93, 14);
    panelAbonados.add(lblNewLabel_1_2_3_1);

    fieldBotones_abonados = new JTextField();
    fieldBotones_abonados.setEnabled(true);
    fieldBotones_abonados.setColumns(10);
    fieldBotones_abonados.setBounds(113, 226, 59, 20);
    panelAbonados.add(fieldBotones_abonados);

    checkMovil_abonados = new JCheckBox("Movil");
    checkMovil_abonados.setBounds(229, 201, 59, 23);
    panelAbonados.add(checkMovil_abonados);

    fieldNro_abonados = new JTextField();
    fieldNro_abonados.setEnabled(true);
    fieldNro_abonados.setColumns(10);
    fieldNro_abonados.setBounds(113, 116, 220, 20);
    panelAbonados.add(fieldNro_abonados);

    comboPromo_abonados = new JComboBox<Object>();
    comboPromo_abonados.setBounds(113, 172, 220, 22);
    panelAbonados.add(comboPromo_abonados);

    JLabel lblNewLabel_1_1_1_3 = new JLabel("Promo");
    lblNewLabel_1_1_1_3.setBounds(10, 176, 93, 14);
    panelAbonados.add(lblNewLabel_1_1_1_3);

    // pestaña tecnicos

    JPanel panelTecnicos = new JPanel();
    tabbedPane.addTab("Tecnicos", panelTecnicos);
    panelTecnicos.setLayout(null);

    JLabel lblNewLabel_1_2_1_2 = new JLabel(
      "Seleccione un abonado que necesita un tecnico"
    );
    lblNewLabel_1_2_1_2.setBounds(10, 212, 323, 14);
    panelTecnicos.add(lblNewLabel_1_2_1_2);

    JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Abonado");
    lblNewLabel_1_2_1_1_1.setBounds(10, 239, 52, 14);
    panelTecnicos.add(lblNewLabel_1_2_1_1_1);

    comboAbonado_tecnicos = new JComboBox<Object>();
    comboAbonado_tecnicos.setBounds(113, 235, 220, 22);
    panelTecnicos.add(comboAbonado_tecnicos);

    JLabel lblAgregarTecnico = new JLabel("Agregar tecnico");
    lblAgregarTecnico.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblAgregarTecnico.setBounds(10, 8, 246, 37);
    panelTecnicos.add(lblAgregarTecnico);

    JLabel lblNewLabel_1_2_2 = new JLabel("Nombre");
    lblNewLabel_1_2_2.setBounds(10, 53, 52, 14);
    panelTecnicos.add(lblNewLabel_1_2_2);

    fieldNombreAgregar_tecnicos = new JTextField();
    fieldNombreAgregar_tecnicos.setColumns(10);
    fieldNombreAgregar_tecnicos.setBounds(113, 50, 220, 20);
    panelTecnicos.add(fieldNombreAgregar_tecnicos);

    btnAgregar_tecnicos = new JButton("Agregar");
    btnAgregar_tecnicos.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnAgregar_tecnicos.setBounds(137, 78, 86, 22);
    panelTecnicos.add(btnAgregar_tecnicos);

    JLabel lblDespedirTecnico = new JLabel("Despedir tecnico");
    lblDespedirTecnico.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDespedirTecnico.setBounds(6, 92, 246, 37);
    panelTecnicos.add(lblDespedirTecnico);

    JLabel lblNewLabel_1_2_2_1 = new JLabel("Tecnico");
    lblNewLabel_1_2_2_1.setBounds(16, 137, 56, 14);
    panelTecnicos.add(lblNewLabel_1_2_2_1);

    btnDespedir_tecnicos = new JButton("Despedir");
    btnDespedir_tecnicos.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnDespedir_tecnicos.setBounds(133, 162, 86, 22);
    panelTecnicos.add(btnDespedir_tecnicos);

    JLabel lblSolicitarTecnico = new JLabel("Solicitar tecnico");
    lblSolicitarTecnico.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblSolicitarTecnico.setBounds(6, 177, 246, 37);
    panelTecnicos.add(lblSolicitarTecnico);

    btnSolicitar_tecnicos = new JButton("Solicitar tecnico");
    btnSolicitar_tecnicos.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnSolicitar_tecnicos.setBounds(110, 289, 144, 22);
    panelTecnicos.add(btnSolicitar_tecnicos);

    logs_tecnico = new JTextPane();
    logs_tecnico.setText("");
    logs_tecnico.setEditable(true);
    // logs_tecnico.setDropMode(DropMode.ON);
    logs_tecnico.setBounds(0, 322, 343, 133);
    panelTecnicos.add(logs_tecnico);

    JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Monitoreo");
    lblNewLabel_1_2_1_1_1_1.setBounds(10, 268, 52, 14);
    panelTecnicos.add(lblNewLabel_1_2_1_1_1_1);

    comboMonitoreo_tecnicos = new JComboBox<Object>();
    comboMonitoreo_tecnicos.setBounds(113, 264, 220, 22);
    panelTecnicos.add(comboMonitoreo_tecnicos);

    comboTecnicos_tecnicos = new JComboBox<Object>();
    comboTecnicos_tecnicos.setBounds(91, 133, 220, 22);
    panelTecnicos.add(comboTecnicos_tecnicos);

    addListeners();
    inicializaEstados();
    // Mostrar la ventana
    setVisible(true);
    agregarAcciones();
  }

  // ACA TIENE QUE IR "NUESTRA PROGRAMACION"

  public void keyPressed(KeyEvent e) {}

  public void keyReleased(KeyEvent e) {
    // String NombreAgregar_empresa = "";
    // String DNIAgregar_empresa = "";
    // String Domicilio_abonados = "";
    // String NombreAgregar_tecnicos = "";
    // String NombreDespedir_tecnicos = "";

    // NombreAgregar_empresa = this.fieldNombreAgregar_empresa.getText();
    // DNIAgregar_empresa = this.fieldDNIAgregar_empresa.getText();
    // Domicilio_abonados = this.fieldDomicilio_abonados.getText();
    // NombreAgregar_tecnicos = this.fieldNombreAgregar_tecnicos.getText();

    // // Si no pone un nombre y un DNI no deja agregar abonado
    // boolean condicionAgregarAbonado = !NombreAgregar_empresa.isEmpty() &&
    //     sonCaracteresNoNumericos(NombreAgregar_empresa) &&
    //     !DNIAgregar_empresa.isEmpty() &&
    //     sonNumeros(DNIAgregar_empresa);
    // this.btnAgregar_empresa.setEnabled(condicionAgregarAbonado);
  }

  private boolean sonNumeros(String cadena) {
    for (char c : cadena.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  private boolean sonCaracteresNoNumericos(String cadena) {
    for (char c : cadena.toCharArray()) {
      if (Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  public void keyTyped(KeyEvent e) {}

  public void actionPerformed(ActionEvent e) {
    this.actionListener.actionPerformed(e);
    // String comboAbonado_abonados =
    // this.comboAbonado_abonados.getSelectedItem().toString();
    // String comboAbonado_abonados = "";
    // // Si no selecciona un abonado no puede hacer nada con la seccion abonado
    // boolean condicionHabilitarAbonado = comboAbonado_abonados.isEmpty();
    // this.fieldDomicilioAgregar_abonados.setEnabled(condicionHabilitarAbonado);
    // this.comboTipo_abonados.setEnabled(condicionHabilitarAbonado);
    // this.comboMonitoreoBaja_abonados.setEnabled(condicionHabilitarAbonado);
    // this.comboFacturas_abonados.setEnabled(condicionHabilitarAbonado);

  }

  // ESTA FUNCION LA LLAMA EL CONSTRUCTOR DE LA VENTANA Y ES PARA AGREGARLE LOS
  // LISTENER A LOS OBJETOS QUE QUERES
  // NO VAMOS A USAR OTROS QUE NO SEAN KEYLISTENER PARA ENTRADAS DE TEXTO O
  // PROPERTYCHANGE PARA LAS (COMBOBOX)LISTAS
  private void addListeners() {
    btnIniciarJornada_empresa.addActionListener(this);
    btnFinalizarJornada_empresa.addActionListener(this);
    btnActualizarMesFacturacion_empresa.addActionListener(this);
    fieldNombreAgregar_empresa.addKeyListener(this);
    fieldDNIAgregar_empresa.addKeyListener(this);
    comboTipo_empresa.addActionListener(this);
    btnAgregar_empresa.addActionListener(this);

    comboAbonado_abonados.addActionListener(this);
    // fieldDomicilio_abonados.addKeyListener(this); //ni idea
    // fieldNro_abonados.addKeyListener(this);
    comboTipo_abonados.addActionListener(this);
    fieldCamaras_abonados.addKeyListener(this);
    fieldBotones_abonados.addKeyListener(this);
    checkMovil_abonados.addActionListener(this);
    btnAgregarMonitoreo_abonados.addActionListener(this);
    comboBajaMonitoreo_abonados.addActionListener(this);
    btnBajaMonitoreo_abonados.addActionListener(this);
    comboFacturas_abonados.addActionListener(this);
    btnPagarFactura_abonados.addActionListener(this);

    comboAbonado_tecnicos.addActionListener(this);
    comboMonitoreo_tecnicos.addActionListener(this);
    btnSolicitar_tecnicos.addActionListener(this);

    fieldNombreAgregar_tecnicos.addKeyListener(this);
    btnAgregar_tecnicos.addActionListener(this);
    comboTecnicos_tecnicos.addActionListener(this);
    btnDespedir_tecnicos.addActionListener(this);
  }

  private void inicializaEstados() {
    // pestaña empresa
    // this.btnIniciarJornada_empresa.setEnabled(true);
    // this.btnFinalizarJornada_empresa.setEnabled(false);
    // this.btnActualizarMesFacturacion_empresa.setEnabled(false);
    // // faltan los campos de texto
    // this.comboTipo_empresa.setEnabled(false);
    // this.btnAgregar_empresa.setEnabled(false);

    // // pestaña abonados
    // this.comboAbonado_abonados.setEnabled(false);

    // // this.fieldDomicilio_abonados.setEnabled(false);
    // // this.fieldNro_abonados.setEnabled(false);
    // this.comboTipo_abonados.setEnabled(false);
    // this.fieldCamaras_abonados.setEnabled(false);
    // this.fieldBotones_abonados.setEnabled(false);
    // this.checkMovil_abonados.setEnabled(false);
    // this.btnAgregarMonitoreo_abonados.setEnabled(false);

    // this.comboBajaMonitoreo_abonados.setEnabled(false);
    // this.btnBajaMonitoreo_abonados.setEnabled(false);

    // this.comboFacturas_abonados.setEnabled(false);
    // this.btnPagarFactura_abonados.setEnabled(false);

    // // pestaña tecnicos
    // this.comboAbonado_tecnicos.setEnabled(false);
    // this.comboMonitoreo_tecnicos.setEnabled(false);
    // this.btnSolicitar_tecnicos.setEnabled(false);

    // this.btnAgregar_tecnicos.setEnabled(false);// en la vista estan al reves los campos

    // // this.comboTecnicos_tecnicos.setEnabled(false);
    // this.btnDespedir_tecnicos.setEnabled(false);
  }

  private void agregarAcciones() {
    this.btnIniciarJornada_empresa.setActionCommand("iniciarJornada");
    this.btnFinalizarJornada_empresa.setActionCommand("finalizarJornada");
    this.btnActualizarMesFacturacion_empresa.setActionCommand(
        "actualizarMesFacturacion"
      );
    this.btnAgregar_empresa.setActionCommand("agregarAbonado");

    //this.comboAbonado_abonados.setActionCommand("cargaDatosAbonado");
    this.btnAgregarMonitoreo_abonados.setActionCommand("agregarMonitoreo");
    //this.comboBajaMonitoreo_abonados.setActionCommand("habilitarBotonBM"); // nuevo
    this.btnBajaMonitoreo_abonados.setActionCommand("bajaMonitoreo");
    //this.comboFacturas_abonados.setActionCommand("habilitarBotonPF"); // nuevo
    this.btnPagarFactura_abonados.setActionCommand("pagarFactura");

    //this.comboAbonado_tecnicos.setActionCommand("cargaDatosMonitoreos");
    this.comboMonitoreo_tecnicos.setActionCommand("habilitarBotonST");
    this.btnSolicitar_tecnicos.setActionCommand("solicitarTecnico");

    this.btnAgregar_tecnicos.setActionCommand("agregarTecnico");
    this.btnDespedir_tecnicos.setActionCommand("despedirTecnico");
  }

  public void propertyChange(PropertyChangeEvent evt) {}

  @Override
  public void setActionListener(ActionListener actionListener) {
    this.actionListener = actionListener;
  }

  @Override
  public void iniciarJornada(ArrayList<Object> ListaAbonados) { // habilita las opciones al iniciar jornada
    this.btnIniciarJornada_empresa.setEnabled(false);
    this.btnFinalizarJornada_empresa.setEnabled(true);
    this.btnActualizarMesFacturacion_empresa.setEnabled(true);
    this.fieldNombreAgregar_empresa.setEnabled(true);
    this.comboTipo_empresa.setEnabled(true);

    this.comboAbonado_abonados.setEnabled(true);

    this.comboTecnicos_tecnicos.setEnabled(true);
    this.comboAbonado_tecnicos.setEnabled(true);

    updateAbonados_abonados(ListaAbonados);
    updateAbonados_tecnicos(ListaAbonados);

    this.comboTipo_empresa.addItem("PersonaJuridica");
    this.comboTipo_empresa.addItem("PersonaFisica");

    this.comboTipo_abonados.addItem("Comercio");
    this.comboTipo_abonados.addItem("Vivienda");

    this.comboPromo_abonados.addItem("PromoDorada");
    this.comboPromo_abonados.addItem("PromoPlatino");
    this.comboPromo_abonados.addItem("Ninguna");
  }

  @Override
  public void finalizarJornada() {
    inicializaEstados();
  }

  @Override
  public String getTipoAbonado() {
    return this.comboTipo_empresa.getSelectedItem().toString();
  }

  @Override
  public String getNombreAbonado() {
    return this.fieldNombreAgregar_empresa.getText();
  }

  @Override
  public String getDNI_empresa() {
    return this.fieldDNIAgregar_empresa.getText();
  }

  @Override
  public void updateAbonados_tecnicos(ArrayList<Object> ListaAbonados) {
    // Limpiamos el JComboBox antes de agregar los nuevos elementos
    // this.comboAbonado_tecnicos.removeAllItems(); // Actualizamos tambien en el
    // otro combo para tenerlos siempre
    // actualizaados
    for (Object abonado : ListaAbonados) {
      // Agregamos cada abonado a la lista desplegable
      this.comboAbonado_tecnicos.addItem(abonado);
    }
  }

  @Override
  public void updateAbonados_abonados(ArrayList<Object> ListaAbonados) {
    //this.comboAbonado_abonados.removeAllItems(); // Limpiamos el JComboBox antes
    // de agregar los nuevos elementos
    // Actualizamos tambien en el otro combo para tenerlos siempre
    // actualizaados
    for (Object abonado : ListaAbonados) {
      this.comboAbonado_abonados.addItem(abonado); // Agregamos cada abonado a la lista desplegable
    }
  }

  @Override
  public String getDNI_abonados() {
    return this.comboAbonado_abonados.getSelectedItem().toString();
  }

  @Override
  public String getCalle() {
    return this.fieldDomicilio_abonados.getText();
  }

  @Override
  public int getNro() {
    return Integer.parseInt(this.fieldNro_abonados.getText());
  }

  @Override
  public int getCamaras() {
    return Integer.parseInt(this.fieldCamaras_abonados.getText());
  }

  @Override
  public int getBotones() {
    return Integer.parseInt(this.fieldBotones_abonados.getText());
  }

  @Override
  public boolean getMovilAcompaniamiento() {
    return this.checkMovil_abonados.isSelected();
  }

  @Override
  public String getTipoServicio() {
    return this.comboTipo_abonados.getSelectedItem().toString();
  }

  @Override
  public Object getMonitoreo_abonados() {
    return this.comboBajaMonitoreo_abonados.getSelectedItem();
  }

  @Override
  public String getNombreTecnico() {
    return this.fieldNombreAgregar_tecnicos.getText();
  }

  @Override
  public Object getAbonado_abonados() {
    return this.comboAbonado_abonados.getSelectedItem();
  }

  @Override
  public Object getFactura_abonados() {
    return this.comboFacturas_abonados.getSelectedItem();
  }

  @Override
  public void setComboMonitoreo_abonados(ArrayList<Object> arrayList) {
    this.comboBajaMonitoreo_abonados.removeAllItems();
    for (Object item : arrayList) {
      this.comboBajaMonitoreo_abonados.addItem(item);
    }
  }

  @Override
  public void setComboFacturas_abonados(ArrayList<Object> arrayList) {
    this.comboFacturas_abonados.removeAllItems();
    for (Object item : arrayList) {
      this.comboFacturas_abonados.addItem(item);
    }
  }

  @Override
  public void setComboMonitoreo_tecnicos(ArrayList<Object> arrayList) {
    this.comboMonitoreo_tecnicos.removeAllItems();
    for (Object item : arrayList) {
      this.comboMonitoreo_tecnicos.addItem(item);
    }
  }

  @Override
  public void setComboTecnicos_tecnicos(ArrayList<Object> arrayList) {
    this.comboFacturas_abonados.removeAllItems();
    for (Object item : arrayList) {
      this.comboTecnicos_tecnicos.addItem(item);
    }
  }

  @Override
  public Object getTecnico_tecnicos() {
    return this.comboDespedir_tecnicos.getSelectedItem();
  }

  @Override
  public Object getMonitoreo_tecnicos() {
    return this.comboMonitoreo_tecnicos.getSelectedItem();
  }

  @Override
  public Object getAbonado_tecnicos() {
    return this.comboAbonado_tecnicos.getSelectedItem();
  }

  @Override
  public void actualizarMes() {
    throw new UnsupportedOperationException(
      "Unimplemented method 'actualizarMes'"
    );
  }

  @Override
  public void setLogsEmpresa(String string) {
    String log = logs_empresa.getText() + '\n' + string;
    this.logs_empresa.setText(log);
  }

  @Override
  public void setLogsAbonado(String string) {
    String log = logs_abonados.getText() + '\n' + string;
    this.logs_abonados.setText(log);
  }

  @Override
  public void setLogsTecnicos(String string) {
    String log = logs_tecnico.getText() + '\n' + string;
    this.logs_tecnico.setText(log);
  }

  @Override
  public String getPromo() {
    return this.comboPromo_abonados.getSelectedItem().toString();
  }

  public void actualizarDatos() {
    // ActionEvent evento = new ActionEvent(
    //   this,
    //   ActionEvent.ACTION_PERFORMED,
    //   "cargaDatosMonitoreos"
    // );
    // ActionEvent evento1 = new ActionEvent(
    //   this,
    //   ActionEvent.ACTION_PERFORMED,
    //   "cargaDatosAbonado"
    // );
    // ActionEvent evento2 = new ActionEvent(
    //   this,
    //   ActionEvent.ACTION_PERFORMED,
    //   "cargaDatosTecnicos"
    // );
    // ActionEvent evento3 = new ActionEvent(
    //   this,
    //   ActionEvent.ACTION_PERFORMED,
    //   "cargaDatosMonitoreos" //de tecnicos
    // );
    // actionPerformed(evento);
    // actionPerformed(evento1);
    // actionPerformed(evento2);
    // actionPerformed(evento3);
    //ActionEvent evento2 = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cargaDatosAbonado");
  }
}
