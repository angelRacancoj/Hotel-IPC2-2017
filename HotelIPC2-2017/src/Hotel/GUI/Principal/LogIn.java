package Hotel.GUI.Principal;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Manejador.UsuariosM;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angelrg
 */
public class LogIn extends javax.swing.JFrame {

    private UsuariosM usuario;
    private UsuariosM manejadorUsuario;

    private Principal principalFrame;

    public LogIn(Connection conexion) {
        manejadorUsuario = new UsuariosM(conexion);
        this.usuario = new UsuariosM(conexion);

        //Frame principal
        this.principalFrame = new Principal(conexion);

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
        usuarioTextField = new javax.swing.JTextField();
        ContrasenaPasswordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        ingresarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log-In");

        jLabel1.setText("Usuario:");

        usuarioTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usuarioTextFieldFocusLost(evt);
            }
        });

        jLabel2.setText("Contraseña:");

        ingresarButton.setText("Ingresar");
        ingresarButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ingresarButtonFocusGained(evt);
            }
        });
        ingresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(ContrasenaPasswordField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ingresarButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContrasenaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingresarButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarButtonActionPerformed
        try {
            if (manejadorUsuario.iniciar(usuarioTextField.getText(), new String(ContrasenaPasswordField.getPassword()))!=null) {
                principalFrame.iniciar(manejadorUsuario.iniciar(usuarioTextField.getText(), new String(ContrasenaPasswordField.getPassword())));
            limpiar();
            this.setVisible(false);
            principalFrame.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (InputsVaciosException | HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ingresarButtonActionPerformed

    private void usuarioTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioTextFieldFocusLost
        try {
            if (usuarioTextField.getText().replace(" ", "").isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe colocar su usuario", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (manejadorUsuario.busqueda(usuarioTextField.getText(), "").isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No existe el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                    usuarioTextField.setText("");
                    ContrasenaPasswordField.setText("");
                } else {
                    ingresarButton.setEnabled(true);
                }
            }
        } catch (InputsVaciosException | HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_usuarioTextFieldFocusLost

    private void ingresarButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ingresarButtonFocusGained
        try {
            if (usuarioTextField.getText().replace(" ", "").isEmpty() || (ContrasenaPasswordField.getPassword().length <= 0)) {
                ingresarButton.setEnabled(false);
                limpiar();
                JOptionPane.showMessageDialog(this, "Debe colocar Usuario y su Contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ingresarButton.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ingresarButtonFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ContrasenaPasswordField;
    private javax.swing.JButton ingresarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        ContrasenaPasswordField.setText("");
        usuarioTextField.setText("");
    }
}
