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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Josefino Komba
 */
@Entity
@Table(name = "curso")

@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByNomeCurso", query = "SELECT c FROM Curso c WHERE c.nomeCurso = :nomeCurso")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeCurso")
    private String nomeCurso;
    @OneToMany(mappedBy = "nomeCurso")
    private Collection<Candidatura> candidaturaCollection;
    @JoinColumn(name = "NomeArea", referencedColumnName = "NomeArea")
    @ManyToOne
    private Areacurso nomeArea;

    public Curso() {
    }

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }


    public Collection<Candidatura> getCandidaturaCollection() {
        return candidaturaCollection;
    }

    public void setCandidaturaCollection(Collection<Candidatura> candidaturaCollection) {
        this.candidaturaCollection = candidaturaCollection;
    }

    public Areacurso getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(Areacurso nomeArea) {
        this.nomeArea = nomeArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeCurso != null ? nomeCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.nomeCurso == null && other.nomeCurso != null) || (this.nomeCurso != null && !this.nomeCurso.equals(other.nomeCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.saem.model.Curso[ nomeCurso=" + nomeCurso + " ]";
    }
    
}
