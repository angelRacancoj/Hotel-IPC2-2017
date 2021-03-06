package Hotel.GUI.Reportes;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Manejador.ConsumoM;
import Hotel.BackEnd.Manejador.ReservarHabitacionM;
import RUN.DefaultValues;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angelrg
 */
public class TotalIngresosHotel extends javax.swing.JInternalFrame {

    private ConsumoM manejadorConsumo;
    private ReservarHabitacionM manejadorReservacion;

    private DefaultValues valoresDefinidos;

    public TotalIngresosHotel(Connection conexion) {
        manejadorConsumo = new ConsumoM(conexion);
        manejadorReservacion = new ReservarHabitacionM(conexion);
        valoresDefinidos = new DefaultValues();

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

        jLabel1 = new javax.swing.JLabel();
        fechaInicialFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fechaFinaljFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        obtenerTotalBotton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        reservacionTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalTextField = new javax.swing.JTextField();
        restauranteTextField = new javax.swing.JTextField();
        limpiarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();

        setTitle("Ingresos");

        jLabel1.setFont(new java.awt.Font("Noto Sans UI", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese las fecha, si no coloca fechas se calculara desde");

        try {
            fechaInicialFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Inicial:");

        jLabel3.setText("Final:");

        try {
            fechaFinaljFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Noto Sans UI", 0, 12)); // NOI18N
        jLabel4.setText("el \"Inicio de los tiempos\".");

        obtenerTotalBotton.setText("Obtener total");
        obtenerTotalBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerTotalBottonActionPerformed(evt);
            }
        });

        jLabel5.setText("Reservaciones");

        jLabel6.setText("Restaurante");

        jLabel7.setText("Total");

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fechaInicialFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fechaFinaljFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(obtenerTotalBotton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(reservacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(restauranteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel7)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(limpiarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresarButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaInicialFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFinaljFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obtenerTotalBotton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reservacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restauranteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiarButton)
                    .addComponent(regresarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obtenerTotalBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerTotalBottonActionPerformed
        try {
            if (!fechaInicialFormattedTextField.getText().replace(" ", "").replace("-", "").isEmpty() && !fechaFinaljFormattedTextField.getText().replace(" ", "").replace("-", "").isEmpty()) {
                if (valoresDefinidos.validarFecha(fechaInicialFormattedTextField.getText()) && valoresDefinidos.validarFecha(fechaFinaljFormattedTextField.getText())) {
                    if (manejadorReservacion.cantidadDelDias(fechaInicialFormattedTextField.getText(), fechaFinaljFormattedTextField.getText()) > 0) {
                        restauranteTextField.setText(manejadorConsumo.totalConsumo("", fechaInicialFormattedTextField.getText(), fechaFinaljFormattedTextField.getText()));
                        reservacionTextField.setText(String.valueOf(manejadorReservacion.sumaIngresoPorReservaciones("", fechaInicialFormattedTextField.getText(), fechaFinaljFormattedTextField.getText())));
                        totalTextField.setText(manejadorConsumo.totalConsumo("", fechaInicialFormattedTextField.getText(), fechaFinaljFormattedTextField.getText()) + manejadorReservacion.sumaIngresoPorReservaciones("", fechaInicialFormattedTextField.getText(), fechaFinaljFormattedTextField.getText()));
                    } else {
                        JOptionPane.showMessageDialog(this, "Intervalo de tiempo incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        fechaInicialFormattedTextField.setText("");
                        fechaFinaljFormattedTextField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Una o ambas fechas son invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                    fechaFinaljFormattedTextField.setText("");
                    fechaInicialFormattedTextField.setText("");
                }
            } else {
                restauranteTextField.setText(manejadorConsumo.totalConsumo("", "", ""));
                reservacionTextField.setText(String.valueOf(manejadorReservacion.sumaIngresoPorReservaciones("", "", "")));
                totalTextField.setText(manejadorConsumo.totalConsumo("", "", "") + manejadorReservacion.sumaIngresoPorReservaciones("", "", ""));
            }
        } catch (InputsVaciosException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_obtenerTotalBottonActionPerformed

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        fechaFinaljFormattedTextField.setText("");
        fechaInicialFormattedTextField.setText("");
        totalTextField.setText("");
    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        fechaFinaljFormattedTextField.setText("");
        fechaInicialFormattedTextField.setText("");
        totalTextField.setText("");
        setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField fechaFinaljFormattedTextField;
    private javax.swing.JFormattedTextField fechaInicialFormattedTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JButton obtenerTotalBotton;
    private javax.swing.JButton regresarButton;
    private javax.swing.JTextField reservacionTextField;
    private javax.swing.JTextField restauranteTextField;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
}
