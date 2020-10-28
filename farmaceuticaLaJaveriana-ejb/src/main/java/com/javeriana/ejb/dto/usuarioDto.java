/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.dto;

import com.javeriana.ejb.enumerados.ETipoUsuario;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase Dto Usuario
 *
 * @author Karen Calderon R
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioDto")
public class usuarioDto {

    private String id;
    private String usuario;
    private String numeroDocumento;
    private ETipoUsuario tipoUsuario;
    private String password;

    public usuarioDto() {
    }

    public usuarioDto(String id, String usuario, String numeroDocumento, ETipoUsuario tipoUsuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.numeroDocumento = numeroDocumento;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public ETipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(ETipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
