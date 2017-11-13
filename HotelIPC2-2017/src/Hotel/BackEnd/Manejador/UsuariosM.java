package Hotel.BackEnd.Manejador;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Persona.User;
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
public class UsuariosM {

    private DefaultValues valoresPre;
    private Connection conexion;

    List<User> busquedaUsuarios = new ArrayList<>();

    public UsuariosM(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Valida las credenciales de los usuarios, para que estos puedan trabajar
     * dentro del programa User=nombre del usuario y contrasena=es el password
     * del usuario
     *
     * @param user
     * @param contrasena
     * @return
     * @throws InputsVaciosException
     */
    public String iniciar(String user, String contrasena) throws InputsVaciosException, SQLException {
        busquedaUsuarios.clear();
        boolean userTry = user.replace(" ", "").isEmpty();
        boolean contraseniaTry = contrasena.replace(" ", "").isEmpty();

        try {
            if (userTry) {
                throw new InputsVaciosException("Debe ingresar su Usuario");
            } else if (contraseniaTry) {
                throw new InputsVaciosException("debe ingresar su contraseña");
            } else if (contraseniaTry && userTry) {
                throw new InputsVaciosException("Debe ingresar su Usuario y Contraseña");
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM USER WHERE Nombre=? AND Contrasenia=?");
                sentencia.setString(1, user);
                sentencia.setString(2, contrasena);

                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    String nombre = resultado.getString("Nombre");
                    String contra = resultado.getString("Contrasenia");
                    String rango = resultado.getString("Rango");
                    System.out.println("Datos: " + nombre + "," + contra + "," + rango);
                    busquedaUsuarios.add(new User(nombre, contra, rango));

                    if (!busquedaUsuarios.isEmpty()) {
                        return rango;
                    }else{
                       throw new InputsVaciosException("No existe el usuario"); 
                    }
                }
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return null;
    }

    /**
     * Agrega al usuario con los datos de entrada
     *
     * @param nombreUser
     * @param constra
     * @param rango
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean agregarUsuario(String nombreUser, String constra, String rango) throws SQLException, InputsVaciosException {
        try {
            if (busqueda(nombreUser, "").isEmpty()) {
                PreparedStatement sentencia = conexion.prepareStatement("INSERTE INTO USER (Nombre,Contrasenia,Rango) VALUES (?,?,?)");
                sentencia.setString(1, nombreUser);
                sentencia.setString(2, constra);
                sentencia.setString(3, rango);
                if (sentencia.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new InputsVaciosException("Ya existe el Usuario");
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Elimina al usuario utilizando el nombre de este
     *
     * @param nombreUser
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean eliminarUsuario(String nombreUser) throws SQLException, InputsVaciosException {
        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM USER WHERE Nombre=? LIMIT 1");
            sentencia.setString(1, nombreUser);
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
     * permite buscar similitudes en los nombre, tambien en base al rango y
     * ambos, si no hay datos de entrada lanza todos los usuarios
     *
     * @param nombre
     * @param rango
     * @return
     * @throws InputsVaciosException
     * @throws SQLException
     */
    public List<User> busqueda(String nombre, String rango) throws InputsVaciosException, SQLException {
        boolean nombreTry = nombre.replace(" ", "").isEmpty();
        boolean rangoTry = rango.replace(" ", "").isEmpty();

        try {
            if (rangoTry && nombreTry) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM USER ORDER BY Nombre ASC");
                List userList = consultaUsuarios(sentencia);
                return userList;
            } else if (rangoTry) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM USER WHERE Nombre LIKE ? ORDER BY Nombre ASC");
                sentencia.setString(1, nombre);
                List userList = consultaUsuarios(sentencia);
                return userList;
            } else if (nombreTry) {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM USER WHERE Rango=? ORDER BY Nombre ASC");
                sentencia.setString(1, rango);
                List userList = consultaUsuarios(sentencia);
                return userList;
            } else {
                PreparedStatement sentencia = conexion.prepareStatement("SELECT *FROM USER WHERE Nombre LIKE ? AND Rango=? ORDER BY Nombre ASC");
                sentencia.setString(1, nombre);
                sentencia.setString(2, rango);
                List userList = consultaUsuarios(sentencia);
                return userList;
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
    }

    /**
     * Se encarga de cargar todos los elementos en el listado
     *
     * @param sentencia
     * @return
     * @throws InputsVaciosException
     * @throws SQLException
     */
    private List<User> consultaUsuarios(PreparedStatement sentencia) throws InputsVaciosException, SQLException {
        busquedaUsuarios.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String contra = resultado.getString("Contrasenia");
                String rango = resultado.getString("Rango");
                System.out.println("Datos: " + nombre + "," + contra + "," + rango);
                busquedaUsuarios.add(new User(nombre, contra, rango));
            }
            System.out.println("-----------------------------------------");
            resultado.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaUsuarios;
    }

    public List<User> getBusquedaUsuarios() {
        return busquedaUsuarios;
    }

    public void setBusquedaUsuarios(List<User> busquedaUsuarios) {
        this.busquedaUsuarios = busquedaUsuarios;
    }
}
