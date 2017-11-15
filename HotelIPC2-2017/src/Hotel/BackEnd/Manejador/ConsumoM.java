package Hotel.BackEnd.Manejador;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Consumo;
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
public class ConsumoM {

    private DefaultValues valoresPre;
    private Connection conexion;
    private HabitacionM manejadorHabitacion;
    private AlimentoM manejadorAlimentos;

    List<Consumo> busquedaConsumo = new ArrayList<>();

    public ConsumoM(Connection conexion) {
        manejadorHabitacion = new HabitacionM(conexion);
        manejadorAlimentos = new AlimentoM(conexion);
        this.conexion = conexion;
    }

    /**
     * Crea un consumo por alimentos.
     * @param noHabitacion
     * @param nombreAlimento
     * @param cantidad
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean nuevoConsumosCliente(String noHabitacion, String nombreAlimento, String cantidad) throws SQLException, InputsVaciosException {
        try {
            /**
             * INSERT INTO CONSUMO
             * (Nombre_Alimento,Cantidad,Total,ID_Reservacion) VALUES
             * (?,?,((SELECT Precio FROM ALIMENTOS WHERE Disponible=?, Nombre=?)
             * * ?),(SELECT ID FROM RESERVACION,TIPO_HABITACION,HABITACION WHERE
             * Categoria=CategoriaTipoHabitacion AND Numero = Numero_Haibtacion
             * AND Estado=? AND Numero_Haibtacion=? AND ((SELECT CURDATE()
             * FECHA) BETWEEN Fecha_Inicial AND Fecha_Final)))
             *
             * INSERT INTO CONSUMO
             * (Nombre_Alimento,Cantidad,Total,ID_Reservacion) VALUES
             * ('Panqueques','5',((SELECT Precio FROM ALIMENTOS WHERE
             * Disponible='1' AND Nombre='Panqueques') * '5'),(SELECT ID FROM
             * RESERVACION,TIPO_HABITACION,HABITACION WHERE
             * Categoria=CategoriaTipoHabitacion AND Numero = Numero_Haibtacion
             * AND Estado='2' AND Numero_Haibtacion='201' AND ((SELECT CURDATE()
             * FECHA) BETWEEN Fecha_Inicial AND Fecha_Final)))
             */

