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
     * Devuelve el elemento Habitacion pero con los paramentros numero, cantidad y texto en la ultima casilla
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public Habitacion habitacionPopular() throws SQLException, InputsVaciosException {
        busquedaHabitacion.clear();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT Numero_Haibtacion, COUNT(*) FROM RESERVACION,HABITACION "
                    + "WHERE Numero_Haibtacion=Numero GROUP BY Numero_Haibtacion ORDER BY COUNT(*) DESC LIMIT 1");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String numero = resultado.getString("Numero_Haibtacion");
                String cantidad = resultado.getString("COUNT(*)");
                System.out.println("Habitacion: " + numero + "," + cantidad);
                return new Habitacion(numero, cantidad, "Mas Popular");
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return null;
    }

    /**
     * Devuelve las habitaciones con la categoria, precio y numero, busca la
     * habitaciones que tiene reservacion en el intervalo de tiempo
     *
     * @param fechaIncial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> habitacionesDisponibles(String fechaIncial, String fechaFinal) throws SQLException, InputsVaciosException {
        busquedaHabitacion.clear();
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
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                String numero = resultado.getString("Numero");
                String categoria = resultado.getString("Categoria");
                String precio = resultado.getString("Precio");
                System.out.println("Habitacion Disponible: "+numero+","+categoria+","+precio);
                busquedaHabitacion.add(new Habitacion(numero, precio, categoria));
            }
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error al obtener las habitaciones");
        }
        return busquedaHabitacion;
    }

    /**
     * Devuelve la habitacion con un criterio de cuales estan ocupadas segun los
     * paramentros, permitiendo q no se coloque numero liberando el filtro para
     * realizar la busqueda en base al estado y las fechas
     *
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
     * Devuelve el nombre, precio y estado
     *
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
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaHabitacion;
    }

    /**
     * Modifica el precio de las habitaciones en base a las categorias y precios
     *
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
                sentencia.close();
                return true;
            } else {
                sentencia.close();
                return false;
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }

    }

    /**
     * Funcion para la tabla con los precios segun la categoria de la habitacion
     *
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> busquedaPrecioHabitacion() throws SQLException, InputsVaciosException {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM TIPO_HABITACION ORDER BY Categoria ASC");
            return consultaPrecioHabitacion(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error al obtener los precios");
        }
    }

    /**
     * Devuelve la categoria y el precio de las habitaciones
     *
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
            sentencia.close();
        } catch (Exception e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaHabitacion;
    }

    public double precioHabitacion(String noHabitacion) throws SQLException, InputsVaciosException {
        double precio = 0;
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT Precio FROM TIPO_HABITACION,HABITACION WHERE "
                    + "Categoria=CategoriaTipoHabitacion AND Numero =?");
            sentencia.setString(1, noHabitacion);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                precio = resultado.getDouble("Precio");
            }
            resultado.close();
            sentencia.close();
            return precio;
        } catch (Exception e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Nos devuelve si la habitacion q le hemos indicado esta reservada mediante
     * una lista vacio o con el elemente que se pidio
     *
     * @param noHabitacion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Habitacion> habitacionEnOcupadaHoy(String noHabitacion) throws SQLException, InputsVaciosException {

        try {
            /**
             * Lineas de prueba INSERT INTO RESERVACION
             *
             * (Fecha_Inicial,Fecha_Final,Estado,Pago_Habitacion,Pago_Restaurante,Numero_Haibtacion,ID_Cliente)
             * VALUES
             * ('2017-11-13','2017-11-17','2','1002.75','0','201','2929292920901');
             *
             * SELECT Categoria,Precio,Numero FROM
             * RESERVACION,TIPO_HABITACION,HABITACION WHERE Numero =
             * Numero_Haibtacion AND Categoria=CategoriaTipoHabitacion AND
             * Estado=2 AND Numero_Haibtacion=201 AND ((SELECT CURDATE() FECHA)
             * BETWEEN Fecha_Inicial AND Fecha_Final)
             */
            PreparedStatement sentencia = conexion.prepareStatement("SELECT Categoria,Precio,Numero FROM RESERVACION,TIPO_HABITACION,HABITACION WHERE "
                    + "Categoria=CategoriaTipoHabitacion AND Numero = Numero_Haibtacion AND Estado=? AND Numero_Haibtacion=? AND "
                    + "((SELECT CURDATE() FECHA) BETWEEN Fecha_Inicial AND Fecha_Final)");
            sentencia.setString(1, DefaultValues.HAB_OCUPADA_COD);
            sentencia.setString(2, noHabitacion);
            return consultaPrecioHabitacion(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    public List<Habitacion> getBusquedaHabitacion() {
        return busquedaHabitacion;
    }

    public void setBusquedaHabitacion(List<Habitacion> busquedaHabitacion) {
        this.busquedaHabitacion = busquedaHabitacion;
    }
    
    
}
