/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Datos.vHabitacion;
import Datos.vReserva;
import Logica.Fhabitacion;
import Logica.Freserva;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafae
 */
public class frmReserva_m extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmReserva_m
     */
    public frmReserva_m() {
        initComponents();
        mostrar("");
        inHabilitar();
    }
    private String accion = "Guardar";
    public static int idusuario;

    //-------------------      METODO PARA COULTAR COLUMNAS    --------------------
    void ocultar_columnas() {
        tablaListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablaListado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(3).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablaListado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(5).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    //----------------------   METODOS PARA INHABILITAR LAS CAJAS DE TEXTO  ---------------------
    void inHabilitar() {
        txtIdReserva.setVisible(false);
        txtIdhabitacion.setVisible(false);
        txtIdcliente.setVisible(false);
        txtIdtrabajador.setVisible(false);

        txtnumero.setEditable(false);
        txtcliente.setEnabled(false);
        txttrabajador.setEnabled(false);
        cbotipo_reserva.setEnabled(false);

        dcfecha_reserva.setEnabled(false);
        dcfecha_ingresa.setEnabled(false);
        dcfecha_salida.setEnabled(false);

        txtcosto_alojamiento.setEnabled(false);
        cboestado_reserva.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar_habitacion.setEnabled(false);
        btnBuscar_cliente.setEnabled(false);

        txtIdReserva.setEnabled(false);
        txtIdcliente.setText("");
        txtnumero.setText("");
        txtcliente.setText("");
        txtcosto_alojamiento.setText("");
        txtIdhabitacion.setText("");

    }

    //---------------------     METODOS PARA HABILITAR LAS CAJAS DE TEXTO  ------------
    void Habilitar() {
        txtIdReserva.setVisible(false);
        txtIdhabitacion.setVisible(false);
        txtIdcliente.setVisible(false);
        txtIdtrabajador.setVisible(false);

        txtnumero.setEditable(false);
        txtcliente.setEnabled(false);
        txttrabajador.setEnabled(false);

        cbotipo_reserva.setEnabled(true);

        dcfecha_reserva.setEnabled(true);
        dcfecha_ingresa.setEnabled(true);
        dcfecha_salida.setEnabled(true);

        txtcosto_alojamiento.setEnabled(true);
        cboestado_reserva.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnBuscar_habitacion.setEnabled(true);
        btnBuscar_cliente.setEnabled(true);

        txtIdReserva.setEnabled(false);
        txtIdcliente.setText("");
        txtnumero.setText("");
        txtcliente.setText("");
        txtcosto_alojamiento.setText("");
        txtIdhabitacion.setText("");

    }

    //---------------------       METODO DE MOSTRAR DATOS -----------------------------
    void mostrar(String buscar) {

        try {

            DefaultTableModel modelo;
            Freserva func = new Freserva();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);
            ocultar_columnas();
            lblTotalRegistros.setText("Total Registros " + Integer.toString(func.totalRegistro));

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        btnVer_consumo = new javax.swing.JButton();
        btnRealizar_pago = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jpReserva = new javax.swing.JPanel();
        txtIdReserva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdhabitacion = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdtrabajador = new javax.swing.JTextField();
        txttrabajador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbotipo_reserva = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dcfecha_reserva = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dcfecha_ingresa = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        dcfecha_salida = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtcosto_alojamiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboestado_reserva = new javax.swing.JComboBox<>();
        btnBuscar_habitacion = new javax.swing.JButton();
        btnBuscar_cliente = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIdcliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado De Reservas"));

        jLabel11.setText("Buscar:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.gif"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaListado);

        lblTotalRegistros.setText("Registros Totales: ");

        btnVer_consumo.setText("Consumos");
        btnVer_consumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVer_consumoActionPerformed(evt);
            }
        });

        btnRealizar_pago.setText("Realizar Pagos");
        btnRealizar_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizar_pagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(420, 420, 420))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVer_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(btnRealizar_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVer_consumo)
                    .addComponent(btnRealizar_pago))
                .addGap(41, 41, 41)
                .addComponent(lblTotalRegistros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Reserva");

        jpReserva.setBackground(new java.awt.Color(204, 255, 255));
        jpReserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro De Reservas"));

        jLabel2.setText("Habitacion:");

        txtIdhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdhabitacionActionPerformed(evt);
            }
        });

        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        jLabel4.setText("Trabajador:");

        jLabel5.setText("Tipo Reserva:");

        cbotipo_reserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Reserva", "Alquiler" }));

        jLabel6.setText("Fecha De Reserva:");

        jLabel7.setText("Fecha De Ingreso:");

        jLabel8.setText("Fecha De Salida:");

        jLabel9.setText("Costo:");

        jLabel10.setText("Estado De Reserva:");

        cboestado_reserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Alquiler", "Pagada", "Anulada" }));

        btnBuscar_habitacion.setText("...");
        btnBuscar_habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_habitacionActionPerformed(evt);
            }
        });

        btnBuscar_cliente.setText("...");
        btnBuscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_clienteActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.GIF"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtIdcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdclienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpReservaLayout = new javax.swing.GroupLayout(jpReserva);
        jpReserva.setLayout(jpReservaLayout);
        jpReservaLayout.setHorizontalGroup(
            jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpReservaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpReservaLayout.createSequentialGroup()
                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(426, 434, Short.MAX_VALUE))
                    .addGroup(jpReservaLayout.createSequentialGroup()
                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpReservaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(dcfecha_ingresa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpReservaLayout.createSequentialGroup()
                                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbotipo_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcfecha_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpReservaLayout.createSequentialGroup()
                                        .addComponent(txtIdtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txttrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpReservaLayout.createSequentialGroup()
                                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIdcliente)
                                            .addComponent(txtIdhabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBuscar_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jpReservaLayout.createSequentialGroup()
                                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(27, 27, 27)
                                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dcfecha_salida, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(txtcosto_alojamiento)))
                            .addGroup(jpReservaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboestado_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpReservaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnNuevo)
                .addGap(84, 84, 84)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(81, 81, 81))
        );
        jpReservaLayout.setVerticalGroup(
            jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpReservaLayout.createSequentialGroup()
                .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpReservaLayout.createSequentialGroup()
                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar_habitacion))
                        .addGap(18, 18, 18)
                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar_cliente)
                            .addComponent(txtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbotipo_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dcfecha_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dcfecha_ingresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(dcfecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtcosto_alojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboestado_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jpReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!txtIdReserva.getText().equals("")) {

            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar la Reserva ", "Confirmar", 2);

            if (confirmacion == 0) {
                Freserva func = new Freserva();
                vReserva dts = new vReserva();

                dts.setIdreserva(Integer.parseInt(txtIdReserva.getText()));
                func.eliminar(dts);
                mostrar("");
                inHabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        Habilitar();
        btnGuardar.setText("Guardar");
        accion = "Guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtIdhabitacion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes Seleccionar Una Habitacion");
            txtIdhabitacion.requestFocus();
        }

        if (txtIdcliente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes Seleccionar Un Cliente");
            txtIdcliente.requestFocus();
        }

        if (txtcosto_alojamiento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes Ingresar un precio de alojamiento");
            txtcosto_alojamiento.requestFocus();
        }

        vReserva dts = new vReserva();
        Freserva func = new Freserva();

        dts.setIdhabitacion(Integer.parseInt(txtIdhabitacion.getText()));
        dts.setIdcliente(Integer.parseInt(txtIdcliente.getText()));
        dts.setIdtrabajador(idusuario);

        int seleccionado = cbotipo_reserva.getSelectedIndex();
        dts.setTipo_reserva((String) cbotipo_reserva.getItemAt(seleccionado));

        Calendar cal;
        int d, m, a;
        cal = dcfecha_reserva.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_reserva(new Date(a, m, d));

        cal = dcfecha_ingresa.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_ingresa(new Date(a, m, d));

        cal = dcfecha_salida.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_salida(new Date(a, m, d));

        dts.setCosto_alojamiento(Double.parseDouble(txtcosto_alojamiento.getText()));

        seleccionado = cboestado_reserva.getSelectedIndex();
        dts.setEstado((String) cboestado_reserva.getItemAt(seleccionado));

        if (accion.equals("Guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La Reserva Fue Registrada Satisfactoriamente");
                mostrar("");
                inHabilitar();

                //-------------OCUPAMOS LA ABITACION ALQUILÑADA
                Fhabitacion func3 = new Fhabitacion();
                vHabitacion dts3 = new vHabitacion();

                dts3.setIdhabitacion(Integer.parseInt(txtIdhabitacion.getText()));
                func3.ocupar(dts3);
                
            }
        } else if (accion.equals("Editar")) {
            dts.setIdreserva(Integer.parseInt(txtIdReserva.getText()));
            dts.setIdtrabajador(Integer.parseInt(txtIdtrabajador.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La Reserva Fue Editada Satisfactoriamente");
                mostrar("");
                inHabilitar();

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Editar");
        Habilitar();
        btnEliminar.setEnabled(true);
        accion = "Editar";

        int fila = tablaListado.rowAtPoint(evt.getPoint());

        txtIdReserva.setText(tablaListado.getValueAt(fila, 0).toString());
        txtIdhabitacion.setText(tablaListado.getValueAt(fila, 1).toString());
        txtnumero.setText(tablaListado.getValueAt(fila, 2).toString());
        txtIdcliente.setText(tablaListado.getValueAt(fila, 3).toString());
        txtcliente.setText(tablaListado.getValueAt(fila, 4).toString());
        txtIdtrabajador.setText(tablaListado.getValueAt(fila, 5).toString());
        txttrabajador.setText(tablaListado.getValueAt(fila, 6).toString());
        cbotipo_reserva.setSelectedItem(tablaListado.getValueAt(fila, 7).toString());
        dcfecha_reserva.setDate(Date.valueOf(tablaListado.getValueAt(fila, 8).toString()));
        dcfecha_ingresa.setDate(Date.valueOf(tablaListado.getValueAt(fila, 9).toString()));
        dcfecha_salida.setDate(Date.valueOf(tablaListado.getValueAt(fila, 10).toString()));
        txtcosto_alojamiento.setText(tablaListado.getValueAt(fila, 11).toString());
        cboestado_reserva.setSelectedItem(tablaListado.getValueAt(fila, 12).toString());

    }//GEN-LAST:event_tablaListadoMouseClicked

    private void txtIdclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdclienteActionPerformed

    private void btnBuscar_habitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_habitacionActionPerformed
        // TODO add your handling code here:
        
        frmVista_habitacion form = new frmVista_habitacion();
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_btnBuscar_habitacionActionPerformed

    private void btnBuscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_clienteActionPerformed
        // TODO add your handling code here:
        frmVista_cliente form = new frmVista_cliente();
        form.toFront();
        form.setVisible(true);


    }//GEN-LAST:event_btnBuscar_clienteActionPerformed

    private void btnVer_consumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVer_consumoActionPerformed
        // TODO add your handling code here:
        int fila = tablaListado.getSelectedRow();
        frmConsumo.idreserva = tablaListado.getValueAt(fila, 0).toString();
        frmConsumo.cliente = tablaListado.getValueAt(fila, 4).toString();

        frmConsumo form = new frmConsumo();
        frmInicio.escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnVer_consumoActionPerformed

    private void btnRealizar_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizar_pagoActionPerformed

        int fila = tablaListado.getSelectedRow();
        frmPago.idreserva = tablaListado.getValueAt(fila, 0).toString();
        frmPago.cliente = tablaListado.getValueAt(fila, 4).toString();
        frmPago.totalreserva = Double.parseDouble(tablaListado.getValueAt(fila, 11).toString());

        frmPago.idhabitacion = tablaListado.getValueAt(fila, 1).toString();
        frmPago.habitacion = tablaListado.getValueAt(fila, 2).toString();
        
        // instacia de frmPago media f
        frmPago form = new frmPago();
        
        //muestro mi frmPago en el escritorio 
        
        frmInicio.escritorio.add(form);
        form.toFront(); 
        form.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizar_pagoActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtIdhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdhabitacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmReserva_m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReserva_m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReserva_m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReserva_m.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReserva_m().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar_cliente;
    private javax.swing.JButton btnBuscar_habitacion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRealizar_pago;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVer_consumo;
    private javax.swing.JComboBox<String> cboestado_reserva;
    private javax.swing.JComboBox<String> cbotipo_reserva;
    private com.toedter.calendar.JDateChooser dcfecha_ingresa;
    private com.toedter.calendar.JDateChooser dcfecha_reserva;
    private com.toedter.calendar.JDateChooser dcfecha_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpReserva;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdReserva;
    public static javax.swing.JTextField txtIdcliente;
    public static javax.swing.JTextField txtIdhabitacion;
    public static javax.swing.JTextField txtIdtrabajador;
    public static javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtcosto_alojamiento;
    public static javax.swing.JTextField txtnumero;
    public static javax.swing.JTextField txttrabajador;
    // End of variables declaration//GEN-END:variables
}
