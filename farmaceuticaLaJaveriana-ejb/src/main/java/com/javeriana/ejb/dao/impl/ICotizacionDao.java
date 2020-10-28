/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao.impl;

import com.javeriana.ejb.entidades.Cotizacion;

/**
 * Interfaz cotizacion dao
 *
 * @author Karen Calderon R
 */
public interface ICotizacionDao {

    void crear(Cotizacion cotizacion) throws Exception;

}
