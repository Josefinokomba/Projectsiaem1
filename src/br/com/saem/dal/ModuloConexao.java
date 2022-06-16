/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saem.dal;

import java.sql.*;

/**
 *
 * @author Josefino Komba
 */
public class ModuloConexao {

    public static Connection Conector() {
        //Método responsável por estabelecer a comunicação com a basede dados
        java.sql.Connection conexao = null;
        //A linha a baixo chama o driver
        String driver = "com.mysql.cj.jdbc.Driver";
        //Armazenam informações referentes a base dedos
        String url = "jdbc:mysql://localhost:3306/siaem";
        String user = "root";
        String password = "";
        //Estabelecendo a conexão com a BD
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        }catch(Exception e){
            //A linha a baixa mostra a excepção
            System.out.println(e);
            return null;
        }
    }
}
