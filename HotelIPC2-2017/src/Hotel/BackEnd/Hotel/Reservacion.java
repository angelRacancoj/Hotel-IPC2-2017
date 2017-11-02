/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.BackEnd.Hotel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author angelrg
 */
public class Reservacion implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String NoHabitacion;
    private String IDCliente;
    private String NITCliente;
    private String fechaInicial;
    private String fechaFinal;
    private boolean pagado;

    public static final String PROP_NO_HAB = "NoHabitacion";
    public static final String PROP_ID_CLIENTE = "IDCliente";
    public static final String PROP_NIT_CLIENTE = "NITCliente";
    public static final String PROP_FECHA_INICIAL = "fechaInicial";
    public static final String PROP_FECHA_FINAL = "fechaFinal";

    public Reservacion(String NoHabitacion, String IDCliente, String NITCliente, String fechaInicial, String fechaFinal, boolean pagado) {
        this.NoHabitacion = NoHabitacion;
        this.IDCliente = IDCliente;
        this.NITCliente = NITCliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pagado = pagado;
    }

    public String getNoHabitacion() {
        return NoHabitacion;
    }

    public void setNoHabitacion(String NoHabitacion) {
        String oldNoHab = this.NoHabitacion;
        this.NoHabitacion = NoHabitacion;
        propertySupport.firePropertyChange(PROP_NO_HAB, oldNoHab, NoHabitacion);
    }

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        String oldID = this.IDCliente;
        this.IDCliente = IDCliente;
        propertySupport.firePropertyChange(PROP_ID_CLIENTE, oldID, IDCliente);
    }

    public String getNITCliente() {
        return NITCliente;
    }

    public void setNITCliente(String NITCliente) {
        String oldNIT = this.NITCliente;
        this.NITCliente = NITCliente;
        propertySupport.firePropertyChange(PROP_NIT_CLIENTE, oldNIT, NITCliente);
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        String oldFeInicial = this.fechaInicial;
        this.fechaInicial = fechaInicial;
        propertySupport.firePropertyChange(PROP_FECHA_INICIAL, oldFeInicial, fechaInicial);
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Reservacion clone() {
        return new Reservacion(this.NoHabitacion, this.IDCliente, this.NITCliente, this.fechaInicial, this.fechaFinal, this.pagado);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
