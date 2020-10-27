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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Ciudad.findByCodigoCiudad", query = "SELECT c FROM Ciudad c WHERE c.codigoCiudad = :codigoCiudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_ciudad")
    private String codigoCiudad;

    public Ciudad() {
    }

    public Ciudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public Ciudad(String codigoCiudad, String nombre) {
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCiudad != null ? codigoCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codigoCiudad == null && other.codigoCiudad != null) || (this.codigoCiudad != null && !this.codigoCiudad.equals(other.codigoCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.Ciudad[ codigoCiudad=" + codigoCiudad + " ]";
    }

}
