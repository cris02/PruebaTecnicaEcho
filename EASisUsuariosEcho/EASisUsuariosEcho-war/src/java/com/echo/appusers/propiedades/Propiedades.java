/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.propiedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class Propiedades {
    private static final String CONFIGURACION = "configuraciones.properties";
    
    public InputStream getResourcesInputAsStream(String configuracion){
        return Propiedades.class.getResourceAsStream(configuracion);
    }
    
    //Método para cargar el archivo de propiedades
    public Properties cargarPropiedades(){
        
        Properties propiedades = new Properties();
        try {
            propiedades.load(getResourcesInputAsStream(CONFIGURACION));
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return propiedades;
    }
}
