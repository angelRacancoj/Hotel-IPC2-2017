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

    List<Reservacion> busquedaReservacion = new ArrayList<>();

    public ReservarHabitacionM(Connection coneccion) {
        this.coneccion = coneccion;
    }
    
    public List<Reservacion> busquedaPorIDCliente (String IDCliente,String estado)throws SQLException, InputsVaciosException{
        boolean IDtry = IDCliente.replace(" ","").isEmpty();
        
        try {
            if (IDtry) {
                PreparedStatement sentencia = coneccion.prepareStatement("SELECT * FROM RESERVACIONES WHERE Estado=? ORDER BY ");
                sentencia.setString(1, estado);
                return consultaReservacion(sentencia);
            } else{
                PreparedStatement sentencia = coneccion.prepareStatement("SELECT * FROM RESERVACIONES WHERE Estado=? AND ID_Cliente LIKE ? ORDER BY ");
                sentencia.setString(1, estado);
                sentencia.setString(1, estado);
                return consultaReservacion(sentencia);
            }
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
                System.out.println("Reservacion: "+fechaInicial+","+fechaFinal+","+estado+","+pagoHabitacion+","+pagoRestaurante+","+noHabitacion+","+IDCliente);
                busquedaReservacion.add(new Reservacion(noHabitacion, IDCliente, fechaInicial, fechaFinal, estado, pagoHabitacion, pagoRestaurante));
            }
            System.out.println("``````````````````````````````````````````````````````");
            resultado.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaReservacion;
    }

}
