/*
 *Farmaceutica la javeriana
 */
package com.javeriana.web.mb;

import com.javeriana.ejb.dao.impl.IUsuarioDao;
import com.javeriana.ejb.dto.usuarioDto;
import com.javeriana.ejb.entidades.Usuario;
import com.javeriana.ejb.enumerados.ETipoNotificacion;
import com.javeriana.ejb.enumerados.ETipoUsuario;
import com.javeriana.ejb.utilidades.DireccionesWeb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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

    private boolean bandera;

    private String mensajeWarning;

    private String tituloMsj;

    private String claseMsj;

    private String msj;

    private boolean existeCliente;

    private String urlRedireccionLogin = "";

    private usuarioDto usuarioDto;

    private Usuario entidadUsuario;

    private ETipoNotificacion modalTypeNotificacion;

    private String tipoUsuario;

    private List<ETipoUsuario> listTiposUsuarios;

    @EJB(beanName = "BeanNameUsuarioDao")
    private IUsuarioDao usuarioDao;

    public SesionMB() {
        inicializarSesionMB();
    }

    private void inicializarSesionMB() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        listTiposUsuarios = Arrays.asList(ETipoUsuario.values());
        this.existeCliente = false;
        usuarioDto = new usuarioDto();
        entidadUsuario = new Usuario();

    }

    /**
     * Ejecuta el inicio de sesion
     *
     * @return
     * @throws Exception
     */
    public String iniciarSesion() throws Exception {

        Usuario usuarioSesion = usuarioDao.consultarUsuario(usuarioDto.getUsuario(), usuarioDto.getPassword());

        if (usuarioSesion != null) {
            return DireccionesWeb.INICIO;
        } else {
            return "";
        }
    }

    /**
     * Metodo que me direcciona al formulario de registro de usuario
     *
     * @return @throws Exception
     */
    public String registrarUsuario() throws Exception {
        return DireccionesWeb.REGISTRO;
    }

    /**
     * Metodo que invoca la accion de cancelar registro
     *
     * @return @throws Exception
     */
    public String cancelarRegistro() throws Exception {
        return DireccionesWeb.LOGIN;
    }

    /**
     * Metodo que invoca el guardado el usuario en bd
     *
     * @return
     * @throws Exception
     */
    public String guardarUsuario() throws Exception {
        usuarioDao.crear(this.entidadUsuario);
        return DireccionesWeb.LOGIN;
    }

    /**
     * /**
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

    public boolean isExisteCliente() {
        return existeCliente;
    }

    public void setExisteCliente(boolean existeCliente) {
        this.existeCliente = existeCliente;
    }

    public String getUrlRedireccionLogin() {
        return urlRedireccionLogin;
    }

    public void setUrlRedireccionLogin(String urlRedireccionLogin) {
        this.urlRedireccionLogin = urlRedireccionLogin;
    }

    public ETipoNotificacion getModalTypeNotificacion() {
        return modalTypeNotificacion;
    }

    public void setModalTypeNotificacion(ETipoNotificacion modalTypeNotificacion) {
        this.modalTypeNotificacion = modalTypeNotificacion;
    }

    public usuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(usuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Usuario getEntidadUsuario() {
        return entidadUsuario;
    }

    public void setEntidadUsuario(Usuario entidadUsuario) {
        this.entidadUsuario = entidadUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public IUsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<ETipoUsuario> getListTiposUsuarios() {
        return listTiposUsuarios;
    }

    public void setListTiposUsuarios(List<ETipoUsuario> listTiposUsuarios) {
        this.listTiposUsuarios = listTiposUsuarios;
    }

}
