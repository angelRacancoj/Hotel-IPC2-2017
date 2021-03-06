/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.GUI.Recepcionista.TipoPago;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Reservacion;
import Hotel.BackEnd.Manejador.ReservarHabitacionM;
import Hotel.GUI.Recepcionista.CheckIn.CheckInConReservacion;
import Hotel.GUI.Recepcionista.CheckIn.SinReservacion;
import Hotel.GUI.Recepcionista.CheckOut.CheckOut;
import RUN.DefaultValues;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angelrg
 */
public class Tarjeta extends javax.swing.JFrame {

    private String voucher;
    private String estado;

    private ReservarHabitacionM manejadorReservacion;

    private Reservacion reservacionSeleccionada;

    public Tarjeta(Connection conexion) {
        manejadorReservacion = new ReservarHabitacionM(conexion);
        reservacionSeleccionada = new Reservacion();
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

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        voucherTextField = new javax.swing.JTextField();
        totalTextField = new javax.swing.JTextField();
        pagarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setTitle("Pago Tarjeta");

        jLabel1.setText("Codigo del Voucher:");

        jLabel2.setText("Total a Pagar:");

        pagarButton.setText("Guardar Voucher");
        pagarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarButtonActionPerformed(evt);
            }
        });

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(voucherTextField))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(regresarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pagarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(voucherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagarButton)
                    .addComponent(regresarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarButtonActionPerformed
        try {
            if (voucherTextField.getText().replace(" ", "").isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar en codigo del Voucher", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (estado.equalsIgnoreCase(DefaultValues.PAGO_ALOJAMIENTO)) {
                    if (!manejadorReservacion.CheckInConReservacion(reservacionSeleccionada.getIDCliente(), reservacionSeleccionada.getFechaInicial(),
                            reservacionSeleccionada.getFechaFinal(), reservacionSeleccionada.getNoHabitacion(), voucherTextField.getText())) {
                        JOptionPane.showMessageDialog(this, "Fallo durante el pago", "Error", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Pago exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        this.setVisible(false);
                    }
//                } else if (estado.equalsIgnoreCase(DefaultValues.PAGO_SIN_RESERVACION)) {
//                    limpiar();
//
//                    this.setVisible(false);
                } else if (estado.equalsIgnoreCase(DefaultValues.PAGO_ALIMENTO)) {
                    if (!manejadorReservacion.CheckOut(reservacionSeleccionada.getIDCliente(), reservacionSeleccionada.getFechaInicial(), reservacionSeleccionada.getFechaFinal(), reservacionSeleccionada.getNoHabitacion(), voucherTextField.getText())) {
                        JOptionPane.showMessageDialog(this, "Fallo durante el pago", "Error", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Pago exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        this.setVisible(false);
                    }
                }
            }
        } catch (InputsVaciosException | HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pagarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        this.setVisible(false);
        limpiar();
    }//GEN-LAST:event_regresarButtonActionPerformed

    public void pagar(String total, String estado, Reservacion reservacion) {
        limpiar();
        totalTextField.setText(total);
        totalTextField.setEnabled(false);
        reservacionSeleccionada = reservacion.clone();
        System.out.println("Reservacion: "+reservacionSeleccionada.getIDCliente()+", "+reservacionSeleccionada.getNoHabitacion());
        this.estado = estado;
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton pagarButton;
    private javax.swing.JButton regresarButton;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JTextField voucherTextField;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        totalTextField.setText("");
        voucherTextField.setText("");
    }
}
