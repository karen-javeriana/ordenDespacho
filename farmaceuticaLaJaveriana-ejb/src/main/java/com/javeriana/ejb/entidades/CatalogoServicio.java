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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "catalogo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoServicio.findAll", query = "SELECT c FROM CatalogoServicio c")
    , @NamedQuery(name = "CatalogoServicio.findByIdCatalogoServicio", query = "SELECT c FROM CatalogoServicio c WHERE c.idCatalogoServicio = :idCatalogoServicio")
    , @NamedQuery(name = "CatalogoServicio.findByNombre", query = "SELECT c FROM CatalogoServicio c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CatalogoServicio.findByPesoMinimo", query = "SELECT c FROM CatalogoServicio c WHERE c.pesoMinimo = :pesoMinimo")
    , @NamedQuery(name = "CatalogoServicio.findByPesoMaximo", query = "SELECT c FROM CatalogoServicio c WHERE c.pesoMaximo = :pesoMaximo")
    , @NamedQuery(name = "CatalogoServicio.findByValorPesoExtra", query = "SELECT c FROM CatalogoServicio c WHERE c.valorPesoExtra = :valorPesoExtra")
    , @NamedQuery(name = "CatalogoServicio.findByValorKiloInicial", query = "SELECT c FROM CatalogoServicio c WHERE c.valorKiloInicial = :valorKiloInicial")})
public class CatalogoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_catalogo_servicio")
    private Integer idCatalogoServicio;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_minimo")
    private Float pesoMinimo;
    @Column(name = "peso_maximo")
    private Float pesoMaximo;
    @Column(name = "valor_peso_extra")
    private Float valorPesoExtra;
    @Column(name = "valor_kilo_inicial")
    private Float valorKiloInicial;

    @Column(name = "id_proveedor")
    private Integer idProveedor;

    public CatalogoServicio() {
    }

    public CatalogoServicio(Integer idCatalogoServicio) {
        this.idCatalogoServicio = idCatalogoServicio;
    }

    public Integer getIdCatalogoServicio() {
        return idCatalogoServicio;
    }

    public void setIdCatalogoServicio(Integer idCatalogoServicio) {
        this.idCatalogoServicio = idCatalogoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(Float pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public Float getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(Float pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Float getValorPesoExtra() {
        return valorPesoExtra;
    }

    public void setValorPesoExtra(Float valorPesoExtra) {
        this.valorPesoExtra = valorPesoExtra;
    }

    public Float getValorKiloInicial() {
        return valorKiloInicial;
    }

    public void setValorKiloInicial(Float valorKiloInicial) {
        this.valorKiloInicial = valorKiloInicial;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalogoServicio != null ? idCatalogoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoServicio)) {
            return false;
        }
        CatalogoServicio other = (CatalogoServicio) object;
        if ((this.idCatalogoServicio == null && other.idCatalogoServicio != null) || (this.idCatalogoServicio != null && !this.idCatalogoServicio.equals(other.idCatalogoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javeriana.ejb.entidades.CatalogoServicio[ idCatalogoServicio=" + idCatalogoServicio + " ]";
    }

}
