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
@Table(name = "apl_dir_direccion", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByDirId", query = "SELECT d FROM Direccion d WHERE d.dirId = :dirId")
    , @NamedQuery(name = "Direccion.findByDirNombreResidencia", query = "SELECT d FROM Direccion d WHERE d.dirNombreResidencia = :dirNombreResidencia")
    , @NamedQuery(name = "Direccion.findByDirNumeroCasa", query = "SELECT d FROM Direccion d WHERE d.dirNumeroCasa = :dirNumeroCasa")
    , @NamedQuery(name = "Direccion.findByDirNumeroBloque", query = "SELECT d FROM Direccion d WHERE d.dirNumeroBloque = :dirNumeroBloque")
    , @NamedQuery(name = "Direccion.findByDirPasaje", query = "SELECT d FROM Direccion d WHERE d.dirPasaje = :dirPasaje")
    , @NamedQuery(name = "Direccion.findByDirNombreCalle", query = "SELECT d FROM Direccion d WHERE d.dirNombreCalle = :dirNombreCalle")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DIR_ID", nullable = false)
    private Integer dirId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIR_NOMBRE_RESIDENCIA", nullable = false, length = 100)
    private String dirNombreResidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DIR_NUMERO_CASA", nullable = false, length = 20)
    private String dirNumeroCasa;
    @Size(max = 10)
    @Column(name = "DIR_NUMERO_BLOQUE", length = 10)
    private String dirNumeroBloque;
    @Size(max = 20)
    @Column(name = "DIR_PASAJE", length = 20)
    private String dirPasaje;
    @Size(max = 100)
    @Column(name = "DIR_NOMBRE_CALLE", length = 100)
    private String dirNombreCalle;
    @JoinColumn(name = "MUN_ID", referencedColumnName = "MUN_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Municipio munId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dirId", fetch = FetchType.EAGER)
    private List<Persona> personaList;

    public Direccion() {
    }

    public Direccion(Integer dirId) {
        this.dirId = dirId;
    }

    public Direccion(Integer dirId, String dirNombreResidencia, String dirNumeroCasa) {
        this.dirId = dirId;
        this.dirNombreResidencia = dirNombreResidencia;
        this.dirNumeroCasa = dirNumeroCasa;
    }

    public Integer getDirId() {
        return dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public String getDirNombreResidencia() {
        return dirNombreResidencia;
    }

    public void setDirNombreResidencia(String dirNombreResidencia) {
        this.dirNombreResidencia = dirNombreResidencia;
    }

    public String getDirNumeroCasa() {
        return dirNumeroCasa;
    }

    public void setDirNumeroCasa(String dirNumeroCasa) {
        this.dirNumeroCasa = dirNumeroCasa;
    }

    public String getDirNumeroBloque() {
        return dirNumeroBloque;
    }

    public void setDirNumeroBloque(String dirNumeroBloque) {
        this.dirNumeroBloque = dirNumeroBloque;
    }

    public String getDirPasaje() {
        return dirPasaje;
    }

    public void setDirPasaje(String dirPasaje) {
        this.dirPasaje = dirPasaje;
    }

    public String getDirNombreCalle() {
        return dirNombreCalle;
    }

    public void setDirNombreCalle(String dirNombreCalle) {
        this.dirNombreCalle = dirNombreCalle;
    }

    public Municipio getMunId() {
        return munId;
    }

    public void setMunId(Municipio munId) {
        this.munId = munId;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dirId != null ? dirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.dirId == null && other.dirId != null) || (this.dirId != null && !this.dirId.equals(other.dirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Direccion[ dirId=" + dirId + " ]";
    }
    
}