            if (manejadorHabitacion.habitacionEnOcupadaHoy(noHabitacion).isEmpty()) {
                throw new InputsVaciosException("No esta acupada hoy la habitacion " + noHabitacion);
            } else if (manejadorAlimentos.busqueda(cantidad, DefaultValues.DISPONIBLE_SI_COMBO_BOX).isEmpty()) {
                throw new InputsVaciosException("No esta disponible el alimento " + nombreAlimento);
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO CONSUMO"
                        + "(Nombre_Alimento,Cantidad,Total,ID_Reservacion) VALUES (?,?,"
                        + "((SELECT Precio FROM ALIMENTOS WHERE Disponible=? AND Nombre=?) * ?),"
                        + "(SELECT ID FROM RESERVACION,TIPO_HABITACION,HABITACION WHERE Categoria=CategoriaTipoHabitacion "
                        + "AND Numero = Numero_Haibtacion AND Estado=? AND Numero_Haibtacion=? AND "
                        + "((SELECT CURDATE() FECHA) BETWEEN Fecha_Inicial AND Fecha_Final)))");
                sentencia.setString(1, nombreAlimento);
                sentencia.setString(2, cantidad);
                sentencia.setString(3, DefaultValues.DISPONIBLE_SI);
                sentencia.setString(4, nombreAlimento);
                sentencia.setString(5, cantidad);
                sentencia.setString(1, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(1, noHabitacion);
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la base de datos");
        }
    }

    /**
     * Obtiene todos los consumos de de un cliente en un rango de tiempo
     *
     * Si no se ingresan paramentros el sistema lanza todos los consumos
     * existentes
     *
     * @param IDCliente
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Consumo> busqueda(String IDCliente, String fechaInicial, String fechaFinal) throws SQLException, InputsVaciosException {
        boolean IDtry = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialTry = fechaInicial.replace(" ", "").replace("-", "").isEmpty();
        boolean fechaFinalTry = fechaFinal.replace(" ", "").replace("-", "").isEmpty();

        try {
            if (IDtry && (fechaFinalTry || fechaInicialTry)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Nombre_Alimento, Cantidad,"
                        + "Total, ID_Cliente, Numero_Haibtacion FROM CONSUMO,RESERVACION WHERE RESERVACION.ID = ID_Reservacion"
                        + "AND (Estado=? OR Estado=?)");
                sentencia.setString(1, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(2, DefaultValues.HAB_CHECK_OUT_COD);
                return consultaConsumo(sentencia);
            } else if (IDtry && !(fechaFinalTry && fechaInicialTry)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Nombre_Alimento, Cantidad,"
                        + "Total, ID_Cliente, Numero_Haibtacion FROM CONSUMO,RESERVACION WHERE RESERVACION.ID = ID_Reservacion"
                        + "AND (Fecha_Inicial BETWEEN ? AND ? AND Fecha_Final BETWEEN ? AND ?) AND (Estado=? OR Estado=?)");
                sentencia.setString(1, fechaInicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, fechaInicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(6, DefaultValues.HAB_CHECK_OUT_COD);
                return consultaConsumo(sentencia);
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT Nombre_Alimento, Cantidad,"
                        + "Total, ID_Cliente, Numero_Haibtacion FROM CONSUMO,RESERVACION WHERE RESERVACION.ID = ID_Reservacion"
                        + "AND (Fecha_Inicial BETWEEN ? AND ? AND Fecha_Final BETWEEN ? AND ?) AND ID_Cliente=? AND (Estado=? OR Estado=?)");
                sentencia.setString(1, fechaInicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, fechaInicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, IDCliente);
                sentencia.setString(6, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(6, DefaultValues.HAB_CHECK_OUT_COD);
                return consultaConsumo(sentencia);
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la base de datos");
        }
    }

    /**
     * Obtiene el total de todos los consumos realizados por un cliente con un
     * filtro de fechas Si no se ingresan paramentros lanza todos los resultados
     *
     * @param IDCliente
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public String totalConsumo(String IDCliente, String fechaInicial, String fechaFinal) throws SQLException, InputsVaciosException {
        boolean IDtry = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialTry = fechaInicial.replace(" ", "").replace("-", "").isEmpty();
        boolean fechaFinalTry = fechaFinal.replace(" ", "").replace("-", "").isEmpty();

        try {
            if (IDtry && (fechaFinalTry || fechaInicialTry)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT SUM(Total) as total FROM CONSUMO,RESERVACION "
                        + "WHERE RESERVACION.ID = ID_Reservacion AND (Estado=? OR Estado=?)");
                sentencia.setString(1, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(2, DefaultValues.HAB_CHECK_OUT_COD);
                return totalSuma(sentencia);
            } else if (IDtry && !(fechaFinalTry && fechaInicialTry)) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT SUM(Total) as total FROM CONSUMO,RESERVACION "
                        + "WHERE RESERVACION.ID = ID_Reservacion AND "
                        + "(Fecha_Inicial BETWEEN ? AND ? AND Fecha_Final BETWEEN ? AND ?) AND (Estado=? OR Estado=?)");
                sentencia.setString(1, fechaInicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, fechaInicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(6, DefaultValues.HAB_CHECK_OUT_COD);
                return totalSuma(sentencia);
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT SUM(Total) as total FROM CONSUMO,RESERVACION "
                        + "WHERE RESERVACION.ID = ID_Reservacion AND (Fecha_Inicial BETWEEN ? AND ? AND Fecha_Final BETWEEN ? AND ?) "
                        + "AND ID_Cliente=? (Estado=? OR Estado=?)");
                sentencia.setString(1, fechaInicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, fechaInicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, IDCliente);
                sentencia.setString(6, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(7, DefaultValues.HAB_CHECK_OUT_COD);
                return totalSuma(sentencia);
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la base de datos");
        }
    }

    private List<Consumo> consultaConsumo(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        busquedaConsumo.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombreAlimento = resultado.getString("Nombre_Alimento");
                String Cantidad = resultado.getString("Cantidad");
                String Total = resultado.getString("Total");
                String IDCliente = resultado.getString("ID_Cliente");
                String noHabitacion = resultado.getString("Numero_Haibtacion");
                System.out.println("Consumo: " + nombreAlimento + "," + Cantidad + "," + Total + "," + IDCliente + "," + noHabitacion);
                busquedaConsumo.add(new Consumo(nombreAlimento, Cantidad, Total, IDCliente, noHabitacion));
            }
            System.out.println("/////////////////////////////////////");
            resultado.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la base de datos");
        }
        return busquedaConsumo;
    }

    private String totalSuma(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        String total = "";
        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                total = resultado.getString("total");
                System.out.println("Total: " + total);
            }
            resultado.close();
            return total;
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la base de datos");
        }
    }
}
