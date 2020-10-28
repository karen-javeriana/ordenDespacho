/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao;

import com.javeriana.ejb.dao.impl.ISolicitudCotizacionDao;
import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Dao Bean Solicitud cotizacion
 *
 * @author Karen Calderon R
 */
@Stateless(name = "BeanNameSolicitudesDao")
public class SolicitudCotizacionDao extends AbstractDao<SolicitudCotizacionManual>
        implements ISolicitudCotizacionDao {

    private static final Logger Log = Logger.getLogger(SolicitudCotizacionDao.class.getName());

    public SolicitudCotizacionDao() {
        super(SolicitudCotizacionManual.class);
    }

    @PersistenceContext(unitName = "com.javeriana_farmaceuticaLaJaveriana-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void crear(SolicitudCotizacionManual solicitudCotizacion) throws Exception {

        super.crear(solicitudCotizacion);

    }

    @Override
    public List<SolicitudCotizacionManual> consultarPorTodosFiltros(String numeroOrden, Date fechaInicio, Date fechaFin) throws Exception {
        List<SolicitudCotizacionManual> resultado = new ArrayList<>();
        try {
            if (numeroOrden != null && !numeroOrden.isEmpty() && fechaFin != null && fechaInicio != null) {
                resultado = em.createNamedQuery("SolicitudCotizacionManual.getFilterByDateAndNumeroOrden", SolicitudCotizacionManual.class)
                        .setParameter("fechaInicio", fechaInicio)
                        .setParameter("fechaFin", fechaFin)
                        .setParameter("numeroOrden", Long.valueOf(numeroOrden)).getResultList();
            }
            if (numeroOrden != null && !numeroOrden.isEmpty() && (fechaFin == null || fechaInicio == null)) {
                resultado = em.createNamedQuery("SolicitudCotizacionManual.getByNumeroOrden", SolicitudCotizacionManual.class)
                        .setParameter("numeroOrden", Long.valueOf(numeroOrden)).getResultList();
            }
            if (numeroOrden == null && (fechaFin != null && fechaInicio != null)) {
                resultado = em.createNamedQuery("SolicitudCotizacionManual.getByRangoFechas", SolicitudCotizacionManual.class)
                        .setParameter("fechaInicio", fechaInicio)
                        .setParameter("fechaFin", fechaFin).getResultList();
            }
            if (numeroOrden == null && numeroOrden.isEmpty() && fechaFin == null && fechaInicio == null) {
                resultado = em.createNamedQuery("SolicitudCotizacionManual.getFilterAll", SolicitudCotizacionManual.class).getResultList();
            }
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
        return resultado;
    }
}
