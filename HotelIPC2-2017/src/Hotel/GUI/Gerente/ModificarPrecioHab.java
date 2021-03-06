package Hotel.GUI.Gerente;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Habitacion;
import Hotel.BackEnd.Manejador.HabitacionM;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author angelrg
 */
public class ModificarPrecioHab extends javax.swing.JInternalFrame {

    private Habitacion habitacionSeleccionada;

    private List<Habitacion> listadoHAbitaciones;
    private ObservableList<Habitacion> listaObservableHab;

    private HabitacionM manejadorHabitacion;

    public ModificarPrecioHab(Connection conexion) {
        habitacionSeleccionada = new Habitacion();
        listadoHAbitaciones = new LinkedList<>();
        listaObservableHab = ObservableCollections.observableList(listadoHAbitaciones);
        manejadorHabitacion = new HabitacionM(conexion);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        guardarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        actualizarButton = new javax.swing.JButton();
        precioFormattedTextField = new javax.swing.JFormattedTextField();

        setTitle("Modificar Precios de las Habitaciones");

        jLabel1.setText("Presione sobre la fila de la habitacion a modificar:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaObservableHab}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreTipo}"));
        columnBinding.setColumnName("Nombre Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${habitacionSeleccionada}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Precio: Q.");

        guardarButton.setText("Guardar Cambios");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        actualizarButton.setText("Actualizar");
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        precioFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(actualizarButton)
                        .addGap(223, 223, 223)
                        .addComponent(cancelarButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioFormattedTextField)
                        .addGap(18, 18, 18)
                        .addComponent(guardarButton)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(guardarButton)
                    .addComponent(precioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(actualizarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        try {
            if (habitacionSeleccionada != null || (!precioFormattedTextField.getText().replace(" ","").replace(".","").isEmpty())) {
                if (manejadorHabitacion.modificarPrecioHabitacion(habitacionSeleccionada.getNombre(), precioFormattedTextField.getText())) {
                    JOptionPane.showMessageDialog(this, "Cambio realizado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    precioFormattedTextField.setText("");
                }else{
                    JOptionPane.showMessageDialog(this, "No se cambio el precio", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debe seleccionar un elemente y colocar el precio", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (InputsVaciosException | HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        try {
            actualizarListaObservable(manejadorHabitacion.busquedaPrecioHabitacion());
            guardarButton.setEnabled(false);
        } catch (InputsVaciosException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        if (habitacionSeleccionada != null) {
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea terminar el proceso?", "Salir", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                limpiar();
                this.setVisible(false);
            }
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelarButtonActionPerformed

    public void actualizarListaObservable(List<Habitacion> listadoHabitaciones) {
        listaObservableHab.clear();
        listaObservableHab.addAll(listadoHabitaciones);
    }

    public Habitacion getHabitacionSeleccionada() {
        return habitacionSeleccionada;
    }

    public void setHabitacionSeleccionada(Habitacion habitacionSeleccionada) {
        if (habitacionSeleccionada != null) {
            this.habitacionSeleccionada = habitacionSeleccionada.clone();
            precioFormattedTextField.setText(this.habitacionSeleccionada.getPrecio());
            guardarButton.setEnabled(true);
        } else {
            this.habitacionSeleccionada = null;
            guardarButton.setEnabled(false);
        }
    }

    public ObservableList<Habitacion> getListaObservableHab() {
        return listaObservableHab;
    }

    public void setListaObservableHab(ObservableList<Habitacion> listaObservableHab) {
        this.listaObservableHab = listaObservableHab;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField precioFormattedTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {

    }
}
