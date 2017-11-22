package Hotel.BackEnd.Manejador;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Persona.Cliente;
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
public class ClienteM {

    private Connection conexion;

    List<Cliente> busquedaCllientes = new ArrayList<>();

    public ClienteM(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Permite modificar al cliente de ser necesarion (Funcion sin uso actual)
     * @param IDOriginal
     * @param ID
     * @param NIT
     * @param nombre
     * @param direccion
     * @param phone
     * @param cumpleanios
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean modificarCliente(String IDOriginal, String ID, String NIT, String nombre, String direccion, String phone, String cumpleanios)throws SQLException, InputsVaciosException{
        try {
            if (busqueda(IDOriginal).isEmpty()) {
                throw new InputsVaciosException("No existe el Cliente que se desea Actualizar");
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("UPDATE CLIENTE SET ID=?,NIT=?,Nombre=?,Direccion=?,Telefono=?,Cumpleanios=? WHERE ID=?");
                sentencia.setString(1, ID);
                sentencia.setString(2, NIT);
                sentencia.setString(3, nombre);
                sentencia.setString(4, direccion);
                sentencia.setString(5, phone);
                sentencia.setString(6, cumpleanios);
                sentencia.setString(7, IDOriginal);
                if (sentencia.executeUpdate() == 1) {
                    sentencia.close();
                    return true;
                } else {
                    sentencia.close();
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Debuelve true si el porceso de agregar al cliente es correcto
     * @param ID
     * @param NIT
     * @param nombre
     * @param direccion
     * @param phone
     * @param cumpleanios
     * @return
     * @throws InputsVaciosException
     * @throws SQLException
     */
    public boolean agregarCliente(String ID, String NIT, String nombre, String direccion, String phone, String cumpleanios) throws InputsVaciosException, SQLException {
        try {
            if (busqueda(ID).isEmpty()) {
                PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO CLIENTE (ID,NIT,Nombre,Direccion,Telefono,Cumpleanios) VALUES (?,?,?,?,?,?)");
                sentencia.setString(1, ID);
                sentencia.setString(2, NIT);
                sentencia.setString(3, nombre);
                sentencia.setString(4, direccion);
                sentencia.setString(5, phone);
                if (cumpleanios.replace(" ","").replace("-","").isEmpty()) {
                   sentencia.setString(6, null); 
                }else{
                    sentencia.setString(6, cumpleanios);
                }
                
                if (sentencia.executeUpdate() == 1) {
                    sentencia.close();
                    return true;
                } else {
                    sentencia.close();
                    return false;
                }
            } else {
                throw new InputsVaciosException("Ya existe el Cliente");
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos al agregar el Cliente");
        }
    }

    /**
     * Busca al cliente en base a su ID
     * @param ID
     * @return
     * @throws InputsVaciosException
     * @throws SQLException
     */
    public List<Cliente> busqueda(String ID) throws InputsVaciosException, SQLException {
        boolean IDtry = ID.replace(" ", "").isEmpty();
        try {
            if (IDtry) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM CLIENTE ORDER BY Nombre ASC");
                return consultaClientes(sentencia);
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM CLIENTE WHERE ID LIKE ? ORDER BY Nombre ASC");
                sentencia.setString(1, ID);
                return consultaClientes(sentencia);
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    private List<Cliente> consultaClientes(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        busquedaCllientes.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String ID = resultado.getString("ID");
                String NIT = resultado.getString("NIT");
                String nombre = resultado.getString("Nombre");
                String direccion = resultado.getString("Direccion");
                String telefono = resultado.getString("Telefono");
                String cumpleanios = resultado.getString("Cumpleanios");
                System.out.println("Cliente: " + ID + "," + NIT + "," + nombre + "," + direccion + "," + telefono + "," + cumpleanios);
                busquedaCllientes.add(new Cliente(ID, NIT, nombre, direccion, telefono, cumpleanios));
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaCllientes;
    }

    public List<Cliente> getBusquedaCllientes() {
        return busquedaCllientes;
    }

    public void setBusquedaCllientes(List<Cliente> busquedaCllientes) {
        this.busquedaCllientes = busquedaCllientes;
    }
}
