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
public enum ESeveridadMensaje {

    DEFAULT("default"),
    INFO("info"),
    SUCCESS("sucsess"),
    WARNING("warning"),
    DANGER("danger");

    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    private ESeveridadMensaje(String nombre) {
        this.nombre = nombre;
    }

}
