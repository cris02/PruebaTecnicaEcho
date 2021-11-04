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
@Table(name = "apl_pes_persona", catalog = "adminuserdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPesId", query = "SELECT p FROM Persona p WHERE p.pesId = :pesId")
    , @NamedQuery(name = "Persona.findByPesNombres", query = "SELECT p FROM Persona p WHERE p.pesNombres = :pesNombres")
    , @NamedQuery(name = "Persona.findByPesApellidos", query = "SELECT p FROM Persona p WHERE p.pesApellidos = :pesApellidos")
    , @NamedQuery(name = "Persona.findByPesCorreo", query = "SELECT p FROM Persona p WHERE p.pesCorreo = :pesCorreo")
    , @NamedQuery(name = "Persona.findByPesTelefono", query = "SELECT p FROM Persona p WHERE p.pesTelefono = :pesTelefono")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PES_ID", nullable = false)
    private Integer pesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PES_NOMBRES", nullable = false, length = 50)
    private String pesNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PES_APELLIDOS", nullable = false, length = 50)
    private String pesApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PES_CORREO", nullable = false, length = 60)
    private String pesCorreo;
    @Size(max = 10)
    @Column(name = "PES_TELEFONO", length = 10)
    private String pesTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesId", fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;
    @JoinColumn(name = "DIR_ID", referencedColumnName = "DIR_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Direccion dirId;

    public Persona() {
    }

    public Persona(Integer pesId) {
        this.pesId = pesId;
    }

    public Persona(Integer pesId, String pesNombres, String pesApellidos, String pesCorreo) {
        this.pesId = pesId;
        this.pesNombres = pesNombres;
        this.pesApellidos = pesApellidos;
        this.pesCorreo = pesCorreo;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public String getPesNombres() {
        return pesNombres;
    }

    public void setPesNombres(String pesNombres) {
        this.pesNombres = pesNombres;
    }

    public String getPesApellidos() {
        return pesApellidos;
    }

    public void setPesApellidos(String pesApellidos) {
        this.pesApellidos = pesApellidos;
    }

    public String getPesCorreo() {
        return pesCorreo;
    }

    public void setPesCorreo(String pesCorreo) {
        this.pesCorreo = pesCorreo;
    }

    public String getPesTelefono() {
        return pesTelefono;
    }

    public void setPesTelefono(String pesTelefono) {
        this.pesTelefono = pesTelefono;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Direccion getDirId() {
        return dirId;
    }

    public void setDirId(Direccion dirId) {
        this.dirId = dirId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesId != null ? pesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.pesId == null && other.pesId != null) || (this.pesId != null && !this.pesId.equals(other.pesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.echo.appusers.entidades.Persona[ pesId=" + pesId + " ]";
    }
    
}
