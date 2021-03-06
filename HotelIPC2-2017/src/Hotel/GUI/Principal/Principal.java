package Hotel.GUI.Principal;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Alimento;
import Hotel.BackEnd.Hotel.Habitacion;
import Hotel.BackEnd.Manejador.AlimentoM;
import Hotel.BackEnd.Manejador.HabitacionM;
import Hotel.BackEnd.Manejador.ReservarHabitacionM;
import Hotel.GUI.Gerente.AlimentoFrame;
import Hotel.GUI.Gerente.EditarUsuarios;
import Hotel.GUI.Gerente.ModificarPrecioHab;
import Hotel.GUI.Recepcionista.CheckIn.CheckInConReservacion;
import Hotel.GUI.Recepcionista.CheckIn.SinReservacion;
import Hotel.GUI.Recepcionista.CheckOut.CheckOut;
import Hotel.GUI.Recepcionista.ModificarReservacion;
import Hotel.GUI.Recepcionista.NuevaReservacion;
import Hotel.GUI.Reportes.ListadoIngresosHotel;
import Hotel.GUI.Reportes.TotalIngresosHotel;
import Hotel.GUI.Restaurante.ServicioHabitacion;
import RUN.DefaultValues;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author angelrg
 */
public class Principal extends javax.swing.JFrame {

    private List<Habitacion> listadoHabitacion1;
    private List<Habitacion> listadoHabitacion2;
    private List<Habitacion> listadoHabitacion3;
    private List<Habitacion> listadoHabitacionAux;
    private ObservableList<Habitacion> listaHabitacionObservable1;
    private ObservableList<Habitacion> listaHabitacionObservable2;
    private ObservableList<Habitacion> listaHabitacionObservable3;
    private List<Alimento> listaAlimento;
    private ObservableList<Alimento> listaAlimentoObservable;

    private HabitacionM manejadorHabitacion;
    private AlimentoM manejadorAlimento;
    private ReservarHabitacionM manejadorReservacion;

    private ModificarReservacion modificarReservacion;
    private NuevaReservacion nuevaReservacion;
    private CheckInConReservacion checkInConReservacion;
    private SinReservacion checkInSinReservacion;
    private CheckOut checkOut;
    private ServicioHabitacion servicionHabitacion;
    private AlimentoFrame alimentoFrame;
    private EditarUsuarios editarUsuario;
    private ModificarPrecioHab modificarPrecioHab;
    private TotalIngresosHotel totalIngresosHotel;
    private ListadoIngresosHotel listadoIngesos;

