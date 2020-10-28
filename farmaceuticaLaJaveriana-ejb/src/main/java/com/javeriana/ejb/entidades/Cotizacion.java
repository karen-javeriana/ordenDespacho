/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByIdCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idCotizacion = :idCotizacion")
    , @NamedQuery(name = "Cotizacion.findByNumeroCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.numeroCotizacion = :numeroCotizacion")
    , @NamedQuery(name = "Cotizacion.findByValor", query = "SELECT c FROM Cotizacion c WHERE c.valor = :valor")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "cWSequence", sequenceName = "SEQ_CUSTOM_WD")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cWSequence")
    @Column(name = "id_cotizacion")
    private Integer idCotizacion;

    @Column(name = "numero_cotizacion")
    private Integer numeroCotizacion;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "id_solicitud_cotizacion")
    private Integer idSolicitudCotizacion;

    @Column(name = "id_tipo_envio")
    private Integer idTipoEnvio;

    @Column(name = "id_estado_cotizacion")
    private Integer idEstadoCotizacion;

    public Cotizacion() {
    }

    public Cotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Integer getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(Integer numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(Integer idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdSolicitudCotizacion() {
        return idSolicitudCotizacion;
    }

    public void setIdSolicitudCotizacion(Integer idSolicitudCotizacion) {
        this.idSolicitudCotizacion = idSolicitudCotizacion;
    }

    public Integer getIdTipoEnvio() {
        return idTipoEnvio;
    }

    public void setIdTipoEnvio(Integer idTipoEnvio) {
        this.idTipoEnvio = idTipoEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.Cotizacion[ idCotizacion=" + idCotizacion + " ]";
    }

}
