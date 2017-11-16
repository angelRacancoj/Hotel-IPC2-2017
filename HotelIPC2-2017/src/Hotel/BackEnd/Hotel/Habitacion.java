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
    private String estado;

    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_PRECIO = "precio";
    public static final String PROP_ESTADO = "estado";

    public Habitacion(String nombre, String precio, String estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }
    
    public String getEstadoTipo() {
        switch (estado) {
            case DefaultValues.TIPO_DELUXE_ID:
                return DefaultValues.TIPO_DELUXE_NOMBRE;
            case DefaultValues.TIPO_JUNIOR_ID:
                return DefaultValues.TIPO_JUNIOR_NOMBRE;
            case DefaultValues.TIPO_MASTER_ID:
                return DefaultValues.TIPO_MASTER_NOMBRE;
        }
        return null;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        propertySupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }

    @Override
    public Habitacion clone() {
        return new Habitacion(this.nombre, this.precio, this.estado);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
