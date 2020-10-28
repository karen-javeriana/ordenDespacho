/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.ws.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Request servicio solicitud cotizacion
 *
 * @author Karen Calderon R
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CotizacionRequest {

    @XmlElement(name = "numeroCotizacion")
    private String numeroCotizacion;
    @XmlElement(name = "valor")
    private String valor;
    @XmlElement(name = "idSolicitudCotizacion")
    private String idSolicitudCotizacion;
    @XmlElement(name = "idProveedor")
    private String idProveedor;
    @XmlElement(name = "idTipoEnvio")
    private String idTipoEnvio;
    @XmlElement(name = "idEstadoCotizacion")
    private String idEstadoCotizacion;

    public CotizacionRequest() {
    }

    public CotizacionRequest(String numeroCotizacion, String valor, String idSolicitudCotizacion, String idProveedor, String idTipoEnvio, String idEstadoCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
        this.valor = valor;
        this.idSolicitudCotizacion = idSolicitudCotizacion;
        this.idProveedor = idProveedor;
        this.idTipoEnvio = idTipoEnvio;
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public String getIdEstadoCotizacion() {
        return idEstadoCotizacion;
    }

    public void setIdEstadoCotizacion(String idEstadoCotizacion) {
        this.idEstadoCotizacion = idEstadoCotizacion;
    }

    public String getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(String numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIdSolicitudCotizacion() {
        return idSolicitudCotizacion;
    }

    public void setIdSolicitudCotizacion(String idSolicitudCotizacion) {
        this.idSolicitudCotizacion = idSolicitudCotizacion;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdTipoEnvio() {
        return idTipoEnvio;
    }

    public void setIdTipoEnvio(String idTipoEnvio) {
        this.idTipoEnvio = idTipoEnvio;
    }

}