    public Principal(Connection conexion) {
        this.manejadorReservacion = new ReservarHabitacionM(conexion);
        this.manejadorAlimento = new AlimentoM(conexion);
        this.manejadorHabitacion = new HabitacionM(conexion);
        listadoHabitacion1 = new ArrayList<>();
        listadoHabitacion2 = new ArrayList<>();
        listadoHabitacion3 = new ArrayList<>();
        listadoHabitacionAux = new ArrayList<>();
        listaAlimento = new ArrayList<>();
        listaHabitacionObservable1 = ObservableCollections.observableList(listadoHabitacion1);
        listaHabitacionObservable2 = ObservableCollections.observableList(listadoHabitacion2);
        listaHabitacionObservable3 = ObservableCollections.observableList(listadoHabitacion3);
        listaAlimentoObservable = ObservableCollections.observableList(listaAlimento);

        modificarReservacion = new ModificarReservacion(conexion);
        nuevaReservacion = new NuevaReservacion(conexion);
        checkInConReservacion = new CheckInConReservacion(conexion);
        checkInSinReservacion = new SinReservacion(conexion);
        checkOut = new CheckOut(conexion);
        servicionHabitacion = new ServicioHabitacion(conexion);
        alimentoFrame = new AlimentoFrame(conexion);
        editarUsuario = new EditarUsuarios(conexion);
        modificarPrecioHab = new ModificarPrecioHab(conexion);
        totalIngresosHotel = new TotalIngresosHotel(conexion);
        listadoIngesos = new ListadoIngresosHotel(conexion);

        initComponents();
        this.DesktopPane.add(modificarReservacion);
        this.DesktopPane.add(nuevaReservacion);
        this.DesktopPane.add(checkInConReservacion);
        this.DesktopPane.add(checkInSinReservacion);
        this.DesktopPane.add(checkOut);
        this.DesktopPane.add(servicionHabitacion);
        this.DesktopPane.add(alimentoFrame);
        this.DesktopPane.add(editarUsuario);
        this.DesktopPane.add(modificarPrecioHab);
        this.DesktopPane.add(totalIngresosHotel);
        this.DesktopPane.add(listadoIngesos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        actualizarButton = new javax.swing.JButton();
        DesktopPane = new javax.swing.JDesktopPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        reservacionMenu = new javax.swing.JMenu();
        NewReserMenuItem = new javax.swing.JMenuItem();
        nuevoReserMenuItem = new javax.swing.JMenuItem();
        CheckInMenu = new javax.swing.JMenu();
        conReservacionMenuItem = new javax.swing.JMenuItem();
        sinReservacionMenuItem = new javax.swing.JMenuItem();
        checkOutMenu = new javax.swing.JMenu();
        pagarMenuItem = new javax.swing.JMenuItem();
        RestauranteMenu = new javax.swing.JMenu();
        servicioHabMenuItem = new javax.swing.JMenuItem();
        gerenciaMenu = new javax.swing.JMenu();
        modificarPreciocsMenu = new javax.swing.JMenu();
        alimentosMenuItem = new javax.swing.JMenuItem();
        modHabitacionesMenuItem = new javax.swing.JMenuItem();
        adminUsuariosMenuItem = new javax.swing.JMenuItem();
        informacionMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        totalIngresosMenuItem = new javax.swing.JMenuItem();
        listadoIngresosMenuItem = new javax.swing.JMenuItem();
        acercaDeMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel \"El Buen Descanso\"");

        jLabel1.setFont(new java.awt.Font("Noto Sans UI", 0, 18)); // NOI18N
        jLabel1.setText("INFORMACION");

        jLabel3.setText("Precios de las Habitaciones");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaHabitacionObservable1}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable3);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreTipo}"));
        columnBinding.setColumnName("Nombre Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jTable3);

        jLabel4.setText("Habitacion Libres Hoy");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaHabitacionObservable2}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estadoTipo}"));
        columnBinding.setColumnName("Estado Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Menu Restaurante");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaAlimentoObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTable4);

        actualizarButton.setText("Actualizar");
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaHabitacionObservable3}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable5);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Veces ocupada");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane5.setViewportView(jTable5);

        jLabel2.setText("Habitacion Popular");

        reservacionMenu.setText("Reservacion ");

        NewReserMenuItem.setText("Nueva Reservacion");
        NewReserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewReserMenuItemActionPerformed(evt);
            }
        });
        reservacionMenu.add(NewReserMenuItem);

        nuevoReserMenuItem.setText("Modificar / Eliminar");
        nuevoReserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoReserMenuItemActionPerformed(evt);
            }
        });
        reservacionMenu.add(nuevoReserMenuItem);

        jMenuBar1.add(reservacionMenu);

        CheckInMenu.setText("Check-In ");

        conReservacionMenuItem.setText("Con Resercacion");
        conReservacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conReservacionMenuItemActionPerformed(evt);
            }
        });
        CheckInMenu.add(conReservacionMenuItem);

        sinReservacionMenuItem.setText("Sin Reservacion");
        sinReservacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinReservacionMenuItemActionPerformed(evt);
            }
        });
        CheckInMenu.add(sinReservacionMenuItem);

        jMenuBar1.add(CheckInMenu);

        checkOutMenu.setText(" Check-Out ");

        pagarMenuItem.setText("Pagar");
        pagarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarMenuItemActionPerformed(evt);
            }
        });
        checkOutMenu.add(pagarMenuItem);

        jMenuBar1.add(checkOutMenu);

        RestauranteMenu.setText("Restaurante");

        servicioHabMenuItem.setText("Servicio a la Habitacion");
        servicioHabMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicioHabMenuItemActionPerformed(evt);
            }
        });
        RestauranteMenu.add(servicioHabMenuItem);

        jMenuBar1.add(RestauranteMenu);

        gerenciaMenu.setText("Gerencia");

        modificarPreciocsMenu.setText("Modificar precios");

        alimentosMenuItem.setText("Alimentos");
        alimentosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alimentosMenuItemActionPerformed(evt);
            }
        });
        modificarPreciocsMenu.add(alimentosMenuItem);

        modHabitacionesMenuItem.setText("Habitaciones");
        modHabitacionesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modHabitacionesMenuItemActionPerformed(evt);
            }
        });
        modificarPreciocsMenu.add(modHabitacionesMenuItem);

        gerenciaMenu.add(modificarPreciocsMenu);

        adminUsuariosMenuItem.setText("Administrar Usuarios");
        adminUsuariosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUsuariosMenuItemActionPerformed(evt);
            }
        });
        gerenciaMenu.add(adminUsuariosMenuItem);

        jMenuBar1.add(gerenciaMenu);

        informacionMenu.setText(" Informacion ");

        jMenu1.setText("Reportes");

        totalIngresosMenuItem.setText("Total Ingresos");
        totalIngresosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalIngresosMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(totalIngresosMenuItem);

        listadoIngresosMenuItem.setText("Listado Ingresos");
        listadoIngresosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoIngresosMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(listadoIngresosMenuItem);

        informacionMenu.add(jMenu1);

        acercaDeMenuItem.setText("Acerca de ");
        acercaDeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeMenuItemActionPerformed(evt);
            }
        });
        informacionMenu.add(acercaDeMenuItem);

        jMenuBar1.add(informacionMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(actualizarButton)
                                .addGap(97, 97, 97))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(82, 82, 82))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DesktopPane))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizarButton)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewReserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewReserMenuItemActionPerformed
        nuevaReservacion.setVisible(true);
    }//GEN-LAST:event_NewReserMenuItemActionPerformed

    private void nuevoReserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoReserMenuItemActionPerformed
        modificarReservacion.iniciar();
        modificarReservacion.setVisible(true);
    }//GEN-LAST:event_nuevoReserMenuItemActionPerformed

    private void conReservacionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conReservacionMenuItemActionPerformed
        checkInConReservacion.setVisible(true);
    }//GEN-LAST:event_conReservacionMenuItemActionPerformed

    private void sinReservacionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinReservacionMenuItemActionPerformed
        checkInSinReservacion.setVisible(true);
    }//GEN-LAST:event_sinReservacionMenuItemActionPerformed

    private void pagarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarMenuItemActionPerformed
        checkOut.setVisible(true);
    }//GEN-LAST:event_pagarMenuItemActionPerformed

    private void servicioHabMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicioHabMenuItemActionPerformed
        servicionHabitacion.setVisible(true);
    }//GEN-LAST:event_servicioHabMenuItemActionPerformed

    private void alimentosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimentosMenuItemActionPerformed
        alimentoFrame.setVisible(true);
    }//GEN-LAST:event_alimentosMenuItemActionPerformed

    private void modHabitacionesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modHabitacionesMenuItemActionPerformed
        modificarPrecioHab.setVisible(true);
    }//GEN-LAST:event_modHabitacionesMenuItemActionPerformed

    private void adminUsuariosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUsuariosMenuItemActionPerformed
        editarUsuario.setVisible(true);
    }//GEN-LAST:event_adminUsuariosMenuItemActionPerformed

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        try {
            actualizarBusquedaOservableHab1(manejadorHabitacion.busquedaPrecioHabitacion());
            actualizarBusquedaOservableHab2(manejadorHabitacion.habitacionesDisponiblesHoy());
            actualizarBusquedaObservableAlimentos(manejadorAlimento.busqueda("", DefaultValues.DISPONIBLE_SI));
            listadoHabitacionAux.clear();
            listadoHabitacionAux.add(manejadorHabitacion.habitacionPopular());
            actualizarBusquedaOservableHab3(listadoHabitacionAux);
        } catch (InputsVaciosException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void acercaDeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Desarrollado por: \nAngel O. Racancoj G. \nCarne: 201631547  \n2do Semestre 2017 \nVersion 1.0 (Beta)", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_acercaDeMenuItemActionPerformed

    private void totalIngresosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalIngresosMenuItemActionPerformed
        totalIngresosHotel.setVisible(true);
    }//GEN-LAST:event_totalIngresosMenuItemActionPerformed

    private void listadoIngresosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoIngresosMenuItemActionPerformed
        listadoIngesos.setVisible(true);
    }//GEN-LAST:event_listadoIngresosMenuItemActionPerformed

    public void iniciar(String rango) {
        switch (rango) {
            case DefaultValues.CARGO_RECEPCION_ID:
                validarBotones(true, true, true, false, false);
                break;
            case DefaultValues.CARGO_RESTAURANTE_ID:
                validarBotones(false, false, false, true, false);
                break;
            case DefaultValues.CARGO_GERENTE_ID:
                validarBotones(false, false, false, false, true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public void actualizarBusquedaOservableHab1(List<Habitacion> listaHabitaciones) {
        this.listaHabitacionObservable1.clear();
        this.listaHabitacionObservable1.addAll(listaHabitaciones);
    }

    public void actualizarBusquedaOservableHab2(List<Habitacion> listaHabitaciones) {
        this.listaHabitacionObservable2.clear();
        this.listaHabitacionObservable2.addAll(listaHabitaciones);
    }
    public void actualizarBusquedaOservableHab3(List<Habitacion> listaHabitaciones) {
        this.listaHabitacionObservable3.clear();
        this.listaHabitacionObservable3.addAll(listaHabitaciones);
    }

    public void actualizarBusquedaObservableAlimentos(List<Alimento> listaAli) {
        this.listaAlimentoObservable.clear();
        this.listaAlimentoObservable.addAll(listaAli);
    }

    public ObservableList<Habitacion> getListaHabitacionObservable1() {
        return listaHabitacionObservable1;
    }

    public void setListaHabitacionObservable1(ObservableList<Habitacion> listaHabitacionObservable1) {
        this.listaHabitacionObservable1 = listaHabitacionObservable1;
    }

    public ObservableList<Habitacion> getListaHabitacionObservable2() {
        return listaHabitacionObservable2;
    }

    public void setListaHabitacionObservable2(ObservableList<Habitacion> listaHabitacionObservable2) {
        this.listaHabitacionObservable2 = listaHabitacionObservable2;
    }

    public ObservableList<Alimento> getListaAlimentoObservable() {
        return listaAlimentoObservable;
    }

    public void setListaAlimentoObservable(ObservableList<Alimento> listaAlimentoObservable) {
        this.listaAlimentoObservable = listaAlimentoObservable;
    }

    public ObservableList<Habitacion> getListaHabitacionObservable3() {
        return listaHabitacionObservable3;
    }

    public void setListaHabitacionObservable3(ObservableList<Habitacion> listaHabitacionObservable3) {
        this.listaHabitacionObservable3 = listaHabitacionObservable3;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CheckInMenu;
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuItem NewReserMenuItem;
    private javax.swing.JMenu RestauranteMenu;
    private javax.swing.JMenuItem acercaDeMenuItem;
    private javax.swing.JButton actualizarButton;
    private javax.swing.JMenuItem adminUsuariosMenuItem;
    private javax.swing.JMenuItem alimentosMenuItem;
    private javax.swing.JMenu checkOutMenu;
    private javax.swing.JMenuItem conReservacionMenuItem;
    private javax.swing.JMenu gerenciaMenu;
    private javax.swing.JMenu informacionMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JMenuItem listadoIngresosMenuItem;
    private javax.swing.JMenuItem modHabitacionesMenuItem;
    private javax.swing.JMenu modificarPreciocsMenu;
    private javax.swing.JMenuItem nuevoReserMenuItem;
    private javax.swing.JMenuItem pagarMenuItem;
    private javax.swing.JMenu reservacionMenu;
    private javax.swing.JMenuItem servicioHabMenuItem;
    private javax.swing.JMenuItem sinReservacionMenuItem;
    private javax.swing.JMenuItem totalIngresosMenuItem;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void validarBotones(boolean CheckIn, boolean checkOut, boolean reservacion, boolean restaurante, boolean gerencia) {
        CheckInMenu.setEnabled(CheckIn);
        checkOutMenu.setEnabled(checkOut);
        reservacionMenu.setEnabled(reservacion);
        RestauranteMenu.setEnabled(restaurante);
        gerenciaMenu.setEnabled(gerencia);
    }
}
