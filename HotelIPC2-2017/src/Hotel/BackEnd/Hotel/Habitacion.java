package Hotel.BackEnd.Hotel;

import RUN.DefaultValues;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author angelrg
 */
public class Habitacion implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String nombre;
    private String precio;

    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_PRECIO = "precio";

    public Habitacion(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Habitacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreTipo() {
        switch (nombre) {
            case DefaultValues.TIPO_DELUXE_ID:
                return DefaultValues.TIPO_DELUXE_NOMBRE;
            case DefaultValues.TIPO_JUNIOR_ID:
                return DefaultValues.TIPO_JUNIOR_NOMBRE;
            case DefaultValues.TIPO_MASTER_ID:
                return DefaultValues.TIPO_MASTER_NOMBRE;
        }
        return null;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertySupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        String oldPrecio = this.precio;
        this.precio = precio;
        propertySupport.firePropertyChange(PROP_PRECIO, oldPrecio, precio);
    }

    @Override
    public Habitacion clone() {
        return new Habitacion(this.nombre, this.precio);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
