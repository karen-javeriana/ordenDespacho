/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao;

import com.javeriana.ejb.dao.impl.IUsuarioDao;
import com.javeriana.ejb.entidades.Usuario;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Dao Bean Usuario
 *
 * @author Karen Calderon R
 */
@Stateless(name = "BeanNameUsuarioDao")
public class UsuarioDao extends AbstractDao<Usuario>
        implements IUsuarioDao {

    private static final Logger Log = Logger.getLogger(UsuarioDao.class.getName());

    public UsuarioDao() {
        super(Usuario.class);
    }

    @PersistenceContext(unitName = "com.javeriana_farmaceuticaLaJaveriana-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void crear(Usuario usuario) throws Exception {

        super.crear(usuario);

    }
}
