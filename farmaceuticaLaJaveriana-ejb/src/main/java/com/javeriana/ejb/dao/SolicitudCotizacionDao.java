/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao;

import com.javeriana.ejb.dao.impl.ISolicitudCotizacionDao;
import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
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
    public List<SolicitudCotizacionManual> getFilterByDate() throws Exception {

        try {
            return em.createNamedQuery("SolicitudCotizacionManual.getFilterByDate", SolicitudCotizacionManual.class)
                    .getResultList();
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }

    @Override
    public SolicitudCotizacionManual getFilterById(Long id) throws Exception {
        try {

//            return em.createNamedQuery("SolicitudCotizacion.getById", SolicitudCotizacionManual.class)
//                    .setParameter("id", id).getSingleResult();
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
        return null;
    }

    @Override
    public List<SolicitudCotizacionManual> getFilterByDateAndId(Long id, Date fechaInicio, Date fechaFin) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
