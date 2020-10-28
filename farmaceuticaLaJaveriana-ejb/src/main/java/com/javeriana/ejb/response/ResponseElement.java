package com.javeriana.ejb.response;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseElement {

    @XmlElement(required = false)

    protected String result;

    @XmlElement(required = false)
    protected String type;

    @XmlElement(required = false)
    protected String description;

    public ResponseElement() {
    }

    public ResponseElement(String result, String type, String description) {
        this.result = result;
        this.type = type;
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
