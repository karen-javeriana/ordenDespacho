/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.service.impl;

import com.javeriana.ejb.dao.impl.ICotizacionDao;
import com.javeriana.ejb.entidades.Cotizacion;
import com.javeriana.ejb.response.CotizacionResponse;
import com.javeriana.ejb.ws.request.CotizacionRequest;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Karen Calderon R
 */
@Stateless(name = "ManagerServices")
public class ManagerServices {

    @EJB(beanName = "BeanNameCotizacionDao")
    private ICotizacionDao cotizacionDao;

    public CotizacionResponse saveSolicitudCotizacion(CotizacionRequest request) throws Exception {
        CotizacionResponse response = new CotizacionResponse();

        try {

            // se guarda la cotizacion en la BD
            Cotizacion entidad = new Cotizacion();
            entidad.setIdProveedor(Integer.valueOf(request.getIdProveedor()));
            entidad.setIdSolicitudCotizacion(Integer.valueOf(request.getIdSolicitudCotizacion()));
            entidad.setIdTipoEnvio(Integer.valueOf(request.getIdTipoEnvio()));
            entidad.setNumeroCotizacion(Integer.valueOf(request.getNumeroCotizacion()));
            entidad.setValor(Float.valueOf(request.getValor()));
            entidad.setIdEstadoCotizacion(Integer.valueOf(request.getIdEstadoCotizacion()));

            cotizacionDao.crear(entidad);

        } catch (Exception ex) {

            System.err.println(ex);
        }

        return response;
    }
}
