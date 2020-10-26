/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.dao;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

/**
 *
 * @author Karen Calderon R
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class AbstractDao<T> {

    private final Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Almacena los valores de una entidad en la persistencia.
     *
     * @param entity entidad a crear, no debe ser nula.
     * @throws java.lang.Exception
     */
    public void crear(T entity) throws Exception {
        try {

            getEntityManager().persist(entity);
            getEntityManager().flush();

        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    /**
     * Actualiza los valores de una entidad con la persistencia.
     *
     * @param entity entidad a actualizar, no debe ser nula.
     * @throws java.lang.Exception
     */
    public void editar(T entity) throws Exception {
        try {

            getEntityManager().merge(entity);
            getEntityManager().flush();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

}
