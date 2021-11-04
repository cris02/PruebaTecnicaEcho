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
@Table(name = "apl_dep_departamento", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findByDepId", query = "SELECT d FROM Departamento d WHERE d.depId = :depId")
    , @NamedQuery(name = "Departamento.findByDepNombre", query = "SELECT d FROM Departamento d WHERE d.depNombre = :depNombre")
    , @NamedQuery(name = "Departamento.findByDepArea", query = "SELECT d FROM Departamento d WHERE d.depArea = :depArea")
    , @NamedQuery(name = "Departamento.findByDepAltitud", query = "SELECT d FROM Departamento d WHERE d.depAltitud = :depAltitud")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEP_ID", nullable = false)
    private Integer depId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DEP_NOMBRE", nullable = false, length = 40)
    private String depNombre;
    @Size(max = 15)
    @Column(name = "DEP_AREA", length = 15)
    private String depArea;
    @Size(max = 15)
    @Column(name = "DEP_ALTITUD", length = 15)
    private String depAltitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depId", fetch = FetchType.EAGER)
    private List<Municipio> municipioList;

    public Departamento() {
    }

    public Departamento(Integer depId) {
        this.depId = depId;
    }

    public Departamento(Integer depId, String depNombre) {
        this.depId = depId;
        this.depNombre = depNombre;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    public String getDepArea() {
        return depArea;
    }

    public void setDepArea(String depArea) {
        this.depArea = depArea;
    }

    public String getDepAltitud() {
        return depAltitud;
    }

    public void setDepAltitud(String depAltitud) {
        this.depAltitud = depAltitud;
    }

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Departamento[ depId=" + depId + " ]";
    }
    
}
