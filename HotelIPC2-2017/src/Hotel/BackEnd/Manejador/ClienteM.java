package Hotel.BackEnd.Manejador;

import RUN.DefaultValues;
import java.sql.Connection;

/**
 *
 * @author angelrg
 */
public class ClienteM {
    private DefaultValues valoresPre;
    private Connection conexion;

    public ClienteM(Connection conexion) {
        this.conexion = conexion;
    }
    
    
}
