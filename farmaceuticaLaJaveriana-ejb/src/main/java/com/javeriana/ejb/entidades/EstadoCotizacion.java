/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "estado_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCotizacion.findAll", query = "SELECT e FROM EstadoCotizacion e")
    , @NamedQuery(name = "EstadoCotizacion.findByIdEstadoCotizacion", query = "SELECT e FROM EstadoCotizacion e WHERE e.idEstadoCotizacion = :idEstadoCotizacion")
    , @NamedQuery(name = "EstadoCotizacion.findByTipoEstado", query = "SELECT e FROM EstadoCotizacion e WHERE e.tipoEstado = :tipoEstado")})
public class EstadoCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_cotizacion")
    private Integer idEstadoCotizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_estado")
    private String tipoEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCotizacion", fetch = FetchType.LAZY)
    private List<Cotizacion> cotizacionList;

    public EstadoCotizacion() {
    }

    public EstadoCotizacion(Integer idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public EstadoCotizacion(Integer idEstadoCotizacion, String tipoEstado) {
        this.idEstadoCotizacion = idEstadoCotizacion;
        this.tipoEstado = tipoEstado;
    }

    public Integer getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(Integer idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    @XmlTransient
    @JsonIgnore
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCotizacion != null ? idEstadoCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCotizacion)) {
            return false;
        }
        EstadoCotizacion other = (EstadoCotizacion) object;
        if ((this.idEstadoCotizacion == null && other.idEstadoCotizacion != null) || (this.idEstadoCotizacion != null && !this.idEstadoCotizacion.equals(other.idEstadoCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.EstadoCotizacion[ idEstadoCotizacion=" + idEstadoCotizacion + " ]";
    }
    
}
