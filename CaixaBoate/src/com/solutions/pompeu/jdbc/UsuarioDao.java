/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutions.pompeu.jdbc;

import com.solutions.pompeu.jdbc.Conectar;
import com.solutions.pompeu.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class UsuarioDao {

    protected Connection con = Conectar.conect();
    protected PreparedStatement preparar;

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

}
