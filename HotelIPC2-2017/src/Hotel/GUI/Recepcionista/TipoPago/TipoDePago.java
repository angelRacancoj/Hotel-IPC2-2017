/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.GUI.Recepcionista.TipoPago;

/**
 *
 * @author angelrg
 */
public class TipoDePago extends javax.swing.JFrame {

    private String IDCliente;
    private String fechaFinal;
    private String fechaInicial;
    private String noHab;
    
    private Efectivo pagoEfectivo;
    private Tarjeta pagoTarjeta;
    public TipoDePago() {
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

        efectivoButton = new javax.swing.JButton();
        tarjetaButton = new javax.swing.JButton();

        setTitle("Tipo de Pago");

        efectivoButton.setText("Efectivo");
        efectivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectivoButtonActionPerformed(evt);
            }
        });

        tarjetaButton.setText("Tarjeta");
        tarjetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(efectivoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tarjetaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(efectivoButton)
                    .addComponent(tarjetaButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void efectivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectivoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_efectivoButtonActionPerformed

    private void tarjetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaButtonActionPerformed

    public void tratarPago(String fechaInicial, String fechaFinal, String noHabitacion){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton efectivoButton;
    private javax.swing.JButton tarjetaButton;
    // End of variables declaration//GEN-END:variables
}
