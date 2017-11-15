package Hotel.BackEnd.Manejador;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Reservacion;
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
public class ReservarHabitacionM {

    DefaultValues valoresPre;
    private Connection coneccion;
    private HabitacionM manejadorHabitacion;

    List<Reservacion> busquedaReservacion = new ArrayList<>();

    public ReservarHabitacionM(Connection coneccion) {
        manejadorHabitacion = new HabitacionM(coneccion);
        this.coneccion = coneccion;
    }
    
    /**
     * Se realiza el checkIn sin necesidad de realizar la reservacion, ya que directamente guarda que ya se realizo en ingreso
     * @param IDCliente
     * @param fechaInicial
     * @param fechaFinal
     * @param numeroHabitacion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean CheckInSinReservacion(String IDCliente, String fechaInicial, String fechaFinal, String numeroHabitacion) throws SQLException, InputsVaciosException {
        boolean IDClienteTry = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialTry = fechaInicial.replace(" ", "").isEmpty();
        boolean fechaFinalTry = fechaFinal.replace(" ", "").isEmpty();
        boolean noHabtiacionTry = numeroHabitacion.replace(" ", "").isEmpty();

        try {
            if (IDClienteTry || fechaFinalTry || fechaInicialTry || noHabtiacionTry || (cantidadDelDias(fechaInicial, fechaFinal) < 0)) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                PreparedStatement sentencia = coneccion.prepareStatement("INSERT INTO RESERVACION "
                        + "(Fecha_Inicial, Fecha_Final, Estado, Numero_Haibtacion, ID_Cliente,Pago_Habitacion) VALUES (?,?,?,?,?,?)");
                sentencia.setString(1, fechaInicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(4, numeroHabitacion);
                sentencia.setString(5, IDCliente);
                sentencia.setString(6, String.valueOf(cantidadDelDias(fechaInicial, fechaFinal) * manejadorHabitacion.precioHabitacion(numeroHabitacion)));
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Permite realizar el chech-in tomando en cuenta que la reservacion ya
     * existe
     *
     * @param IDCliente
     * @param fechaInicial
     * @param fechaFinal
     * @param numeroHabitacion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean CheckInConReservacion(String IDCliente, String fechaInicial, String fechaFinal, String numeroHabitacion) throws SQLException, InputsVaciosException {
        boolean IDClienteTry = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialTry = fechaInicial.replace(" ", "").isEmpty();
        boolean fechaFinalTry = fechaFinal.replace(" ", "").isEmpty();
        boolean noHabtiacionTry = numeroHabitacion.replace(" ", "").isEmpty();

        try {
            if (IDClienteTry || fechaFinalTry || fechaInicialTry || noHabtiacionTry || (cantidadDelDias(fechaInicial, fechaFinal) < 0)) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                PreparedStatement sentencia = coneccion.prepareStatement("UPDATE RESERVACION SET Pago_Habitacion=?,Estado=? WHERE ID_Cliente=? AND "
                        + "Fecha_Inicial=? AND Fecha_Final=? AND Estado=? AND Numero_Haibtacion=?");
                sentencia.setString(1, String.valueOf(cantidadDelDias(fechaInicial, fechaFinal) * manejadorHabitacion.precioHabitacion(numeroHabitacion)));
                sentencia.setString(1, DefaultValues.HAB_OCUPADA_COD);
                sentencia.setString(2, IDCliente);
                sentencia.setString(3, fechaInicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, DefaultValues.HAB_RESERVADA_COD);
                sentencia.setString(6, numeroHabitacion);
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * En vez de eliminar el registro, simplemente modifica el estado del mismo
     * de tal manera que si se llegara a necesitar conocer que reservaciones
     * fuero eliminadas, el sistema contiene los registros.
     *
     * @param IDCliente
     * @param fechaInicial
     * @param fechaFinal
     * @param numeroHabitacion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean deshabilitarReservacion(String IDCliente, String fechaInicial, String fechaFinal, String numeroHabitacion) throws SQLException, InputsVaciosException {
        boolean IDClienteTry = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialTry = fechaInicial.replace(" ", "").isEmpty();
        boolean fechaFinalTry = fechaFinal.replace(" ", "").isEmpty();
        boolean noHabtiacionTry = numeroHabitacion.replace(" ", "").isEmpty();

        try {
            if (IDClienteTry || fechaFinalTry || fechaInicialTry || noHabtiacionTry || (cantidadDelDias(fechaInicial, fechaFinal) < 0)) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                PreparedStatement sentencia = coneccion.prepareStatement("UPDATE RESERVACION SET Estado=? WHERE ID_Cliente=? AND "
                        + "Fecha_Inicial=? AND Fecha_Final=? AND Estado=? AND Numero_Haibtacion=?");
                sentencia.setString(1, DefaultValues.HAB_ELIMINADA_COD);
                sentencia.setString(2, IDCliente);
                sentencia.setString(3, fechaInicial);
                sentencia.setString(4, fechaFinal);
                sentencia.setString(5, DefaultValues.HAB_RESERVADA_COD);
                sentencia.setString(6, numeroHabitacion);
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Modifica con los nuevos datos de entrada, modifica la anterior
     * reservacion, siempre que esta este solo como reservacion, no sobre la
     * marcha
     *
     * @param IDCliente
     * @param fechaInicialAnterior
     * @param FechaFinalAnterior
     * @param fechaInicialNueva
     * @param FechaFinalNueva
     * @param noHabitacionAnterior
     * @param noHabitacionNueva
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean modificarReservacion(String IDCliente, String fechaInicialAnterior, String FechaFinalAnterior, String fechaInicialNueva,
            String FechaFinalNueva, String noHabitacionAnterior, String noHabitacionNueva) throws SQLException, InputsVaciosException {
        boolean IDClienteBoo = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialAntBoo = fechaInicialAnterior.replace(" ", "").isEmpty();
        boolean fechaFinalAntBoo = FechaFinalAnterior.replace(" ", "").isEmpty();
        boolean fechaInicialNewBoo = fechaInicialNueva.replace(" ", "").isEmpty();
        boolean fechaFinalNewBoo = FechaFinalNueva.replace(" ", "").isEmpty();
        boolean noHabitacionAntBoo = noHabitacionAnterior.replace(" ", "").isEmpty();
        boolean noHabitacionNewBoo = noHabitacionNueva.replace(" ", "").isEmpty();

        try {
            if (IDClienteBoo || fechaInicialAntBoo || fechaFinalAntBoo || fechaInicialNewBoo || fechaFinalNewBoo || noHabitacionAntBoo
                    || noHabitacionNewBoo || (cantidadDelDias(fechaInicialAnterior, FechaFinalAnterior) < 0) || (cantidadDelDias(fechaInicialNueva, FechaFinalNueva) < 0)) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                PreparedStatement sentencia = coneccion.prepareStatement("UPDATE RESERVACION SET Fecha_Inicial=? , "
                        + "Fecha_Final=?, Numero_Haibtacion=? WHERE ID_Cliente=? AND Fecha_Inicial=? "
                        + "AND Fecha_Final=? AND Estado=? AND Numero_Haibtacion=?");
                sentencia.setString(1, fechaInicialNueva);
                sentencia.setString(2, FechaFinalNueva);
                sentencia.setString(3, noHabitacionNueva);
                sentencia.setString(4, IDCliente);
                sentencia.setString(5, fechaInicialAnterior);
                sentencia.setString(6, FechaFinalAnterior);
                sentencia.setString(7, DefaultValues.HAB_RESERVADA_COD);
                sentencia.setString(8, noHabitacionAnterior);
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Crea la Reservacion pero sin ser confirmado el ingreso, simplemente es
     * una reservacion sin compromiso
     *
     * @param IDCliente
     * @param fechaInicial
     * @param fechaFinal
     * @param numeroHabitacion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean crearReservacion(String IDCliente, String fechaInicial, String fechaFinal, String numeroHabitacion) throws SQLException, InputsVaciosException {
        boolean IDClienteTry = IDCliente.replace(" ", "").isEmpty();
        boolean fechaInicialTry = fechaInicial.replace(" ", "").isEmpty();
        boolean fechaFinalTry = fechaFinal.replace(" ", "").isEmpty();
        boolean noHabtiacionTry = numeroHabitacion.replace(" ", "").isEmpty();

        try {
            if (IDClienteTry || fechaFinalTry || fechaInicialTry || noHabtiacionTry || (cantidadDelDias(fechaInicial, fechaFinal) < 0)) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                PreparedStatement sentencia = coneccion.prepareStatement("INSERT INTO RESERVACION "
                        + "(Fecha_Inicial, Fecha_Final, Estado, Numero_Haibtacion, ID_Cliente) VALUES (?,?,?,?,?)");
                sentencia.setString(1, fechaInicial);
                sentencia.setString(2, fechaFinal);
                sentencia.setString(3, DefaultValues.HAB_RESERVADA_COD);
                sentencia.setString(4, numeroHabitacion);
                sentencia.setString(5, IDCliente);
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    public List<Reservacion> busquedaPorIDClienteYEstado(String IDCliente, String estado) throws SQLException, InputsVaciosException {
        boolean IDtry = IDCliente.replace(" ", "").isEmpty();

        try {
            if (IDtry) {
                PreparedStatement sentencia = coneccion.prepareStatement("SELECT * FROM RESERVACION WHERE Estado=? ORDER BY Numero_Haibtacion");
                sentencia.setString(1, estado);
                return consultaReservacion(sentencia);
            } else {
                PreparedStatement sentencia = coneccion.prepareStatement("SELECT * FROM RESERVACION WHERE Estado=? AND ID_Cliente LIKE ? ORDER BY Numero_Haibtacion");
                sentencia.setString(1, estado);
                sentencia.setString(1, estado);
                return consultaReservacion(sentencia);
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    public List<Reservacion> busquedaTodosLasReservaciones() throws SQLException, InputsVaciosException {

        try {
            PreparedStatement sentencia = coneccion.prepareStatement("SELECT * FROM RESERVACION ORDER BY Numero_Haibtacion");
            return consultaReservacion(sentencia);

        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    private List<Reservacion> consultaReservacion(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        busquedaReservacion.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String fechaInicial = resultado.getString("Fecha_inicial");
                String fechaFinal = resultado.getString("Fecha_Final");
                String estado = resultado.getString("Estado");
                String pagoHabitacion = resultado.getString("Pago_Habitacion");
                String pagoRestaurante = resultado.getString("Pago_Restaurante");
                String noHabitacion = resultado.getString("Numero_Haibtacion");
                String IDCliente = resultado.getString("ID_Cliente");
                System.out.println("Reservacion: " + fechaInicial + "," + fechaFinal + "," + estado + "," + pagoHabitacion + "," + pagoRestaurante + "," + noHabitacion + "," + IDCliente);
                busquedaReservacion.add(new Reservacion(noHabitacion, IDCliente, fechaInicial, fechaFinal, estado, pagoHabitacion, pagoRestaurante));
            }
            System.out.println("``````````````````````````````````````````````````````");
            resultado.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaReservacion;
    }

    /**
     * Obteine la cantidad de dia que existe entre ambas fechas
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public int cantidadDelDias(String fechaInicial, String fechaFinal) throws SQLException, InputsVaciosException {
        int dias = 0;
        try {
            String query = ("SELECT DATEDIFF(?,?) AS CantDias");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, fechaFinal);
            objeto.setString(2, fechaInicial);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                dias = resultado.getInt("CantDias");
            }
            return dias;

        } catch (SQLException e) {
            System.out.println("Error al obtener la fecha");
        }
        return dias;
    }
}
