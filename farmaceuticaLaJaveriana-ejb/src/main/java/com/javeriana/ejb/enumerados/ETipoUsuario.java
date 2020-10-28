/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.enumerados;

/**
 * Enumerado Tipo de usuario
 *
 * @author Karen Calderon R
 */
public enum ETipoUsuario {

    CLIENTE("Cliente"),
    PROVEEDOR("Proveedor");

    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    private ETipoUsuario(String nombre) {
        this.nombre = nombre;
    }

}
