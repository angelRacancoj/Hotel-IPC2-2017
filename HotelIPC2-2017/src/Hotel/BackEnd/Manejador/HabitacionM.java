/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.BackEnd.Manejador;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Habitacion;
import RUN.DefaultValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelrg
 */
public class HabitacionM {
    private DefaultValues valoresPre;
    private Connection conexion;
    
    List<Habitacion>busquedaHabitacion = new ArrayList<>();

    public HabitacionM(Connection conexion) {
        this.conexion = conexion;
    }
    
    public boolean modificarHabitacion(String categoria, String precio)throws SQLException, InputsVaciosException{
        try {
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE TIPO_HABITACION SET Precio=? WHERE Categoria=? LIMIT 1");
            sentencia.setString(1, precio);
            sentencia.setString(2, categoria);
            if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    
    }
    
    public List<Habitacion> busqueda(String categoria)throws SQLException, InputsVaciosException{
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM TIPO_HABITACION WHERE Categoria=? ORDER BY Categoria ASC");
            sentencia.setString(1, categoria);
            return consultaHabitacion(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }
    
    public List<Habitacion> consultaHabitacion(PreparedStatement sentencia)throws SQLException, InputsVaciosException{
        busquedaHabitacion.clear();
        
        try {
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                String categoria = resultado.getString("Categoria");
                String precio = resultado.getString("Precio");
                System.out.println("Habitacion: "+precio+", "+categoria);
                busquedaHabitacion.add(new Habitacion(categoria, precio,"Precio en Q"));
            }
            System.out.println("*********************************");
            resultado.close();
        } catch (Exception e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaHabitacion;
    }
}
