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

    private DefaultValues valoresPre;
    private Connection conexion;

    List<Alimento> busquedaAlimentos = new LinkedList<>();

    public AlimentoM(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean agregarAlimento(String nombre, String precio, String disponible, String descripcion) throws SQLException, InputsVaciosException {
        boolean nombreTry = nombre.replace(" ", "").isEmpty();
        boolean precioTry = precio.replace(" ", "").isEmpty();
        boolean descripcionTry = descripcion.replace(" ", "").isEmpty();

        try {
            if (nombreTry && precioTry && descripcionTry) {
                throw new InputsVaciosException("Debe llenar todos los campos");
            } else {
                if (busqueda(nombre, DefaultValues.DISPONIBLE_TODO_COMBO_BOX).isEmpty()) {
                    PreparedStatement sentencia = conexion.prepareStatement("INSETR INTO ALIMENTOS (Nombre,Precio,Disponible,Descripcion) VALUES (?,?,?,?)");
                    sentencia.setString(1, nombre);
                    sentencia.setString(2, precio);
                    sentencia.setString(3, disponible);
                    sentencia.setString(4, descripcion);
                    if (sentencia.executeUpdate() == 1) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return false;
    }
    
    public boolean actualizar(String nombreOld, String nombreNew, String precio, String disponible, String descripcion)throws SQLException, InputsVaciosException{
        try {
            if (busqueda(nombreOld, DefaultValues.DISPONIBLE_TODO_COMBO_BOX).isEmpty()) {
                throw new InputsVaciosException("No existe el Alimento que se desea Actualizar");
            }else{
                PreparedStatement sentencia = conexion.prepareStatement("UPDATE ALIMENTO SET Nombre=? ,Precio=? ,Disponible=? ,Descripcion=? WHERE Nombre=?");
                sentencia.setString(1, nombreNew);
                sentencia.setString(2, precio);
                sentencia.setString(3, disponible);
                sentencia.setString(4, descripcion);
                sentencia.setString(5, nombreOld);
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
                    return ConsultaAlimentos(sentencia);
                } else if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_SI_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Disponible=? AND Nombre LIKE ? ORDER BY Nombre ASC");
                    sentencia.setString(1, DefaultValues.DISPONIBLE_SI);
                    return ConsultaAlimentos(sentencia);
                } else if (disponibleComboBox.equals(DefaultValues.DISPONIBLE_NO_COMBO_BOX)) {
                    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM ALIMENTOS WHERE Disponible=? AND Nombre LIKE ? ORDER BY Nombre ASC");
                    sentencia.setString(1, DefaultValues.DISPONIBLE_NO);
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

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String precio = resultado.getString("Precio");
                String disponible = resultado.getString("Disponible");
                String descripcion = resultado.getString("Descripcion");
                System.out.println("Alimento: " + nombre + ", Q. " + precio + "," + disponible + "\n" + descripcion);
                busquedaAlimentos.add(new Alimento(nombre, descripcion, precio, Boolean.parseBoolean(disponible)));
            }
        } catch (SQLException e) {
            throw new InputsVaciosException("Error en la Base de Datos");
        }
        return busquedaAlimentos;
    }

}
