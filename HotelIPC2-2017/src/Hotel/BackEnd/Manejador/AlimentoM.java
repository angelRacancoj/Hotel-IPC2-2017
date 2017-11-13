/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.BackEnd.Manejador;

import RUN.DefaultValues;
import java.sql.Connection;

/**
 *
 * @author angelrg
 */
public class AlimentoM {
    private DefaultValues valoresPre;
    private Connection conexion;

    public AlimentoM(Connection conexion) {
        this.conexion = conexion;
    }
    
    
}
