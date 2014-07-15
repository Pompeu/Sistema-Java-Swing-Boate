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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class CartaoConsumacaoDAO extends UsuarioDAO {

    /**
     * inciar saldo do cartão
     *
     * @param cartao
     */
    public void cartaoStart(CartaoConsumacao cartao) {

        String sql = "INSERT INTO CARTAO(NUMERO , SALDO) VALUES(?,?)";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, cartao.getNumero());
            preparar.setDouble(2, cartao.getSaldo());
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null, "Cartão Iniciado Com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    /**
     * Metodo que faz um select entre usuario e o cartão e retorna um usuario
     *
     * @param numero de cartão
     * @return nome de usuario
     */
    public Usuario listaCartao(long numero) {
        CartaoConsumacao cartao = new CartaoConsumacao();
        Usuario usuario = new Usuario();

        Map<CartaoConsumacao, Usuario> cartaoUsuario = new HashMap<>();

        String sql = "SELECT * FROM USUARIO_CARTAO WHERE NUMERO = ?";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, numero);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {

                usuario.setNome(resultado.getString("nome"));
                usuario.setUsuario_id(resultado.getLong("usuario_id"));
                cartaoUsuario.put(cartao, usuario);
            }
            preparar.close();
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }/*
         try {
         nome = cartaoUsuario.values().iterator().next().getNome();
         } catch (NoSuchElementException ex) {
         JOptionPane.showMessageDialog(null, "Numero Não Econtrado");
         }*/

        return usuario;
    }

    /**
     * Adicionar mais saldo ao cartao ou baixar creditos no caso de vendas
     *
     * @param cartao
     */
    public void cartaoUpdate(CartaoConsumacao cartao) {

        String sql = "UPDATE CARTAO SET SALDO = ? WHERE NUMERO = ?";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setDouble(1, cartao.getSaldo());
            preparar.setLong(2, cartao.getNumero());
            preparar.execute();
            preparar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    /**
     * Metodo que faz Movimentação de vendas com cartão consumacação pode ser
     * usado pra adicionar mais creditos ou baixar credidos, apenas mudando o
     * paremetro creditos (+/-)pra positivo ou negativo
     *
     * @param creditos
     * @param numero
     * @param usuario_id
     */
    public void vendas(double creditos, long numero, long usuario_id) {
        try {
            con.setAutoCommit(false);
            CartaoConsumacao cartao = new CartaoConsumacao(cartaoSAldo(numero) + creditos, numero, usuario_id);
            cartaoUpdate(cartao);
            if (cartaoSAldo(numero) > 0) {
                con.commit();
            }else{
                con.rollback();
            }
        } catch (SQLException ex) {
            {
                Logger.getLogger(CartaoConsumacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * metodo para consultar saldo de um cartao de consumação
     *
     * @param numero
     * @return saldo atual;
     */
    public double cartaoSAldo(long numero) {

        CartaoConsumacao cartao = new CartaoConsumacao();

        String sql = "SELECT * FROM CARTAO WHERE NUMERO = ?";
        try {
            preparar = con.prepareStatement(sql);
            //passando numero do cartão que vem do argumento
            preparar.setLong(1, numero);
            //pegando o resultado da consulta
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                cartao.setCartao_id(resultado.getLong("cartao_id"));
                cartao.setNumero(resultado.getLong("numero"));
                cartao.setSaldo(resultado.getFloat("saldo"));
            }
            preparar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cartao.getSaldo();
    }

    /**
     *
     */
}
