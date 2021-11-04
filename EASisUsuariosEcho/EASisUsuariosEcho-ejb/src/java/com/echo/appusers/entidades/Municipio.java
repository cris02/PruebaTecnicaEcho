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
@Table(name = "apl_mun_municipio", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
    , @NamedQuery(name = "Municipio.findByMunId", query = "SELECT m FROM Municipio m WHERE m.munId = :munId")
    , @NamedQuery(name = "Municipio.findByMunNombre", query = "SELECT m FROM Municipio m WHERE m.munNombre = :munNombre")
    , @NamedQuery(name = "Municipio.findByMunArea", query = "SELECT m FROM Municipio m WHERE m.munArea = :munArea")
    , @NamedQuery(name = "Municipio.findByMunAltitud", query = "SELECT m FROM Municipio m WHERE m.munAltitud = :munAltitud")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUN_ID", nullable = false)
    private Integer munId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MUN_NOMBRE", nullable = false, length = 100)
    private String munNombre;
    @Size(max = 15)
    @Column(name = "MUN_AREA", length = 15)
    private String munArea;
    @Size(max = 15)
    @Column(name = "MUN_ALTITUD", length = 15)
    private String munAltitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "munId", fetch = FetchType.EAGER)
    private List<Direccion> direccionList;
    @JoinColumn(name = "DEP_ID", referencedColumnName = "DEP_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Departamento depId;

    public Municipio() {
    }

    public Municipio(Integer munId) {
        this.munId = munId;
    }

    public Municipio(Integer munId, String munNombre) {
        this.munId = munId;
        this.munNombre = munNombre;
    }

    public Integer getMunId() {
        return munId;
    }

    public void setMunId(Integer munId) {
        this.munId = munId;
    }

    public String getMunNombre() {
        return munNombre;
    }

    public void setMunNombre(String munNombre) {
        this.munNombre = munNombre;
    }

    public String getMunArea() {
        return munArea;
    }

    public void setMunArea(String munArea) {
        this.munArea = munArea;
    }

    public String getMunAltitud() {
        return munAltitud;
    }

    public void setMunAltitud(String munAltitud) {
        this.munAltitud = munAltitud;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public Departamento getDepId() {
        return depId;
    }

    public void setDepId(Departamento depId) {
        this.depId = depId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (munId != null ? munId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.munId == null && other.munId != null) || (this.munId != null && !this.munId.equals(other.munId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Municipio[ munId=" + munId + " ]";
    }
    
}
