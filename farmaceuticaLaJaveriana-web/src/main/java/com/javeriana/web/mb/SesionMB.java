/*
 *Farmaceutica la javeriana
 */
package com.javeriana.web.mb;

import com.javeriana.ejb.enumerados.ETipoNotificacion;
import com.javeriana.ejb.utilidades.DireccionesWeb;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;
import org.primefaces.PrimeFaces;

/**
 * Controlador de pantalla para la sesión y el login.
 *
 * @author Karen Calderon R
 */
@ManagedBean(name = "sesionMB")
@SessionScoped
public class SesionMB implements Serializable {

    private static final long serialVersionUID = -5904135379003560051L;
    private static final Logger LOG = Logger.getLogger(SesionMB.class.getName());

    private Boolean modalConsultasQDN = false;

    private boolean bandera;

    private String mensajeWarning;

    private String tituloMsj;

    private String claseMsj;

    private String msj;

    private String mensajeExcepcion;

    private final String versionProyecto = "V1.0";

    private boolean existeCliente;

    private String usuarioLogin;

    private String passLogin;

    private String urlRedireccionLogin = "";

    private String banderaServHdc;

    private ETipoNotificacion modalTypeNotificacion;

    public SesionMB() {
        inicializarSesionMB();
    }

    private void inicializarSesionMB() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        this.existeCliente = false;

    }

    /**
     * Ejecuta el inicio de sesion
     *
     * @return
     * @throws Exception
     */
    public String iniciarSesion() throws Exception {

        if (usuarioLogin.isEmpty() && passLogin.isEmpty()) {
            setMensajeWarning("Campo Usuario y Password obligatorios");
            setModalTypeNotificacion(ETipoNotificacion.ALERTA);
            PrimeFaces.current().executeScript("modalNotification()");
        } else if (usuarioLogin.isEmpty()) {
            setMensajeWarning("Campo Usuario obligatorio");
            setModalTypeNotificacion(ETipoNotificacion.ALERTA);
            PrimeFaces.current().executeScript("modalNotification()");
        } else if (passLogin.isEmpty()) {
            setMensajeWarning("Campo Password obligatorio");
            setModalTypeNotificacion(ETipoNotificacion.ALERTA);
            PrimeFaces.current().executeScript("modalNotification()");
        } else {
            return DireccionesWeb.INICIO;
        }
        return "";
    }

    /**
     * Finaliza la sesion del usuario actual
     *
     * @return
     */
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Object session = externalContext.getSession(false);
        HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().clear();
        } catch (Exception ex) {
        }
        PrimeFaces.current().executeScript("eliminarCookies()");
        return DireccionesWeb.LOGIN;
    }

    public Boolean getModalConsultasQDN() {
        return modalConsultasQDN;
    }

    public void setModalConsultasQDN(Boolean modalConsultasQDN) {
        this.modalConsultasQDN = modalConsultasQDN;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getMensajeWarning() {
        return mensajeWarning;
    }

    public void setMensajeWarning(String mensajeWarning) {
        this.mensajeWarning = mensajeWarning;
    }

    public String getTituloMsj() {
        return tituloMsj;
    }

    public void setTituloMsj(String tituloMsj) {
        this.tituloMsj = tituloMsj;
    }

    public String getClaseMsj() {
        return claseMsj;
    }

    public void setClaseMsj(String claseMsj) {
        this.claseMsj = claseMsj;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getMensajeExcepcion() {
        return mensajeExcepcion;
    }

    public void setMensajeExcepcion(String mensajeExcepcion) {
        this.mensajeExcepcion = mensajeExcepcion;
    }

    public boolean isExisteCliente() {
        return existeCliente;
    }

    public void setExisteCliente(boolean existeCliente) {
        this.existeCliente = existeCliente;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getPassLogin() {
        return passLogin;
    }

    public void setPassLogin(String passLogin) {
        this.passLogin = passLogin;
    }

    public String getUrlRedireccionLogin() {
        return urlRedireccionLogin;
    }

    public void setUrlRedireccionLogin(String urlRedireccionLogin) {
        this.urlRedireccionLogin = urlRedireccionLogin;
    }

    public String getBanderaServHdc() {
        return banderaServHdc;
    }

    public void setBanderaServHdc(String banderaServHdc) {
        this.banderaServHdc = banderaServHdc;
    }

    public ETipoNotificacion getModalTypeNotificacion() {
        return modalTypeNotificacion;
    }

    public void setModalTypeNotificacion(ETipoNotificacion modalTypeNotificacion) {
        this.modalTypeNotificacion = modalTypeNotificacion;
    }

}
