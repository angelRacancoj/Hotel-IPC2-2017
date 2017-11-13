/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUN;

import Hotel.GUI.Principal.LogIn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author angelrg
 */
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
        try {
            //Indicamos cual driver usar
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection("jdbc:mysql://localhost?user=root&password=ex=d/dx=ex");
            System.out.println("conectado:" + connection.getCatalog());
            Statement seleccionarDB = connection.createStatement();
            seleccionarDB.executeUpdate("USE Hotel_El_Descanso");
            LogIn logIn = new LogIn(connection);
            logIn.setVisible(true);
            Date fechaActual = null;
            PreparedStatement objeto = connection.prepareStatement("SELECT CURDATE() FECHA_ACTUAL");
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                fechaActual = resultado.getDate("FECHA_ACTUAL");
            }
            System.out.println(String.valueOf(fechaActual));

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("error");
            e.printStackTrace(System.out);
        }
    }
}
