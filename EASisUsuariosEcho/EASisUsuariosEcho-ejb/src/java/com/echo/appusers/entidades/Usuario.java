/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aguilar
 */
@Entity
@Table(name = "apl_usu_usuario", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuId", query = "SELECT u FROM Usuario u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "Usuario.findByUsuUser", query = "SELECT u FROM Usuario u WHERE u.usuUser = :usuUser")
    , @NamedQuery(name = "Usuario.findByUsuPass", query = "SELECT u FROM Usuario u WHERE u.usuPass = :usuPass")
    , @NamedQuery(name = "Usuario.findByUsuFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaCreacion = :usuFechaCreacion")
    , @NamedQuery(name = "Usuario.findByUsuFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaModificacion = :usuFechaModificacion")
    , @NamedQuery(name = "Usuario.findByUsuEstado", query = "SELECT u FROM Usuario u WHERE u.usuEstado = :usuEstado")
    , @NamedQuery(name = "Usuario.findByUsuDescripcion", query = "SELECT u FROM Usuario u WHERE u.usuDescripcion = :usuDescripcion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_ID", nullable = false)
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_USER", nullable = false, length = 50)
    private String usuUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_PASS", nullable = false, length = 100)
    private String usuPass;
    @Column(name = "USU_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date usuFechaCreacion;
    @Column(name = "USU_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date usuFechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ESTADO", nullable = false)
    private boolean usuEstado;
    @Size(max = 200)
    @Column(name = "USU_DESCRIPCION", length = 200)
    private String usuDescripcion;
    @JoinColumn(name = "PEF_ID", referencedColumnName = "PEF_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Perfil pefId;
    @JoinColumn(name = "PES_ID", referencedColumnName = "PES_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona pesId;

    public Usuario() {
    }

    public Usuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Usuario(Integer usuId, String usuUser, String usuPass, boolean usuEstado) {
        this.usuId = usuId;
        this.usuUser = usuUser;
        this.usuPass = usuPass;
        this.usuEstado = usuEstado;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuUser() {
        return usuUser;
    }

    public void setUsuUser(String usuUser) {
        this.usuUser = usuUser;
    }

    public String getUsuPass() {
        return usuPass;
    }

    public void setUsuPass(String usuPass) {
        this.usuPass = usuPass;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public Date getUsuFechaModificacion() {
        return usuFechaModificacion;
    }

    public void setUsuFechaModificacion(Date usuFechaModificacion) {
        this.usuFechaModificacion = usuFechaModificacion;
    }

    public boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuDescripcion() {
        return usuDescripcion;
    }

    public void setUsuDescripcion(String usuDescripcion) {
        this.usuDescripcion = usuDescripcion;
    }

    public Perfil getPefId() {
        return pefId;
    }

    public void setPefId(Perfil pefId) {
        this.pefId = pefId;
    }

    public Persona getPesId() {
        return pesId;
    }

    public void setPesId(Persona pesId) {
        this.pesId = pesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Usuario[ usuId=" + usuId + " ]";
    }
    
}
