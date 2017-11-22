package Hotel.BackEnd.Manejador;

import Hotel.BackEnd.Excepciones.InputsVaciosException;
import Hotel.BackEnd.Hotel.Alimento;
import RUN.DefaultValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author angelrg
 */
public class AlimentoM {

    private Connection conexion;

    List<Alimento> busquedaAlimentos = new LinkedList<>();

    public AlimentoM(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Nos permite agregar nuevos alimentos a nuestra base de datos.
     *
     * @param nombre
     * @param precio
     * @param disponible
     * @param descripcion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean agregarAlimento(String nombre, String precio, String disponible, String descripcion) throws SQLException, InputsVaciosException {
        boolean nombreTry = nombre.replace(" ", "").isEmpty();
        boolean precioTry = precio.replace(" ", "").isEmpty();
        boolean descripcionTry = descripcion.replace(" ", "").isEmpty();

        try {
            if (nombreTry && precioTry && descripcionTry) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                if (busqueda(nombre, DefaultValues.DISPONIBLE_TODO_COMBO_BOX).isEmpty()) {
                    PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO ALIMENTOS (Nombre,Precio,Disponible,Descripcion) VALUES (?,?,?,?)");
                    sentencia.setString(1, nombre);
                    sentencia.setString(2, precio);
                    sentencia.setString(3, disponible);
                    sentencia.setString(4, descripcion);
                    if (sentencia.executeUpdate() == 1) {
                        sentencia.close();
                        return true;
                    } else {
                        sentencia.close();
                        return false;
                    }
                }
            }

        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return false;
    }

    /**
     * Se realizan cambios menores en el alimentos, de igual manera se verifica
     * la disponibilidad de estos
     *
     * @param nombreOld
     * @param nombreNew
     * @param precio
     * @param disponible
     * @param descripcion
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean actualizar(String nombreOld, String nombreNew, String precio, String disponible, String descripcion) throws SQLException, InputsVaciosException {
        PreparedStatement sentencia;

        try {
            if (busqueda(nombreOld, DefaultValues.DISPONIBLE_TODO_COMBO_BOX).isEmpty()) {
                throw new InputsVaciosException("No existe el Alimento que se desea Actualizar");
            } else {
                if (nombreOld.equalsIgnoreCase(nombreNew)) {
                    sentencia = conexion.prepareStatement("UPDATE ALIMENTOS SET Precio=? ,Disponible=? ,Descripcion=? WHERE Nombre=?");
                    sentencia.setString(1, precio);
                    sentencia.setString(2, disponible);
                    sentencia.setString(3, descripcion);
                    sentencia.setString(4, nombreOld);
                } else {
                    sentencia = conexion.prepareStatement("UPDATE ALIMENTOS SET Nombre=? ,Precio=? ,Disponible=? ,Descripcion=? WHERE Nombre=?");
                    sentencia.setString(1, nombreNew);
                    sentencia.setString(2, precio);
                    sentencia.setString(3, disponible);
                    sentencia.setString(4, descripcion);
                    sentencia.setString(5, nombreOld);
                }
                if (sentencia.executeUpdate() == 1) {
                    sentencia.close();
                    return true;
                } else {
                    sentencia.close();
                    return false;
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos al actualizar");
        }
    }

    /**
     * Nos permite generar listados en base a los dos paramentros utilizados
     *
     * @param nombre
     * @param disponibleComboBox
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Alimento> busqueda(String nombre, String disponibleComboBox) throws SQLException, InputsVaciosException {
        busquedaAlimentos.clear();
        boolean nombreTry = nombre.replace(" ", "").isEmpty();

        try {
            if (nombreTry) {
                if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_TODO_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS ORDER BY Nombre ASC");
                    return ConsultaAlimentos(sentencia);
                } else if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_SI_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Disponible=? ORDER BY Nombre ASC");
                    sentencia.setString(1, DefaultValues.DISPONIBLE_SI);
                    return ConsultaAlimentos(sentencia);
                } else if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_NO_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Disponible=? ORDER BY Nombre ASC");
                    sentencia.setString(1, DefaultValues.DISPONIBLE_NO);
                    return ConsultaAlimentos(sentencia);
                }
            } else {
                if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_TODO_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Nombre LIKE ? ORDER BY Nombre ASC");
                    sentencia.setString(1, nombre);
                    return ConsultaAlimentos(sentencia);
                } else if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_SI_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Disponible=? AND Nombre LIKE ? ORDER BY Nombre ASC");
                    sentencia.setString(1, DefaultValues.DISPONIBLE_SI);
                    sentencia.setString(2, nombre);
                    return ConsultaAlimentos(sentencia);
                } else if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_NO_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Disponible=? AND Nombre LIKE ? ORDER BY Nombre ASC");
                    sentencia.setString(1, DefaultValues.DISPONIBLE_NO);
                    sentencia.setString(2, nombre);
                    return ConsultaAlimentos(sentencia);
                }
            }
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaAlimentos;
    }

    private List<Alimento> ConsultaAlimentos(PreparedStatement sentencia) throws SQLException, InputsVaciosException {
        busquedaAlimentos.clear();
        boolean dispo = false;
        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String precio = resultado.getString("Precio");
                String disponible = resultado.getString("Disponible");
                if (disponible.equalsIgnoreCase(DefaultValues.DISPONIBLE_SI)) {
                    dispo = true;
                } else {
                    dispo = false;
                }
                String descripcion = resultado.getNString("Descripcion");
                System.out.println("Alimento: " + nombre + ", Q. " + precio + "," + disponible + "\n" + descripcion);
                busquedaAlimentos.add(new Alimento(nombre, descripcion, precio, dispo));
            }
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaAlimentos;
    }

    public List<Alimento> getBusquedaAlimentos() {
        return busquedaAlimentos;
    }

    public void setBusquedaAlimentos(List<Alimento> busquedaAlimentos) {
        this.busquedaAlimentos = busquedaAlimentos;
    }
}
