/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saem.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josefino Komba
 */
@Entity
@Table(name = "areacurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areacurso.findAll", query = "SELECT a FROM Areacurso a"),
    @NamedQuery(name = "Areacurso.findByNomeArea", query = "SELECT a FROM Areacurso a WHERE a.nomeArea = :nomeArea"),
    @NamedQuery(name = "Areacurso.findByCodArea", query = "SELECT a FROM Areacurso a WHERE a.codArea = :codArea")})
public class Areacurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeArea")
    private String nomeArea;
    @Column(name = "CodArea")
    private Integer codArea;
    @OneToMany(mappedBy = "nomeArea")
    private Collection<Curso> cursoCollection;

    public Areacurso() {
    }

    public Areacurso(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeArea != null ? nomeArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areacurso)) {
            return false;
        }
        Areacurso other = (Areacurso) object;
        if ((this.nomeArea == null && other.nomeArea != null) || (this.nomeArea != null && !this.nomeArea.equals(other.nomeArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.saem.model.Areacurso[ nomeArea=" + nomeArea + " ]";
    }
    
}
