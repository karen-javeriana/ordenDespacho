/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.web.mb.rest;

import com.javeriana.ejb.constantes.Constants;
import com.javeriana.ejb.response.CotizacionResponse;
import com.javeriana.ejb.service.impl.ManagerServices;
import com.javeriana.ejb.ws.request.CotizacionRequest;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Karen Calderon R
 */
@Path(Constants.SEPARADOR_BARRA)
@RequestScoped
@Produces(MediaType.APPLICATION_JSON + Constants.REST_CODIFICACION)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicesRest {

    @EJB(beanName = "ManagerServices")
    private ManagerServices managerServices;

    @Path(Constants.SOLICITUDES_COTIZACIONES)
    @PUT
    public CotizacionResponse listInventoriesByAccount(CotizacionRequest request) throws Exception {

        return this.managerServices.saveSolicitudCotizacion(request);
    }

}
