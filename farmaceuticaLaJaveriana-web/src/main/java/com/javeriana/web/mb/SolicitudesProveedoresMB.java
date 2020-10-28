/*
 *Farmaceutica la javeriana
 */
package com.javeriana.web.mb;

import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import com.javeriana.ejb.enumerados.ESeveridadMensaje;
import com.javeriana.ejb.service.SolicitudCotizacionSBLocal;
import com.javeriana.web.utilidades.Util;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Controlador de pantalla para menu
 *
 * @author Karen Calderon R
 */
@ManagedBean(name = "solicitudesProveedoresMB")
@ViewScoped
public class SolicitudesProveedoresMB extends BaseMB<SolicitudCotizacionManual> implements Serializable {

    //private ILogAuditoriaDao logAuditoriaDao;
    //private List<LogAuditoria> showTableLogAuditoria;
    //  private List<LogAuditoria> showTableLogAuditoriaFilter;
    private String servicio;

    private String fase;

    @EJB(beanName = "BeanNameSolicitudesSB")
    private SolicitudCotizacionSBLocal solicitudSBLocal;

    private final String pattern_DD_MM_YYY_HH_MM_AAA = "dd/MM/yyyy  hh:mm aaa";
    private final String pattern_DD_MM_YY = "dd/MM/yyyy";
    private static final String CONSULTAR_LOG = "CONSULTAR_LOG_CRUD";

    @PostConstruct
    public void init() {
        try {
            //setPhase(EFase.QUERY);
            //setObject(new LogAuditoria());
            this.servicio = null;
            this.fase = "query";
        } catch (Exception ex) {
            //Util.showModalError(ex, MODULO);
        }
    }

    public void enviarCancelar() {
//        processBefore();
//
//        this.servicio = null;
//        init();
//        limpiar();
    }

//    public void enviarConsulta(LogAuditoria log) {
//        try {
//            processEdit(log);
//            PrimeFaces.current().executeScript("setActiveTab('nav-detalle-tab')");
//
//            if (log.getResponse() != null) {
//                response = formatearJson(dataFileDao.getByID(log.getResponse()).getDataFile());
//            }
//            if (log.getRequest() != null) {
//                request = formatearJson(dataFileDao.getByID(log.getRequest()).getDataFile());
//            }
//            if (log.getError() != null) {
//                error = formatearJson(log.getError());
//            }
//
//        } catch (Exception ex) {
//            Util.showModalError(ex, MODULO);
//        }
//    }
    /**
     * envia a la pantalla de creación
     */
    public void enviarCrear() {
//        Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
//        Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
//        processCreate();
//        setObject(new LogAuditoria());
    }

//    public void buscarLogAuditoria() {
//        try {
//            showTableLogAuditoriaFilter = null;
//            String diasParaConsultar = parametrizacionSB.getValorParametrizacion(CONSULTAR_LOG);
//            this.fechaDesde = null;
//            this.fechaHasta = null;
//            boolean validDate = true;
//
//            try {
//                if (fechaDesdeStr != null && !fechaDesdeStr.equals("")) {
//                    fechaDesde = this.getDateFromString(fechaDesdeStr, ConstantesGenerales.FORMATO_FECHA_SLASH_DD_MM_YYYY_HH_MM);
//                }
//                if (fechaHastaStr != null && !fechaHastaStr.equals("")) {
//                    fechaHasta = this.getDateFromString(fechaHastaStr, ConstantesGenerales.FORMATO_FECHA_SLASH_DD_MM_YYYY_HH_MM);
//                }
//            } catch (ParseException ex) {
//                validDate = false;
//            }
//
//            if (funcion != null && funcion.trim().isEmpty()) {
//                funcion = null;
//            }
//            if (servicio != null && servicio.trim().isEmpty()) {
//                servicio = null;
//            }
//
//            if (!validDate) {
//                PrimeFaces.current().executeScript("mostrarToast('Es necesario diligenciar fechas y horas validas');");
//            } else if (idFront == null && fechaDesde == null && fechaHasta == null && funcion == null && servicio == null && funcion == null && servicio == null) {
//                PrimeFaces.current().executeScript("mostrarToast('Es necesario diligenciar algún campo para poder consultar');");
//            } else if (fechaDesde == null && fechaHasta != null) {
//                PrimeFaces.current().executeScript("mostrarToast('Es necesario diligenciar el campo de Fecha Inicio');");
//            } else if (fechaDesde != null && fechaHasta == null) {
//                PrimeFaces.current().executeScript("mostrarToast('Es necesario diligenciar el campo de Fecha Fin');");
//            } else {
//                boolean valid = true;
//                if (fechaDesde != null && fechaHasta != null) {
//                    long diffDays = ChronoUnit.DAYS.between(getLocalDate(fechaDesde), getLocalDate(fechaHasta));
//
//                    String inicio = new SimpleDateFormat(pattern_DD_MM_YY).format(fechaDesde);
//                    String fin = new SimpleDateFormat(pattern_DD_MM_YY).format(fechaHasta);
//
//                    if (fechaDesde.after(new Date())) {
//                        valid = false;
//                        PrimeFaces.current().executeScript("mostrarToast('Recuerda que la Fecha de Inicio no puede ser superior a la Fecha Actual ');");
//                    } else if (fechaHasta.after(new Date())) {
//                        valid = false;
//                        PrimeFaces.current().executeScript("mostrarToast('Recuerda que la Fecha Fin no puede ser superior a la Fecha Actual ');");
//                    } else if (!inicio.equals(fin) && !fechaHasta.after(fechaDesde)) {
//                        valid = false;
//                        PrimeFaces.current().executeScript("mostrarToast('Recuerda que la Fecha de Inicio debe ser menor o igual "
//                                + "a la Fecha de Fin, de lo contrario no se podrá realizar la busqueda ');");
//                    } else if (diasParaConsultar != null && diffDays > Long.parseLong(diasParaConsultar)) {
//                        valid = false;
//                        PrimeFaces.current().executeScript(String.format("mostrarToast('No es posible consultar más de %s días');", diasParaConsultar));
//                    }
//                }
//                if (valid) {
//                    showTableLogAuditoria = logAuditoriaDao.getFilterByfields(fechaDesde, fechaHasta, idFront, funcion, servicio);
//                }
//            }
//            Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
//        } catch (Exception ex) {
//            Util.showModalError(ex, MODULO);
//        }
//    }
    public void limpiar() throws Exception {
        Util.guardarNotificacionUsuarioSesion(null, Util.getSeveridadMensaje(ESeveridadMensaje.DEFAULT));
        solicitudSBLocal.getFilterByDate();
        this.servicio = null;
        //showTableLogAuditoria = null;
        // setObject(new LogAuditoria());
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
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
