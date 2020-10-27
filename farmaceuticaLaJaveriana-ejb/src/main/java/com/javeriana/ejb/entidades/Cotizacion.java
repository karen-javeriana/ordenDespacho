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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NotNull
    @Column(name = "id_cotizacion")
    private Integer idCotizacion;
    @Column(name = "numero_cotizacion")
    private Integer numeroCotizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @JoinColumn(name = "id_estado_cotizacion", referencedColumnName = "id_estado_cotizacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoCotizacion idEstadoCotizacion;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor idProveedor;
    @JoinColumn(name = "id_solicitud_cotizacion", referencedColumnName = "id_solicitud_cotizacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SolicitudCotizacionManual idSolicitudCotizacion;
    @JoinColumn(name = "id_tipo_envio", referencedColumnName = "id_tipo_envio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEnvio idTipoEnvio;

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

    public EstadoCotizacion getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(EstadoCotizacion idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public SolicitudCotizacionManual getIdSolicitudCotizacion() {
        return idSolicitudCotizacion;
    }

    public void setIdSolicitudCotizacion(SolicitudCotizacionManual idSolicitudCotizacion) {
        this.idSolicitudCotizacion = idSolicitudCotizacion;
    }

    public TipoEnvio getIdTipoEnvio() {
        return idTipoEnvio;
    }

    public void setIdTipoEnvio(TipoEnvio idTipoEnvio) {
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
