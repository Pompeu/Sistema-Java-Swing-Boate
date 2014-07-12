/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutions.pompeu.model;

import com.solutions.pompeu.jdbc.Conectar;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class IngressoDAO extends UsuarioDAO {

    /**
     * recebe um ingresso como paramentros e fazer percistencia dos dados de um
     * ingresso
     *
     * @param ingresso
     */
    public void cadIngressos(Ingresso ingresso) {

        try {
            String sql = "INSERT INTO INGRESSOS(tipo,preco,nome_evento) VALUES (?,?,?)";
            preparar = con.prepareStatement(sql);
            preparar.setString(1, ingresso.getTipo());
            preparar.setFloat(2, ingresso.getPreco());
            preparar.setString(3, ingresso.getNomeEvento());
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    /**
     * Metodos que modifica valor dos ingressos
     * @param ingresso 
     */
    public void precoUpdate(Ingresso ingresso) {
        String sql = "UPDATE INGRESSOS SET  preco = ? WHERE nome_evento = ? and tipo = ?";
        try {
            preparar = con.prepareStatement(sql);
            preparar.setFloat(1, ingresso.getPreco());
            preparar.setString(2, ingresso.getNomeEvento());
            preparar.setString(3, ingresso.getTipo());
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}
