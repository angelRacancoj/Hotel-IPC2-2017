package Hotel.BackEnd.Hotel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author angelrg
 */
public class Consumo {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String nombreAlimento;
    private String Cantidad;
    private String Total;
    private String IDCliente;
    private String noHabitacion;

    private static final String PROP_NOMBRE_ALIMENTO = "nombreAlimento";
    private static final String PROP_CANTIDAD = "cantidad";
    private static final String PROP_TOTAL = "total";
    private static final String PROP_ID_CLIENTE = "IDCliente";
    private static final String PROP_NO_HABITACION = "noHabitacion";

    public Consumo(String nombreAlimento, String Cantidad, String Total, String IDCliente, String noHabitacion) {
        this.nombreAlimento = nombreAlimento;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.IDCliente = IDCliente;
        this.noHabitacion = noHabitacion;
    }

    public Consumo() {
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        String nombreAnterior = this.nombreAlimento;
        this.nombreAlimento = nombreAlimento;
        propertySupport.firePropertyChange(PROP_NOMBRE_ALIMENTO, nombreAnterior, nombreAlimento);
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        String cantidadAnterior = this.Cantidad;
        this.Cantidad = Cantidad;
        propertySupport.firePropertyChange(PROP_CANTIDAD, cantidadAnterior, Cantidad);
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        String totalAnt = this.Total;
        this.Total = Total;
        propertySupport.firePropertyChange(PROP_TOTAL, totalAnt, Total);
    }

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        String IDant = this.IDCliente;
        this.IDCliente = IDCliente;
        propertySupport.firePropertyChange(PROP_ID_CLIENTE, IDant, IDCliente);
    }

    public String getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(String noHabitacion) {
        String noHabAnt = this.noHabitacion;
        this.noHabitacion = noHabitacion;
        propertySupport.firePropertyChange(PROP_NO_HABITACION, noHabAnt, noHabitacion);
    }

    public Consumo clone() {
        return new Consumo(this.nombreAlimento, this.Cantidad, this.Total, this.IDCliente, this.noHabitacion);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
