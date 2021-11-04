/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.sessionbeans;

import com.echo.appusers.entidades.Opciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aguilar
 */
@Stateless
public class OpcionesFacade extends AbstractFacade<Opciones> {

    @PersistenceContext(unitName = "EASisUsuariosEcho-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionesFacade() {
        super(Opciones.class);
    }
    
}
