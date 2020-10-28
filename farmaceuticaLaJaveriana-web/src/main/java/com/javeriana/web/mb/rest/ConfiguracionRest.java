/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.web.mb.rest;

import java.util.Set;

/**
 * Objetivo: Crear el metodo del servicio generico.
 *
 * @author Karen Calderon R
 */
@javax.ws.rs.ApplicationPath("ws")
public class ConfiguracionRest extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.javeriana.web.mb.rest.ServicesRest.class);
    }
}
