/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;

/**
 * Entidad de la tabla solicitud cotizacion
 * @author Karen Calderon R
 */
@EqualsAndHashCode(of = "id", callSuper = false)
@Builder
@Entity
@Table(name = "solicitud_cotizacion")
@NamedQueries({
    @NamedQuery(name = "SolicitudCotizacion.consultarPorCliente",
            query = "SELECT c FROM SolicitudCotizacion c")

})
public class SolicitudCotizacion implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_solicitud_cotizacion")
    @SequenceGenerator(name = "solicitud_cotizacion_sq",
            sequenceName = "solicitud_cotizacion_sq", initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "solicitud_cotizacion_sq")
    private Long id;

    @Size(max = 50)
    @Column(name = "numero_orden")
    private Long numeroOrden;

    @Size(max = 50)
    @Column(name = "id_tipo_envio")
    private Long idTipoEnvio;

    @Size(max = 50)
    @Column(name = "id_estado_solicitud")
    private Long idEstadoSolicitud;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "codigo_ciudad_origen")
    private String codigoCiudadOrigen;

    @Column(name = "ciudad_codigo_destino")
    private String ciudadCodigoDestino;

    @Size(max = 50)
    @Column(name = "numero_documento_cliente")
    private Long numeroDocumentoCliente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_finalizacion_proveedor")
    private Date fechaFinalizacionProveedor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_finalizacion_cliente")
    private Date fechaFinalizacionCliente;

    public SolicitudCotizacion(Long id, Long numeroOrden, Long idTipoEnvio, Long idEstadoSolicitud, String direccion, String codigoCiudadOrigen, String ciudadCodigoDestino, Long numeroDocumentoCliente, Date fechaCreacion, Date fechaFinalizacionProveedor, Date fechaFinalizacionCliente, Double peso) {
        this.id = id;
        this.numeroOrden = numeroOrden;
        this.idTipoEnvio = idTipoEnvio;
        this.idEstadoSolicitud = idEstadoSolicitud;
        this.direccion = direccion;
        this.codigoCiudadOrigen = codigoCiudadOrigen;
        this.ciudadCodigoDestino = ciudadCodigoDestino;
        this.numeroDocumentoCliente = numeroDocumentoCliente;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacionProveedor = fechaFinalizacionProveedor;
        this.fechaFinalizacionCliente = fechaFinalizacionCliente;
        this.peso = peso;
    }

    public SolicitudCotizacion() {
    }

    @Column(name = "peso")
    private Double peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Long getIdTipoEnvio() {
        return idTipoEnvio;
    }

    public void setIdTipoEnvio(Long idTipoEnvio) {
        this.idTipoEnvio = idTipoEnvio;
    }

    public Long getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(Long idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(String codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public String getCiudadCodigoDestino() {
        return ciudadCodigoDestino;
    }

    public void setCiudadCodigoDestino(String ciudadCodigoDestino) {
        this.ciudadCodigoDestino = ciudadCodigoDestino;
    }

    public Long getNumeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public void setNumeroDocumentoCliente(Long numeroDocumentoCliente) {
        this.numeroDocumentoCliente = numeroDocumentoCliente;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

}
