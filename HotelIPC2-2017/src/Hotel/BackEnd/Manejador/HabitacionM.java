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

    List<Habitacion> busquedaHabitacion = new ArrayList<>();

    public HabitacionM(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     *Devuelve las habitaciones con la categoria, precio y numero, busca la habitaciones que tiene reservacion en el intervalo de tiempo
     * @param fechaIncial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> habitacionesDisponibles(String fechaIncial, String fechaFinal) throws SQLException, InputsVaciosException {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT Categoria,Precio,Numero FROM TIPO_HABITACION,HABITACION WHERE "
                    + "Categoria=CategoriaTipoHabitacion AND (Numero NOT IN (SELECT Numero_haibtacion FROM RESERVACION WHERE Estado=? AND "
                    + "Estado =? AND (Fecha_Inicial BETWEEN ? AND ? OR Fecha_Final BETWEEN ? AND ?)))");
            sentencia.setString(1, DefaultValues.HAB_RESERVADA_COD);
            sentencia.setString(2, DefaultValues.HAB_OCUPADA_COD);
            sentencia.setString(3, fechaIncial);
            sentencia.setString(4, fechaFinal);
            sentencia.setString(5, fechaIncial);
            sentencia.setString(6, fechaFinal);
            return consultaPrecioHabitacion(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     *Devuelve la habitacion con un criterio de cuales estan ocupadas segun los paramentros, permitiendo q no se coloque numero liberando el filtro
     * para realizar la busqueda en base al estado y las fechas
     * @param numero
     * @param estado
     * @param fechainicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> busquedaPorEstadoHabiacion(String numero, String estado, String fechainicial, String fechaFinal) throws SQLException, InputsVaciosException {
        boolean tryNumero = numero.replace(" ", "").isEmpty();

        try {
            if (tryNumero && !estado.equals(DefaultValues.HAB_TODO_COMBO_BOX)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero, Precio, Estado FROM "
                        + "RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion AND"
                        + "Numero = Numero_Haibtacion AND Estado=? AND (Fecha_Inicial BETWEEN ? AND ? OR Fecha_Final BETWEEN ? AND ?)");
                sentencia.setString(1, estado);
                sentencia.setString(2, fechainicial);
                sentencia.setString(3, fechaFinal);
                sentencia.setString(4, fechainicial);
                sentencia.setString(5, fechaFinal);
                return consultaEstadoHabitacion(sentencia);
            } else if (tryNumero && estado.equals(DefaultValues.HAB_TODO_COMBO_BOX)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero, Precio, Estado FROM "
                        + "RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion AND"
                        + "Numero = Numero_Haibtacion AND (Fecha_Inicial BETWEEN ? AND ? OR Fecha_Final BETWEEN ? AND ?)");
                sentencia.setString(1, fechainicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, fechainicial);
                sentencia.setString(4, fechaFinal);
                return consultaEstadoHabitacion(sentencia);
            } else if (!estado.equals(DefaultValues.HAB_TODO_COMBO_BOX)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero, Precio, Estado FROM "
                        + "RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion AND"
                        + "Numero = Numero_Haibtacion AND Estado=? AND (Fecha_Inicial BETWEEN ? AND ? OR Fecha_Final BETWEEN ? AND ?)"
                        + "AND Numero LIKE ?");
                sentencia.setString(1, estado);
                sentencia.setString(2, fechainicial);
                sentencia.setString(3, fechaFinal);
                sentencia.setString(4, fechainicial);
                sentencia.setString(5, fechaFinal);
                sentencia.setString(6, numero);
                return consultaEstadoHabitacion(sentencia);
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero, Precio, Estado FROM "
                        + "RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion AND"
                        + "Numero = Numero_Haibtacion AND (Fecha_Inicial BETWEEN ? AND ? OR Fecha_Final BETWEEN ? AND ?)"
                        + "AND Numero LIKE ?");
                sentencia.setString(1, fechainicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, fechainicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, numero);
                return consultaEstadoHabitacion(sentencia);
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     *Devuelve el nombre, precio y estado
     * @param sentencia
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> consultaEstadoHabitacion(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        busquedaHabitacion.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String precio = resultado.getString("Precio");
                String estado = resultado.getString("Estado");
                System.out.println("Habitacion: " + nombre + "," + precio + "," + estado);
                busquedaHabitacion.add(new Habitacion(nombre, precio, estado));
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaHabitacion;
    }

    /**
     * Modifica el precio de las habitaciones en base a las categorias y precios
     * @param categoria
     * @param precio
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean modificarPrecioHabitacion(String categoria, String precio) throws SQLException, InputsVaciosException {
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

    /**
     * Funcion para la tabla con los precios segun la categoria de la habitacion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> busquedaPrecioHabitacion() throws SQLException, InputsVaciosException {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM TIPO_HABITACION WHERE ORDER BY Categoria ASC");
            return consultaPrecioHabitacion(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     *Devuelve la categoria y el precio de las habitaciones
     * @param sentencia
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> consultaPrecioHabitacion(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        busquedaHabitacion.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String categoria = resultado.getString("Categoria");
                String precio = resultado.getString("Precio");
                System.out.println("Habitacion: " + precio + ", " + categoria);
                busquedaHabitacion.add(new Habitacion(categoria, precio, "Precio en Q"));
            }
            System.out.println("*********************************");
            resultado.close();
        } catch (Exception e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaHabitacion;
    }
}
