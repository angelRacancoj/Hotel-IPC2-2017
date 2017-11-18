package Hotel.BackEnd.Persona;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import RUN.DefaultValues;

/**
 *
 * @author angelrg
 */
public class User extends Persona implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String password;
    private String rank;

    public static final String PROP_PASSWORD = "password";
    public static final String PROP_RANK = "rank";

    public User() {
    }

    public User(String nombre, String password, String rank) {
        super(nombre);
        this.password = password;
        this.rank = rank;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        propertySupport.firePropertyChange(PROP_PASSWORD, oldPassword, password);
    }

    public String getRank() {
        return rank;
    }
    
    public String getRankName() {
        switch(rank){
            case DefaultValues.CARGO_RECEPCION_ID:
                return DefaultValues.CARGO_RECEPCION_NOMBRE;
            case DefaultValues.CARGO_RESTAURANTE_ID:
                return DefaultValues.CARGO_RESTAURANTE_NOMBRE;
            case DefaultValues.CARGO_GERENTE_ID:
                return DefaultValues.CARGO_GERENTE_NOMBRE;
        }
        return null;
    }

    public void setRank(String rank) {
        String oldRank = this.rank; 
        this.rank = rank;
        propertySupport.firePropertyChange(PROP_RANK, oldRank, rank);
    }

    @Override
    public User clone() {
        return new User(this.nombre, this.password, this.rank);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
