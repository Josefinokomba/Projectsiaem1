/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saem.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Josefino Komba
 */
@Entity
@Table(name = "candidatura")

@NamedQueries({
    @NamedQuery(name = "Candidatura.findAll", query = "SELECT c FROM Candidatura c"),
    @NamedQuery(name = "Candidatura.findByNumBI", query = "SELECT c FROM Candidatura c WHERE c.numBI = :numBI"),
    @NamedQuery(name = "Candidatura.findByNomeP", query = "SELECT c FROM Candidatura c WHERE c.nomeP = :nomeP"),
    @NamedQuery(name = "Candidatura.findByNomeF", query = "SELECT c FROM Candidatura c WHERE c.nomeF = :nomeF"),
    @NamedQuery(name = "Candidatura.findBySexo", query = "SELECT c FROM Candidatura c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Candidatura.findByDataNasc", query = "SELECT c FROM Candidatura c WHERE c.dataNasc = :dataNasc"),
    @NamedQuery(name = "Candidatura.findByMorada", query = "SELECT c FROM Candidatura c WHERE c.morada = :morada"),
    @NamedQuery(name = "Candidatura.findByIdade", query = "SELECT c FROM Candidatura c WHERE c.idade = :idade"),
    @NamedQuery(name = "Candidatura.findByTelefone", query = "SELECT c FROM Candidatura c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Candidatura.findByEmailUser", query = "SELECT c FROM Candidatura c WHERE c.emailUser = :emailUser")})
public class Candidatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NumBI")
    private String numBI;
    @Basic(optional = false)
    @Column(name = "NomeP")
    private String nomeP;
    @Basic(optional = false)
    @Column(name = "NomeF")
    private String nomeF;
    @Basic(optional = false)
    @Column(name = "Sexo")
    private String sexo;
    @Column(name = "DataNasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "Morada")
    private String morada;
    @Basic(optional = false)
    @Column(name = "idade")
    private int idade;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "EmailUser")
    private String emailUser;
    @JoinColumn(name = "NomeCurso", referencedColumnName = "NomeCurso")
    @ManyToOne
    private Curso nomeCurso;
    @JoinColumn(name = "Senha", referencedColumnName = "Senha")
    @ManyToOne
    private Usuario senha;

    public Candidatura() {
    }

    public Candidatura(String numBI) {
        this.numBI = numBI;
    }

    public Candidatura(String numBI, String nomeP, String nomeF, String sexo, int idade, String telefone, String emailUser) {
        this.numBI = numBI;
        this.nomeP = nomeP;
        this.nomeF = nomeF;
        this.sexo = sexo;
        this.idade = idade;
        this.telefone = telefone;
        this.emailUser = emailUser;
    }

    public String getNumBI() {
        return numBI;
    }

    public void setNumBI(String numBI) {
        this.numBI = numBI;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public String getNomeF() {
        return nomeF;
    }

    public void setNomeF(String nomeF) {
        this.nomeF = nomeF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Curso getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(Curso nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Usuario getSenha() {
        return senha;
    }

    public void setSenha(Usuario senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBI != null ? numBI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidatura)) {
            return false;
        }
        Candidatura other = (Candidatura) object;
        if ((this.numBI == null && other.numBI != null) || (this.numBI != null && !this.numBI.equals(other.numBI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.saem.model.Candidatura[ numBI=" + numBI + " ]";
    }
    
}
