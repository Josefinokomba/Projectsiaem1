/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saem.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Josefino Komba
 */
@Entity
@Table(name = "usuario")

@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Usuario.findByUltimoAcesso", query = "SELECT u FROM Usuario u WHERE u.ultimoAcesso = :ultimoAcesso")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Id
    @Basic(optional = false)
    @Column(name = "Senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "TipoUsuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @Column(name = "UltimoAcesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcesso;
    @OneToMany(mappedBy = "senha")
    private Collection<Candidatura> candidaturaCollection;

    public Usuario() {
    }

    public Usuario(String senha) {
        this.senha = senha;
    }

    public Usuario(String senha, String nome, String tipoUsuario, Date ultimoAcesso) {
        this.senha = senha;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }


    public Collection<Candidatura> getCandidaturaCollection() {
        return candidaturaCollection;
    }

    public void setCandidaturaCollection(Collection<Candidatura> candidaturaCollection) {
        this.candidaturaCollection = candidaturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (senha != null ? senha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.senha == null && other.senha != null) || (this.senha != null && !this.senha.equals(other.senha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.saem.model.Usuario[ senha=" + senha + " ]";
    }
    
}
