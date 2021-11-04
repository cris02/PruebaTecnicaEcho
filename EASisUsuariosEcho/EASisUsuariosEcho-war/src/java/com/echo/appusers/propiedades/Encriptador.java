/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.propiedades;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Aguilar
 */
public class Encriptador {

    BasicTextEncryptor encriptadorBasico;
    final String PASS = "secret-data";

    //Método para encriptar
    public String encriptador(String contraseña) {
        encriptadorBasico = new BasicTextEncryptor();
        encriptadorBasico.setPassword(PASS);

        return encriptadorBasico.encrypt(contraseña);
    }

    //Método para desencriptar
    public String desencriptador(String texto) {
        encriptadorBasico = new BasicTextEncryptor();
        encriptadorBasico.setPassword(PASS);
        return encriptadorBasico.decrypt(texto);
    }
}
