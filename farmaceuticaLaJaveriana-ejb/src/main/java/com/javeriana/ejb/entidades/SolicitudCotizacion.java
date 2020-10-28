/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "solicitud_cotizacion")
@XmlRootElement
public class SolicitudCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud_cotizacion")
    private Integer idSolicitudCotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_finalizacion_proveedor")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacionProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_finalizacion_cliente")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacionCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_orden")
    private int numeroOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private float peso;

    public SolicitudCotizacion() {
    }

    public SolicitudCotizacion(Integer idSolicitudCotizacion) {
        this.idSolicitudCotizacion = idSolicitudCotizacion;
    }

    public SolicitudCotizacion(Integer idSolicitudCotizacion, Date fechaCreacion, Date fechaFinalizacionProveedor, Date fechaFinalizacionCliente, int numeroOrden, float peso) {
        this.idSolicitudCotizacion = idSolicitudCotizacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacionProveedor = fechaFinalizacionProveedor;
        this.fechaFinalizacionCliente = fechaFinalizacionCliente;
        this.numeroOrden = numeroOrden;
        this.peso = peso;
    }

    public Integer getIdSolicitudCotizacion() {
        return idSolicitudCotizacion;
    }

    public void setIdSolicitudCotizacion(Integer idSolicitudCotizacion) {
        this.idSolicitudCotizacion = idSolicitudCotizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaFinalizacionProveedor() {
        return fechaFinalizacionProveedor;
    }

    public void setFechaFinalizacionProveedor(Date fechaFinalizacionProveedor) {
        this.fechaFinalizacionProveedor = fechaFinalizacionProveedor;
    }

    public Date getFechaFinalizacionCliente() {
        return fechaFinalizacionCliente;
    }

    public void setFechaFinalizacionCliente(Date fechaFinalizacionCliente) {
        this.fechaFinalizacionCliente = fechaFinalizacionCliente;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudCotizacion != null ? idSolicitudCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCotizacion)) {
            return false;
        }
        SolicitudCotizacion other = (SolicitudCotizacion) object;
        if ((this.idSolicitudCotizacion == null && other.idSolicitudCotizacion != null) || (this.idSolicitudCotizacion != null && !this.idSolicitudCotizacion.equals(other.idSolicitudCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.SolicitudCotizacion[ idSolicitudCotizacion=" + idSolicitudCotizacion + " ]";
    }

}
