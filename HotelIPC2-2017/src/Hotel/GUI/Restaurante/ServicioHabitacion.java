/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.GUI.Restaurante;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Alimento;
import Hotel.BackEnd.Manejador.AlimentoM;
import Hotel.BackEnd.Manejador.ConsumoM;
import RUN.DefaultValues;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author angelrg
 */
public class ServicioHabitacion extends javax.swing.JInternalFrame {

    private List<Alimento> listaAlimentos;
    private ObservableList<Alimento> listaAlimentosObservable;

    private Alimento alimentoSeleccionado;

    private AlimentoM manejadorAlimento;
    private ConsumoM manejadorConsumo;

    public ServicioHabitacion(Connection conexion) {

        listaAlimentos = new ArrayList<>();
        listaAlimentosObservable = ObservableCollections.observableList(listaAlimentos);

        alimentoSeleccionado = new Alimento();

        manejadorAlimento = new AlimentoM(conexion);
        manejadorConsumo = new ConsumoM(conexion);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noHabitacionComboBox = new javax.swing.JComboBox<>();
        actualizarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        agregarCuentaButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cantidadComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setMaximizable(true);
        setResizable(true);
        setTitle("Servicio a la Habitacion");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaAlimentosObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${alimentoSeleccionado}"), jTable2, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("ALIMENTOS");

        jLabel3.setText("Seleccione la Habitacion:");

        noHabitacionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habitacion", "101", "102", "103", "104", "201", "202", "203", "204", "301", "302", "303", "304", "401", "402", "403", "404" }));

        actualizarButton.setText("Actualizar");
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        agregarCuentaButton.setText("Agregar a la Cuenta");
        agregarCuentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCuentaButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad:");

        cantidadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));

        jLabel2.setText("Luego presione el alimento entregado y luego en agregar a la cuenta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(actualizarButton)
                        .addGap(18, 18, 18)
                        .addComponent(regresarButton)
                        .addGap(161, 161, 161)
                        .addComponent(agregarCuentaButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(noHabitacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cantidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(noHabitacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarButton)
                    .addComponent(regresarButton)
                    .addComponent(agregarCuentaButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        try {
            actualizarBusquedaObservable(manejadorAlimento.busqueda("", DefaultValues.DISPONIBLE_TODO_COMBO_BOX));
        } catch (InputsVaciosException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        if (alimentoSeleccionado != null) {
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea abandonar sin agregar el consumo?", "Salir", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                cantidadComboBox.setSelectedIndex(0);
                noHabitacionComboBox.setSelectedIndex(0);
                this.setVisible(false);
            }
        } else {
            setVisible(false);
        }
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void agregarCuentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCuentaButtonActionPerformed
        try {
            if (noHabitacionComboBox.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar la habitacion", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (cantidadComboBox.getSelectedIndex() <= 0) {
                    JOptionPane.showMessageDialog(this, "Debe colocar una cantidad mayor a '0'", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("Consumo:" + noHabitacionComboBox.getSelectedItem() + ", " + alimentoSeleccionado.getNombre() + ", " + cantidadComboBox.getSelectedIndex());
                    manejadorConsumo.nuevoConsumosCliente(String.valueOf(noHabitacionComboBox.getSelectedItem()), alimentoSeleccionado.getNombre(), String.valueOf(cantidadComboBox.getSelectedIndex()));
                    JOptionPane.showMessageDialog(this, "Consumo agregado exitosamente", "Consumo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (HeadlessException | SQLException | InputsVaciosException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_agregarCuentaButtonActionPerformed

    public void actualizarBusquedaObservable(List<Alimento> listaAlimentos) {
        this.listaAlimentosObservable.clear();
        this.listaAlimentosObservable.addAll(listaAlimentos);
    }

    public ObservableList<Alimento> getListaAlimentosObservable() {
        return listaAlimentosObservable;
    }

    public void setListaAlimentosObservable(ObservableList<Alimento> listaAlimentosObservable) {
        this.listaAlimentosObservable = listaAlimentosObservable;
    }

    public Alimento getAlimentoSeleccionado() {
        return alimentoSeleccionado;
    }

    public void setAlimentoSeleccionado(Alimento alimentoSeleccionado) {
        if (alimentoSeleccionado != null) {
            this.alimentoSeleccionado = alimentoSeleccionado.clone();
            agregarCuentaButton.setEnabled(true);
        } else {
            agregarCuentaButton.setEnabled(false);
            this.alimentoSeleccionado = null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton agregarCuentaButton;
    private javax.swing.JComboBox<String> cantidadComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> noHabitacionComboBox;
    private javax.swing.JButton regresarButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
