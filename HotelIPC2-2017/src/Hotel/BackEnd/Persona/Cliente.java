package Hotel.BackEnd.Persona;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author angelrg
 */
public class Cliente extends Persona implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String ID;
    private String NIT;
    private String direccion;
    private String phone;

    public static final String PROP_ID = "ID";
    public static final String PROP_NIT = "NIT";
    public static final String PROP_DIRECCION = "direccion";
    public static final String PROP_PHONE = "phone";

    public Cliente(String ID, String NIT, String nombre, String direccion, String phone) {
        super(nombre);
        this.ID = ID;
        this.NIT = NIT;
        this.direccion = direccion;
        this.phone = phone;
    }

    public Cliente() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        String oldID = this.ID;
        this.ID = ID;
        propertySupport.firePropertyChange(PROP_ID, oldID, ID);
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        String oldNIT = this.NIT;
        this.NIT = NIT;
        propertySupport.firePropertyChange(PROP_NIT, oldNIT, NIT);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        propertySupport.firePropertyChange(PROP_DIRECCION, oldDireccion, direccion);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        propertySupport.firePropertyChange(PROP_PHONE, oldPhone, phone);
    }

    public Cliente clone() {
        return new Cliente(this.ID, this.NIT, this.nombre, this.direccion, this.phone);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
