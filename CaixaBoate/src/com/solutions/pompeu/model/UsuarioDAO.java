/*
 * Copyright 2014 Pompeu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
            String sql = "INSERT INTO USUARIOS(nome_usuario,login_usuario,senha_usuario,funcao_usuario,telefone_usuario,cpf_usuario"
                    + ") VALUES (?,?,md5(?),?,?,?)";

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
            String sql = "SELECT * FROM USUARIOS WHERE LOGIN_usuario = ? AND SENHA_usuario = md5(?)";

            preparar = con.prepareStatement(sql);
            preparar.setString(1, usu.getLogin());
            preparar.setString(2, usu.getSenha());
            ResultSet resultado = preparar.executeQuery();

            if (resultado.next()) {
                usuLogar = new Usuario();
                usuLogar.setUsuario_id(resultado.getInt("usuario_id"));
                usuLogar.setNome(resultado.getString("nome_usuario"));
                usuLogar.setLogin(resultado.getString("login_usuario"));
                usuLogar.setSenha(resultado.getString("senha_usuario"));
                usuLogar.setFuncao(resultado.getString("funcao_usuario"));
                usuLogar.setTelefone(resultado.getString("telefone_usuario"));
                usuLogar.setCpf(resultado.getString("cpf_usuario"));
                JOptionPane.showMessageDialog(null,"Bem Vindo \n"+usuLogar.getNome()+"\n"+usuLogar.getFuncao());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return usuLogar;
    }
}
