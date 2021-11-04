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
@Table(name = "apl_opc_opciones", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o")
    , @NamedQuery(name = "Opciones.findByOpcId", query = "SELECT o FROM Opciones o WHERE o.opcId = :opcId")
    , @NamedQuery(name = "Opciones.findByOpcNombre", query = "SELECT o FROM Opciones o WHERE o.opcNombre = :opcNombre")
    , @NamedQuery(name = "Opciones.findByOpcEstado", query = "SELECT o FROM Opciones o WHERE o.opcEstado = :opcEstado")
    , @NamedQuery(name = "Opciones.findByOpcDescripcion", query = "SELECT o FROM Opciones o WHERE o.opcDescripcion = :opcDescripcion")})
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OPC_ID", nullable = false)
    private Integer opcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OPC_NOMBRE", nullable = false, length = 50)
    private String opcNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_ESTADO", nullable = false)
    private boolean opcEstado;
    @Size(max = 200)
    @Column(name = "OPC_DESCRIPCION", length = 200)
    private String opcDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcId", fetch = FetchType.EAGER)
    private List<Perfil> perfilList;

    public Opciones() {
    }

    public Opciones(Integer opcId) {
        this.opcId = opcId;
    }

    public Opciones(Integer opcId, String opcNombre, boolean opcEstado) {
        this.opcId = opcId;
        this.opcNombre = opcNombre;
        this.opcEstado = opcEstado;
    }

    public Integer getOpcId() {
        return opcId;
    }

    public void setOpcId(Integer opcId) {
        this.opcId = opcId;
    }

    public String getOpcNombre() {
        return opcNombre;
    }

    public void setOpcNombre(String opcNombre) {
        this.opcNombre = opcNombre;
    }

    public boolean getOpcEstado() {
        return opcEstado;
    }

    public void setOpcEstado(boolean opcEstado) {
        this.opcEstado = opcEstado;
    }

    public String getOpcDescripcion() {
        return opcDescripcion;
    }

    public void setOpcDescripcion(String opcDescripcion) {
        this.opcDescripcion = opcDescripcion;
    }

    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcId != null ? opcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.opcId == null && other.opcId != null) || (this.opcId != null && !this.opcId.equals(other.opcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Opciones[ opcId=" + opcId + " ]";
    }
    
}
