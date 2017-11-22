package Hotel.GUI.Recepcionista.CheckOut;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Consumo;
import Hotel.BackEnd.Hotel.Reservacion;
import Hotel.BackEnd.Manejador.ConsumoM;
import Hotel.BackEnd.Manejador.ReservarHabitacionM;
import RUN.DefaultValues;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author angelrg
 */
public class CheckOut extends javax.swing.JInternalFrame {

    private List<Reservacion> listaReservaciones;
    private List<Consumo> listaConsumo;
    private ObservableList<Reservacion> listaObservableReservacion;

    private Reservacion reservacionSeleccionada;

    private ReservarHabitacionM manejadorReservacion;
    private ConsumoM manejadorConsumo;
    private CheckOutConsumo consumo;

    public CheckOut(Connection conexion) {
        listaReservaciones = new ArrayList<>();
        listaConsumo = new ArrayList<>();
        listaObservableReservacion = ObservableCollections.observableList(listaReservaciones);
        reservacionSeleccionada = new Reservacion();
        manejadorReservacion = new ReservarHabitacionM(conexion);
        manejadorConsumo = new ConsumoM(conexion);
        consumo = new CheckOutConsumo(conexion);
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        idClienteTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        cargarConsumoButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        limpiarjButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Check-Out");

        jLabel1.setText("Ingrese el ID del cliente para buscar el consumo:");

        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaObservableReservacion}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, clientesTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${IDCliente}"));
        columnBinding.setColumnName("IDCliente");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaInicial}"));
        columnBinding.setColumnName("Fecha Inicial");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaFinal}"));
        columnBinding.setColumnName("Fecha Final");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noHabitacion}"));
        columnBinding.setColumnName("No Habitacion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pagoHabitacion}"));
        columnBinding.setColumnName("Pago Habitacion");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${reservacionSeleccionada}"), clientesTable, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(clientesTable);

        cargarConsumoButton.setText("Cargar Consumo");
        cargarConsumoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarConsumoButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        limpiarjButton.setText("Limpiar");
        limpiarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarjButtonActionPerformed(evt);
            }
        });

        checkOutButton.setText("CheckOut");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Sans UI", 0, 12)); // NOI18N
        jLabel2.setText("Elegir la reservacion, dependiendo si el cliente ha consumido alimentos en el hotel se habilitara el boton \"CheckOut\"");

        jLabel3.setFont(new java.awt.Font("Noto Sans UI", 0, 12)); // NOI18N
        jLabel3.setText("de no existir consumo y \"Cargar Consumo\" para desplegar los pedidos en una nueva ventana.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(limpiarjButton)
                        .addGap(147, 147, 147)
                        .addComponent(checkOutButton)
                        .addGap(18, 18, 18)
                        .addComponent(cargarConsumoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargarConsumoButton)
                    .addComponent(cancelarButton)
                    .addComponent(limpiarjButton)
                    .addComponent(checkOutButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        try {
            if (idClienteTextField.getText().replace(" ", "").isEmpty()) {
                actualizarBusquedaObservable(manejadorReservacion.busquedaPorIDClienteEstadoYFechas("", DefaultValues.HAB_OCUPADA_COD, "", ""));
            } else {
                actualizarBusquedaObservable(manejadorReservacion.busquedaPorIDClienteEstadoYFechas(idClienteTextField.getText(), DefaultValues.HAB_OCUPADA_COD, "", ""));
            }
        } catch (InputsVaciosException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void cargarConsumoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarConsumoButtonActionPerformed
        if (reservacionSeleccionada != null) {
            consumo.continuarCheckOut(reservacionSeleccionada);
            consumo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una reservacion de la Lista", "Error", JOptionPane.ERROR_MESSAGE);
            cargarConsumoButton.setEnabled(false);
        }
    }//GEN-LAST:event_cargarConsumoButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        if (reservacionSeleccionada != null) {
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea cancelar el Check-In?", "Salir", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                limpiar();
                this.setVisible(false);
            }
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void limpiarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarjButtonActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarjButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        try {
            if (reservacionSeleccionada != null) {
                if (listaConsumo.isEmpty()) {
                    int respuesta = JOptionPane.showConfirmDialog(this, "Confirmar CheckOut", "CheckOut", JOptionPane.YES_NO_OPTION);
                    if (respuesta == 0) {
                        if (manejadorReservacion.CheckOut(reservacionSeleccionada.getIDCliente(), reservacionSeleccionada.getFechaInicial(), reservacionSeleccionada.getFechaFinal(), reservacionSeleccionada.getNoHabitacion(), "")) {
                            JOptionPane.showMessageDialog(this, "CheckOut realizado exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al realizar el CheckOut", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "De realizarse el pago de lo consumido", "Error", JOptionPane.ERROR_MESSAGE);
                    checkOutButton.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "De realizarse el pago de lo consumido", "Error", JOptionPane.ERROR_MESSAGE);
                checkOutButton.setEnabled(false);
                cargarConsumoButton.setEnabled(false);
            }
        } catch (InputsVaciosException | HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_checkOutButtonActionPerformed

    public void actualizarBusquedaObservable(List<Reservacion> listaReser) {
        listaObservableReservacion.clear();
        listaObservableReservacion.addAll(listaReser);
    }

    public ObservableList<Reservacion> getListaObservableReservacion() {
        return listaObservableReservacion;
    }

    public void setListaObservableReservacion(ObservableList<Reservacion> listaObservableReservacion) {
        this.listaObservableReservacion = listaObservableReservacion;
    }

    public Reservacion getReservacionSeleccionada() {
        return reservacionSeleccionada;
    }

    public void setReservacionSeleccionada(Reservacion reservacionSeleccionada) {
        try {
            if (reservacionSeleccionada != null) {
                listaConsumo.clear();
                this.reservacionSeleccionada = reservacionSeleccionada.clone();
                listaConsumo.addAll(manejadorConsumo.busquedaNoHabitacion(this.reservacionSeleccionada.getIDCliente(), this.reservacionSeleccionada.getFechaInicial(), this.reservacionSeleccionada.getFechaFinal(), this.reservacionSeleccionada.getNoHabitacion()));
                if (listaConsumo.isEmpty()) {
                    checkOutButton.setEnabled(true);
                    cargarConsumoButton.setEnabled(false);
                } else {
                    checkOutButton.setEnabled(false);
                    cargarConsumoButton.setEnabled(true);
                }
            } else {
                this.reservacionSeleccionada = null;
                cargarConsumoButton.setEnabled(false);
                checkOutButton.setEnabled(false);
                listaConsumo.clear();
            }
        } catch (InputsVaciosException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton cargarConsumoButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JTable clientesTable;
    private javax.swing.JTextField idClienteTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarjButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        idClienteTextField.setText("");
        listaObservableReservacion.clear();
        listaConsumo.clear();
        cargarConsumoButton.setEnabled(false);
        checkOutButton.setEnabled(false);
    }
}
