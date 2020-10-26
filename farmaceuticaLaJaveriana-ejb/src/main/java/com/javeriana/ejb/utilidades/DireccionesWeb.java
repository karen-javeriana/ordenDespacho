/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.utilidades;

/**
 *
 * @author Karen Calderon R
 */
public class DireccionesWeb {

    public static final String LOGIN = "/index.xhtml?faces-redirect=true";
    public static final String INICIO = "/dashboard/pantallaInicioUsuarios.xhtml";
    public static final String ERROR_403 = "/pages/error/403.xhtml";
    public static final String ERROR_500 = "/pages/error/500.xhtml";

    private DireccionesWeb() {
        throw new AssertionError();
    }
}
