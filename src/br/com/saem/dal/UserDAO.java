/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saem.dal;

import br.com.saem.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josefino Komba
 */
public class UserDAO extends CRUDController {

    public UserDAO() {
        super("usuario", "senha");
        super.setInserirQuery(String.format("INSERT INTO %s (Nome,Senha,TipoUsuario,UltimoAcesso) VALUES (?,?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE usuario SET Nome = ?, TipoUsuario = ?, UltimoAcesso = ? WHERE senha = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE senha = ? ", this.tabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s ", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Usuario user = (Usuario) object;
        if (update) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getTipoUsuario());
            stmt.setDate(3, (Date) user.getUltimoAcesso());
            stmt.setString(4, user.getSenha());
        } else {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getTipoUsuario());
            stmt.setDate(4, (Date) user.getUltimoAcesso());
        }
    }

    @Override
    protected ArrayList<Usuario> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Usuario> uLista = new ArrayList<>();
        if (all) {
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setNome(rs.getString("Nome"));
                us.setSenha(rs.getString("Senha"));
                us.setTipoUsuario(rs.getString("TipoUsuario"));
                us.setUltimoAcesso(rs.getDate("UltimoAcesso"));
                uLista.add(us);
            }
            return uLista;

        } else {
            rs.next();
            Usuario us = new Usuario();
            us.setNome(rs.getString("Nome"));
            us.setSenha(rs.getString("Senha"));
            us.setTipoUsuario(rs.getString("TipoUsuario"));
            us.setUltimoAcesso(rs.getDate("UltimoAcesso"));
            uLista.add(us);
            return uLista;
        }

    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Inserir(Object object) {
        Usuario user = (Usuario) object;
        super.Inserir(user); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Usuario> Find(String id) {
        return super.Find(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<Usuario> findAll() {
        return (ArrayList<Usuario>) super.getObjectos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        Usuario us = new Usuario("1111", "jose", "normal", null);

        System.out.println(u.Find("123carnuairo").get(0).getTipoUsuario());

    }

}
