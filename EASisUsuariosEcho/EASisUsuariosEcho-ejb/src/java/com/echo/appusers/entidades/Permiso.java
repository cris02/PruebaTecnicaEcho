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
@Table(name = "apl_per_permiso", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByPerId", query = "SELECT p FROM Permiso p WHERE p.perId = :perId")
    , @NamedQuery(name = "Permiso.findByPerNombre", query = "SELECT p FROM Permiso p WHERE p.perNombre = :perNombre")
    , @NamedQuery(name = "Permiso.findByPerDescripcion", query = "SELECT p FROM Permiso p WHERE p.perDescripcion = :perDescripcion")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PER_ID", nullable = false)
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_NOMBRE", nullable = false, length = 50)
    private String perNombre;
    @Size(max = 200)
    @Column(name = "PER_DESCRIPCION", length = 200)
    private String perDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perId", fetch = FetchType.EAGER)
    private List<Perfil> perfilList;

    public Permiso() {
    }

    public Permiso(Integer perId) {
        this.perId = perId;
    }

    public Permiso(Integer perId, String perNombre) {
        this.perId = perId;
        this.perNombre = perNombre;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
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
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Permiso[ perId=" + perId + " ]";
    }
    
}
