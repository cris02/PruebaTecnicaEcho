/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.utilidades;

import com.echo.appusers.propiedades.Encriptador;
import com.echo.appusers.propiedades.Propiedades;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Aguilar
 */
public class Correo {

    //método para enviar un correo electrónico
    public void enviarCorreo(String correo, int numero) throws EmailException {
        Propiedades propiedades = new Propiedades();
        Encriptador enc = new Encriptador(); //Instancia para usar método de desencriptación
        HtmlEmail email = new HtmlEmail();

   

        email.setHostName(enc.desencriptador(propiedades.cargarPropiedades().getProperty("srEmName")));
        email.setSmtpPort(Integer.parseInt(enc.desencriptador(propiedades.cargarPropiedades().getProperty("srEmPort"))));
        email.setAuthenticator(new DefaultAuthenticator(enc.desencriptador(propiedades.cargarPropiedades().getProperty("SrEmU")),
                enc.desencriptador(propiedades.cargarPropiedades().getProperty("srEmP"))));
        email.setSSLOnConnect(true);
        email.setFrom(enc.desencriptador(propiedades.cargarPropiedades().getProperty("SrEmU")));
        email.setSubject("Factor de Autenticación");
        email.addTo(correo);
        
        //Formateo de correo a enviar
        email.setHtmlMsg("<html><head>"
                + "<style>"
                + "div{"
                + "   margin: auto;"
                + "   padding: 10px;"
                + "   width: 100%;"
                + "   text-align: center;"
                + "   box-sizing: border-box;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "   <div>"
                + "      <h1>ECHO TECHNOLOGIES</h1>"
                + "      Código de autenticación: <b>" + numero + "</b>, digítalo para poder ingresar al sistema.</h4>"
                + "   </div>"
                + "</body>"
                + "</html>");
        email.setTextMsg("Tu cliente de correo electrónico no soporta mensajes HTML");
        email.send();
    }

}
