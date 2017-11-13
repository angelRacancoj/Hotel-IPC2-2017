package Hotel.BackEnd.Hotel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author angelrg
 */
public class Alimento implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String nombre;
    private String descripcion;
    private String precio;
    private boolean disponible;

    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_DESCRIPCION = "descripcion";
    public static final String PROP_PRECIO = "precio";

    public Alimento(String nombre, String descripcion, String precio, boolean disponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Alimento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String nombreAnt = this.nombre;
        this.nombre = nombre;
        propertySupport.firePropertyChange(PROP_NOMBRE, nombreAnt, nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String descripcionAnt = this.descripcion;
        this.descripcion = descripcion;
        propertySupport.firePropertyChange(PROP_DESCRIPCION, descripcionAnt, descripcion);
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        String precioAnt = this.precio;
        this.precio = precio;
        propertySupport.firePropertyChange(PROP_PRECIO, precioAnt, precio);
    }

    @Override
    public Alimento clone() {
        return new Alimento(this.nombre, this.descripcion, this.precio, this.disponible);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
