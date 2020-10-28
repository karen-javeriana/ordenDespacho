/*
 *Farmaceutica la javeriana
 */
package com.javeriana.web.mb;

import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import com.javeriana.ejb.enumerados.ESeveridadMensaje;
import com.javeriana.ejb.service.SolicitudCotizacionSBLocal;
import com.javeriana.web.utilidades.Util;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Controlador de pantalla para menu
 *
 * @author Karen Calderon R
 */
@ManagedBean(name = "solicitudesClienteMB")
@ViewScoped
public class SolicitudesClienteMB extends BaseMB<SolicitudCotizacionManual> implements Serializable {

    private SolicitudCotizacionManual objetoEntidad;
    private List<SolicitudCotizacionManual> listSolicitudesCliente;
    private Date fechaInicio;
    private Date fechaFin;
    private String numeroOrden;
    private String fase;
    private String fechaInicioString;
    private String fechaFinString;

    @EJB(beanName = "BeanNameSolicitudesSB")
    private SolicitudCotizacionSBLocal solicitudSBLocal;

    private final String pattern_DD_MM_YYY_HH_MM_AAA = "dd/MM/yyyy  hh:mm";
    private final String pattern_DD_MM_YY = "dd/MM/yyyy";

    @PostConstruct
    public void init() {
        try {
            this.objetoEntidad = new SolicitudCotizacionManual();
            this.fase = "query";
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void enviarCancelar() throws Exception {
//        processBefore();

        limpiar();
    }

    /**
     * Metodo que ejecuta la accion de consultar, basado en los filtros
     *
     */
    public void enviarConsulta() {
        try {
            Date fechaInicioConv = null;
            Date fechaFinConv = null;
            if (fechaInicioString != null && !fechaInicioString.isEmpty()) {
                fechaInicioConv = new SimpleDateFormat(pattern_DD_MM_YYY_HH_MM_AAA).parse(fechaInicioString);
            }
            if (fechaFinString != null && !fechaFinString.isEmpty()) {
                fechaFinConv = new SimpleDateFormat(pattern_DD_MM_YYY_HH_MM_AAA).parse(fechaFinString);
            }
            listSolicitudesCliente = solicitudSBLocal.consultarPorTodosFiltros(numeroOrden, fechaInicioConv, fechaFinConv);
            Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**
     * Metodo que filtra los campos de busqueda
     *
     * @throws Exception
     */
    public void limpiar() throws Exception {
        objetoEntidad = new SolicitudCotizacionManual();
        this.numeroOrden = null;
        this.fechaFin = null;
        this.fechaInicio = null;
        this.fechaFinString = null;
        this.fechaInicioString = null;
        listSolicitudesCliente = new ArrayList<>();
    }

    public SolicitudCotizacionSBLocal getSolicitudSBLocal() {
        return solicitudSBLocal;
    }

    public void setSolicitudSBLocal(SolicitudCotizacionSBLocal solicitudSBLocal) {
        this.solicitudSBLocal = solicitudSBLocal;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public SolicitudCotizacionManual getObjetoEntidad() {
        return objetoEntidad;
    }

    public void setObjetoEntidad(SolicitudCotizacionManual objetoEntidad) {
        this.objetoEntidad = objetoEntidad;
    }

    public List<SolicitudCotizacionManual> getListSolicitudesCliente() {
        return listSolicitudesCliente;
    }

    public void setListSolicitudesCliente(List<SolicitudCotizacionManual> listSolicitudesCliente) {
        this.listSolicitudesCliente = listSolicitudesCliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaInicioString() {
        return fechaInicioString;
    }

    public void setFechaInicioString(String fechaInicioString) {
        this.fechaInicioString = fechaInicioString;
    }

    public String getFechaFinString() {
        return fechaFinString;
    }

    public void setFechaFinString(String fechaFinString) {
        this.fechaFinString = fechaFinString;
    }

    @Override
    public void processComplete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
