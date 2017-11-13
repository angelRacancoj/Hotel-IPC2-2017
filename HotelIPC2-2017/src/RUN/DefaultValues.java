/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUN;

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

}
