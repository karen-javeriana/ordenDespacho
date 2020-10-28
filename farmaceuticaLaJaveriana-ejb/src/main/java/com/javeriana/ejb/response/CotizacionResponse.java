package com.javeriana.ejb.response;

import javax.xml.bind.annotation.XmlElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Response element
 *
 * @author Karen Calderon R
 */
public class CotizacionResponse {

    @XmlElement(name = "response", required = false)
    protected ResponseElement response;

    public CotizacionResponse() {
    }

    public CotizacionResponse(ResponseElement response) {
        this.response = response;
    }

    public ResponseElement getResponse() {
        return response;
    }

    public void setResponse(ResponseElement response) {
        this.response = response;
    }

}
