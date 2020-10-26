/*
 *Farmaceutica la javeriana
 */
package com.javeriana.web.mb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Controlador de pantalla para menu
 *
 * @author Karen Calderon R
 */
@ManagedBean(name = "menuMB")
@ViewScoped
public class MenuMB implements Serializable {

    @PostConstruct
    public void init() {
        try {
        } catch (Exception ex) {
        }
    }

    public String irInicio() {
        return "/dashboard/pantallaInicioUsuarios.xhtml?faces-redirect=true";
    }

    public String irSolicitudesCotizaciones() {
        return "/pages/clientes/solicitudesInicio.xhtml?faces-redirect=true";
    }

    public String irEstadisticas() {
        return "/pages/dashboard/inicio.xhtml?faces-redirect=true";
    }

    public String irMenuCrud() {
        return "/pages/dashboard/inicio.xhtml?faces-redirect=true";
    }
}
