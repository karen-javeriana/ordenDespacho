/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.service;

import com.javeriana.ejb.entidades.SolicitudCotizacionManual;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;

/**
 *
 * @author Karen Calderon R
 */
@LocalBean
public interface SolicitudCotizacionSBLocal {

    public List<SolicitudCotizacionManual> consultarPorTodosFiltros(String numeroOrden, Date fechaInicio, Date fechaFin) throws Exception;
    
    
}
