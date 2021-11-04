/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.manejadores;

import com.echo.appusers.entidades.Usuario;
import com.echo.appusers.propiedades.Encriptador;
import com.echo.appusers.utilidades.Correo;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
/**
 *
 * @author Aguilar
 */
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable{
    
    @EJB
    private com.echo.appusers.sessionbeans.UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private Encriptador encriptador = new Encriptador();
    private Correo correoElectronico = new Correo();
    //variables para generar numero aleatorio
    private int codigo;
    private int numero;
    //banderas de validacion
    private boolean flagUsuario;
    private boolean flagCodigo;
    
    public LoginController(){
        usuario = new Usuario();
        flagCodigo = false;
        codigo = 0;
        numero = 1;
    }
    
    // metodo para valida si existe el usuario
     public void validarUsuario() throws IOException{
         Usuario usuarioRegistrado = usuarioFacade.find(usuario);
         
         
     }
    
}
