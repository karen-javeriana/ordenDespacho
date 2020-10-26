/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.enumerados;

/**
 *
 * @author Karen Calderon R
 */
public enum ETipoNotificacion {

    ERROR("ERROR"),
    ALERTA("ALERTA");

    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    private ETipoNotificacion(String nombre) {
        this.nombre = nombre;
    }

}
