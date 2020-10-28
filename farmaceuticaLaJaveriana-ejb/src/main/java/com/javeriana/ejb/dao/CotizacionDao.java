/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao;

import com.javeriana.ejb.dao.impl.ICotizacionDao;
import com.javeriana.ejb.dao.impl.ISolicitudCotizacionDao;
import com.javeriana.ejb.entidades.Cotizacion;
import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Dao Bean cotizacion
 *
 * @author Karen Calderon R
 */
@Stateless(name = "BeanNameCotizacionDao")
public class CotizacionDao extends AbstractDao<Cotizacion>
        implements ICotizacionDao {

    private static final Logger Log = Logger.getLogger(CotizacionDao.class.getName());

    public CotizacionDao() {
        super(Cotizacion.class);
    }

    @PersistenceContext(unitName = "com.javeriana_farmaceuticaLaJaveriana-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void crear(Cotizacion cotizacion) throws Exception {

        super.crear(cotizacion);

    }
}
