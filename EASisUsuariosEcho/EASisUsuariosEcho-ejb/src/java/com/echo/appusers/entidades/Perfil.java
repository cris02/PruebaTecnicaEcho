/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.echo.appusers.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aguilar
 */
@Entity
@Table(name = "apl_pef_perfil", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByPefId", query = "SELECT p FROM Perfil p WHERE p.pefId = :pefId")
    , @NamedQuery(name = "Perfil.findByPefEstado", query = "SELECT p FROM Perfil p WHERE p.pefEstado = :pefEstado")
    , @NamedQuery(name = "Perfil.findByPefDescripcion", query = "SELECT p FROM Perfil p WHERE p.pefDescripcion = :pefDescripcion")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEF_ID", nullable = false)
    private Integer pefId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEF_ESTADO", nullable = false)
    private boolean pefEstado;
    @Size(max = 200)
    @Column(name = "PEF_DESCRIPCION", length = 200)
    private String pefDescripcion;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rolId;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Permiso perId;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Opciones opcId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pefId", fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;

    public Perfil() {
    }

    public Perfil(Integer pefId) {
        this.pefId = pefId;
    }

    public Perfil(Integer pefId, boolean pefEstado) {
        this.pefId = pefId;
        this.pefEstado = pefEstado;
    }

    public Integer getPefId() {
        return pefId;
    }

    public void setPefId(Integer pefId) {
        this.pefId = pefId;
    }

    public boolean getPefEstado() {
        return pefEstado;
    }

    public void setPefEstado(boolean pefEstado) {
        this.pefEstado = pefEstado;
    }

    public String getPefDescripcion() {
        return pefDescripcion;
    }

    public void setPefDescripcion(String pefDescripcion) {
        this.pefDescripcion = pefDescripcion;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public Permiso getPerId() {
        return perId;
    }

    public void setPerId(Permiso perId) {
        this.perId = perId;
    }

    public Opciones getOpcId() {
        return opcId;
    }

    public void setOpcId(Opciones opcId) {
        this.opcId = opcId;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pefId != null ? pefId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.pefId == null && other.pefId != null) || (this.pefId != null && !this.pefId.equals(other.pefId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Perfil[ pefId=" + pefId + " ]";
    }
    
}
