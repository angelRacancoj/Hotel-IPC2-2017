/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUN;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author angelrg
 */
public class DefaultValues {

    //informacion sobre los cargos en el hotel
    public static final String CARGO_RECEPCION_ID = "1";
    public static final String CARGO_RESTAURANTE_ID = "2";
    public static final String CARGO_GERENTE_ID = "3";
    public static final String CARGO_RECEPCION_NOMBRE = "Recepcion";
    public static final String CARGO_RESTAURANTE_NOMBRE = "Restaurante";
    public static final String CARGO_GERENTE_NOMBRE = "Gerente";

    //informacion de las habitaciones
    public static final String TIPO_JUNIOR_ID = "1";
    public static final String TIPO_MASTER_ID = "2";
    public static final String TIPO_DELUXE_ID = "3";
    public static final String TIPO_JUNIOR_NOMBRE = "Junior";
    public static final String TIPO_MASTER_NOMBRE = "Master";
    public static final String TIPO_DELUXE_NOMBRE = "Deluxe";

    //confirmacion de alimentos disponibles
    public static final String DISPONIBLE_SI = "1";
    public static final String DISPONIBLE_NO = "0";

    public static final String DISPONIBLE_TODO_COMBO_BOX = "0";
    public static final String DISPONIBLE_SI_COMBO_BOX = "1";
    public static final String DISPONIBLE_NO_COMBO_BOX = "2";

    //Estados de las habitaciones
    //cuando solo es una reservacion si confirmar no se genera un total
    public static final String HAB_RESERVADA_COD = "1";
    public static final String HAB_RERSERVADA = "Reservada";
    //Debe estar pagada la habitacion
    public static final String HAB_OCUPADA_COD = "2";
    public static final String HAB_OCUPADA = "Ocupada";
    //la reservacion ya no sera util
    public static final String HAB_ELIMINADA_COD = "3";
    public static final String HAB_ELIMINADA = "Eliminada";
    //el cliente ya se retiro, por lo tanto ya no genera consumos
    public static final String HAB_CHECK_OUT_COD = "4";
    public static final String HAB_CHECK_OUT = "CheckOut";

    public static final String HAB_TODO_COMBO_BOX = "0";
    public static final String HAB_RESERVADA_COMBO_BOX = "1";
    public static final String HAB_OCUPADA_COMBO_BOX = "2";
    public static final String HAB_ELIMINADA_COMBO_BOX = "3";
    
    //para los pagos
    public static final String PAGO_ALOJAMIENTO = "1";
    public static final String PAGO_SIN_RESERVACION = "2";
    public static final String PAGO_ALIMENTO = "3";

    // numeracion habitaciones
    /**
     * Verifica que el texto de entrada como fecha sea valido, devuelve true al
     * validarse
     *
     * @param fecha
     * @return
     */
    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
