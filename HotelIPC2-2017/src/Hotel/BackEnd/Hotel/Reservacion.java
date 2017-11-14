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
    private String fechaInicial;
    private String fechaFinal;
    private String estado;
    private String pagoHabitacion;
    private String pagoRestaurante;

    public static final String PROP_NO_HAB = "NoHabitacion";
    public static final String PROP_ID_CLIENTE = "IDCliente";
    public static final String PROP_FECHA_INICIAL = "fechaInicial";
    public static final String PROP_FECHA_FINAL = "fechaFinal";
    public static final String PROP_ESTADO = "estado";
    public static final String PROP_PAGO_HABITACION = "pagoHabitacion";
    public static final String PROP_PAGO_RESTAURANTE = "pagoRestaurante";

    public Reservacion(String NoHabitacion, String IDCliente, String fechaInicial, String fechaFinal, String estado, String pagoHabitacion, String pagoRestaurante) {
        this.NoHabitacion = NoHabitacion;
        this.IDCliente = IDCliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.pagoHabitacion = pagoHabitacion;
        this.pagoRestaurante = pagoRestaurante;
    }

    public Reservacion() {
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
        String oldFechaFinal = this.fechaFinal;
        this.fechaFinal = fechaFinal;
        propertySupport.firePropertyChange(PROP_FECHA_FINAL, oldFechaFinal, fechaFinal);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        propertySupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }

    public String getPagoHabitacion() {
        return pagoHabitacion;
    }

    public void setPagoHabitacion(String pagoHabitacion) {
        String oldPago = this.pagoHabitacion;
        this.pagoHabitacion = pagoHabitacion;
        propertySupport.firePropertyChange(PROP_PAGO_HABITACION, oldPago, pagoHabitacion);
    }

    public String getPagoRestaurante() {
        return pagoRestaurante;
    }

    public void setPagoRestaurante(String pagoRestaurante) {
        String oldPago = this.pagoRestaurante;
        this.pagoRestaurante = pagoRestaurante;
        propertySupport.firePropertyChange(PROP_PAGO_RESTAURANTE, oldPago, pagoRestaurante);
    }

    public Reservacion clone() {
        return new Reservacion(this.NoHabitacion, this.IDCliente, this.fechaInicial, this.fechaFinal, this.estado, this.pagoHabitacion, this.pagoRestaurante);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
