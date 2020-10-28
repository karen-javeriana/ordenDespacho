/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dao.impl;

import com.javeriana.ejb.entidades.Usuario;

/**
 * Interfaz usuario dao
 *
 * @author Karen Calderon R
 */
public interface IUsuarioDao {

    void crear(Usuario usuario) throws Exception;

    Usuario consultarUsuario(String usuario, String password) throws Exception;

}
