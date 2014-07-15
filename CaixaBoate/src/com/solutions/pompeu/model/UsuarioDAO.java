/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutions.pompeu.model;

import com.solutions.pompeu.jdbc.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class UsuarioDAO {

    protected Connection con = Conectar.conect();
    protected PreparedStatement preparar;
    /**
     * esse função faz cadstro de usuarios no banco de dados
     * @param usu 
     */
    public void cadUsuario(Usuario usu) {

        try {
            String sql = "INSERT INTO USUARIO(nome,login,senha,funcao,telefone,cpf) VALUES (?,?,md5(?),?,?,?)";

            preparar = con.prepareStatement(sql);
            preparar.setString(1, usu.getNome());
            preparar.setString(2, usu.getLogin());
            preparar.setString(3, usu.getSenha());
            preparar.setString(4, usu.getFuncao());
            preparar.setString(5, usu.getTelefone());
            preparar.setString(6, usu.getCpf());
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    /**
     * essa função faz o login com banco de dados
     * @param usu
     * @return 
     */
    public Usuario logar(Usuario usu) {
        Usuario usuLogar = null;
        try {
            String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = md5(?)";

            preparar = con.prepareStatement(sql);
            preparar.setString(1, usu.getLogin());
            preparar.setString(2, usu.getSenha());
            ResultSet resultado = preparar.executeQuery();

            if (resultado.next()) {
                usuLogar = new Usuario();
                usuLogar.setUsuario_id(resultado.getInt("usuario_id"));
                usuLogar.setNome(resultado.getString("nome"));
                usuLogar.setLogin(resultado.getString("login"));
                usuLogar.setSenha(resultado.getString("senha"));
                usuLogar.setFuncao(resultado.getString("funcao"));
                usuLogar.setTelefone(resultado.getString("telefone"));
                usuLogar.setCpf(resultado.getString("cpf"));
                JOptionPane.showMessageDialog(null,"Bem Vindo \n"+usuLogar.getNome()+"\n"+usuLogar.getFuncao());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return usuLogar;
    }
}
