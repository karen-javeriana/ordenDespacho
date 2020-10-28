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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipo_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEnvio.findAll", query = "SELECT t FROM TipoEnvio t")
    , @NamedQuery(name = "TipoEnvio.findByIdTipoEnvio", query = "SELECT t FROM TipoEnvio t WHERE t.idTipoEnvio = :idTipoEnvio")
    , @NamedQuery(name = "TipoEnvio.findByNombre", query = "SELECT t FROM TipoEnvio t WHERE t.nombre = :nombre")})
public class TipoEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_envio")
    private Integer idTipoEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;

    public TipoEnvio() {
    }

    public TipoEnvio(Integer idTipoEnvio) {
        this.idTipoEnvio = idTipoEnvio;
    }

    public TipoEnvio(Integer idTipoEnvio, String nombre) {
        this.idTipoEnvio = idTipoEnvio;
        this.nombre = nombre;
    }

    public Integer getIdTipoEnvio() {
        return idTipoEnvio;
    }

    public void setIdTipoEnvio(Integer idTipoEnvio) {
        this.idTipoEnvio = idTipoEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEnvio != null ? idTipoEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEnvio)) {
            return false;
        }
        TipoEnvio other = (TipoEnvio) object;
        if ((this.idTipoEnvio == null && other.idTipoEnvio != null) || (this.idTipoEnvio != null && !this.idTipoEnvio.equals(other.idTipoEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.TipoEnvio[ idTipoEnvio=" + idTipoEnvio + " ]";
    }

}
