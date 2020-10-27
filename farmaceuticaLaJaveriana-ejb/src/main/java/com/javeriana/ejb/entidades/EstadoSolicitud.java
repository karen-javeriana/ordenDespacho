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
@Table(name = "estado_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoSolicitud.findAll", query = "SELECT e FROM EstadoSolicitud e")
    , @NamedQuery(name = "EstadoSolicitud.findByIdEstadoSolicitud", query = "SELECT e FROM EstadoSolicitud e WHERE e.idEstadoSolicitud = :idEstadoSolicitud")
    , @NamedQuery(name = "EstadoSolicitud.findByTipoEstadoSolicitud", query = "SELECT e FROM EstadoSolicitud e WHERE e.tipoEstadoSolicitud = :tipoEstadoSolicitud")})
public class EstadoSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_solicitud")
    private Integer idEstadoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_estado_solicitud")
    private String tipoEstadoSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoSolicitud", fetch = FetchType.LAZY)
    private List<SolicitudCotizacionManual> solicitudCotizacionList;

    public EstadoSolicitud() {
    }

    public EstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public EstadoSolicitud(Integer idEstadoSolicitud, String tipoEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
        this.tipoEstadoSolicitud = tipoEstadoSolicitud;
    }

    public Integer getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public String getTipoEstadoSolicitud() {
        return tipoEstadoSolicitud;
    }

    public void setTipoEstadoSolicitud(String tipoEstadoSolicitud) {
        this.tipoEstadoSolicitud = tipoEstadoSolicitud;
    }

    @XmlTransient
    @JsonIgnore
    public List<SolicitudCotizacionManual> getSolicitudCotizacionList() {
        return solicitudCotizacionList;
    }

    public void setSolicitudCotizacionList(List<SolicitudCotizacionManual> solicitudCotizacionList) {
        this.solicitudCotizacionList = solicitudCotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoSolicitud != null ? idEstadoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSolicitud)) {
            return false;
        }
        EstadoSolicitud other = (EstadoSolicitud) object;
        if ((this.idEstadoSolicitud == null && other.idEstadoSolicitud != null) || (this.idEstadoSolicitud != null && !this.idEstadoSolicitud.equals(other.idEstadoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.EstadoSolicitud[ idEstadoSolicitud=" + idEstadoSolicitud + " ]";
    }
    
}
