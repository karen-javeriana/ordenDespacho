/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.service.impl;

import com.javeriana.ejb.dao.impl.ISolicitudCotizacionDao;
import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import com.javeriana.ejb.service.SolicitudCotizacionSBLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Service Bean solicitudes cotizacion
 *
 * @author Karen Calderon R
 */
@Stateless(name = "BeanNameSolicitudesSB")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SolicitudesCotizacionSB implements SolicitudCotizacionSBLocal {

    @EJB(beanName = "BeanNameSolicitudesDao")
    private ISolicitudCotizacionDao solicitudCotizacionDao;

    @Override
    public List<SolicitudCotizacionManual> getFilterByDate() throws Exception {
        return solicitudCotizacionDao.getFilterByDate();
    }

}
