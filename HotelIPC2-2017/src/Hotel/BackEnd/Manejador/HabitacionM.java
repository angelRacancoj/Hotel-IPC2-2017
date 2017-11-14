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
    
    public List<Habitacion> busquedaPorEstadoHabiacion(String numero, String estado, String fechainicial, String fechaFinal)throws SQLException, InputsVaciosException{
        boolean tryNumero = numero.replace(" ","").isEmpty();
        
        try {
            if (tryNumero) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero, Precio, Estado FROM "
                        + "RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion AND"
                        + "Numero = Numero_Haibtacion AND Estado=? AND Fecha_Inicial >= ? AND Fecha_Final <= ?");
                sentencia.setString(1, estado);
                sentencia.setString(2, fechainicial);
                sentencia.setString(3, fechaFinal);
                return consultaEstadoHabitacion(sentencia);
            }else{
               PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero, Precio, Estado FROM "
                        + "RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion AND"
                        + "Numero = Numero_Haibtacion AND Estado=? AND Fecha_Inicial >= ? AND Fecha_Final <= ?"
                       + "AND Numero LIKE ?");
                sentencia.setString(1, estado);
                sentencia.setString(2, fechainicial);
                sentencia.setString(3, fechaFinal);
                sentencia.setString(4, numero);
                return consultaEstadoHabitacion(sentencia); 
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }
    
    public List<Habitacion> consultaEstadoHabitacion(PreparedStatement sentencia)throws SQLException, InputsVaciosException{
        busquedaHabitacion.clear();
        
        try {
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                String nombre= resultado.getString("Nombre");
                String precio= resultado.getString("Precio");
                String estado= resultado.getString("Estado");
                System.out.println("Habitacion: "+nombre+","+precio+","+estado);
                busquedaHabitacion.add(new Habitacion(nombre, precio, estado));
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaHabitacion;
    }
    
    public boolean modificarPrecioHabitacion(String categoria, String precio)throws SQLException, InputsVaciosException{
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
    
    public List<Habitacion> busquedaPrecioHabitacion(String categoria)throws SQLException, InputsVaciosException{
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM TIPO_HABITACION WHERE Categoria=? ORDER BY Categoria ASC");
            sentencia.setString(1, categoria);
            return consultaPrecioHabitacion(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }
    
    public List<Habitacion> consultaPrecioHabitacion(PreparedStatement sentencia)throws SQLException, InputsVaciosException{
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
