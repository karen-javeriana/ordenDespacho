/*
 * Farmaceutica La Javeriana
 */
package com.javeriana.web.mb;

import com.javeriana.ejb.enumerados.EAction;
import com.javeriana.ejb.enumerados.EFase;
import java.io.Serializable;
import java.util.List;

/**
 * Clase base
 *
 * @author Karen Calderon R
 * @param <T>
 */
public abstract class BaseMB<T> implements Serializable {

    private static final long serialVersionUID = 315259619797071301L;

    private T object = null;
    private T queryObject = null;
    private T selectObject = null;
    private List<T> list = null;
    private EFase phase;
    private EAction action;

    public T getObject() {
        return this.object;
    }

    public void setObject(T _obj) {
        this.object = _obj;
    }

    public T getQueryObject() {
        return queryObject;
    }

    public void setQueryObject(T _queryObject) {
        this.queryObject = _queryObject;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> _list) {
        this.list = _list;
    }

    public EFase getPhase() {
        return phase;
    }

    public void setPhase(EFase phase) {
        this.phase = phase;
    }

    public EAction getAction() {
        return action;
    }

    public void setAction(EAction _action) {
        this.action = _action;
    }

    public T getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(T _obj) {
        this.selectObject = _obj;
    }

    public void processBefore() {
        this.setPhase(EFase.QUERY);
        this.list = null;
    }

    public void processCreate() {
        this.setPhase(EFase.EDIT);
        this.setAction(EAction.CREATE);
    }

    public abstract void processComplete();

    public abstract boolean isValid();

}
