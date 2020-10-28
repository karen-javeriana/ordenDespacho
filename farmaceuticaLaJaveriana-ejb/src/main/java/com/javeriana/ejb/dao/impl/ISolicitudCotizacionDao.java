/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao.impl;

import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Karen Calderon R
 */
public interface ISolicitudCotizacionDao {

    void crear(SolicitudCotizacionManual solicitudCotizacion) throws Exception;

    List<SolicitudCotizacionManual> consultarPorTodosFiltros(String numeroOrden, Date fechaInicio, Date fechaFin) throws Exception;

}
