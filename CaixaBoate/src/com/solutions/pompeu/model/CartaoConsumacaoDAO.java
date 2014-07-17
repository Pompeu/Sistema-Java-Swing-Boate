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
     * Esse metodo pega o ID da priximo venda
     *
     * @return o numero do ID + 1
     */
    public Long pegarNovoIdVenda() {
        long vendaID = 0;
        String sql = "SELECT MAX(VENDA_ID) FROM VENDAS_CARTAO_CONS";
        try {
            preparar = con.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                vendaID = resultado.getLong("MAX");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return vendaID + 1;
    }

    /**
     * esse metodo faz a inserção apenas do novo ID de venda
     *
     * @return retorna no novo id de venda
     */
    public long inserirIdVenda() {
        long venda_id = pegarNovoIdVenda();

        String sql = "INSERT INTO VENDAS_CARTAO_CONS(VENDA_ID,DATA_VENDA)"
                + "VALUES (?,NOW())";
        try {

            preparar = con.prepareStatement(sql);
            preparar.setLong(1, venda_id);
            preparar.execute();
            preparar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return venda_id;
    }

    /**
     * inciar saldo do cartão
     *
     * @param cartao
     */
    public void cartaoStart(CartaoConsumacao cartao) {

        String sql = "INSERT INTO CARTOES(CARTAO_ID , SALDO_CARTAO) VALUES(?,?)";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, cartao.getCartao_id());
            preparar.setDouble(2, cartao.getSaldo());
            preparar.execute();
            preparar.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cartão Iniciado Com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    /**
     * Metodo que faz um select entre usuario e o cartão e retorna um usuario
     * doto de um cartão
     *
     *
     * @param numero de cartão
     * @return nome de usuario
     */
    public Usuario listaCartao(long numero) {
        CartaoConsumacao cartao = new CartaoConsumacao();
        Usuario usuario = new Usuario();

        Map<CartaoConsumacao, Usuario> cartaoUsuario = new HashMap<>();

        String sql = "SELECT * FROM USUARIO_CARTAO WHERE CARTAO_ID= ?";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, numero);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {

                usuario.setNome(resultado.getString("nome_usuario"));
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

        String sql = "UPDATE CARTOES SET SALDO_CARTAO = ? WHERE CARTAO_ID = ?";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setDouble(1, cartao.getSaldo());
            preparar.setLong(2, cartao.getCartao_id());
            preparar.execute();
            preparar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    /**
     * Esse metodos prenche a table de movimentação com dos do JTable referente
     * os protudos vendidos
     *
     * @param prod_id
     * @param venda_id
     * @param quant
     */
    public void produto_movimento_inserir(long prod_id, long venda_id, int quant) {

        String sql = "INSERT INTO PROD_MOV (PRODUTO_ID,VENDA_ID,QUANT_PROD)"
                + "VALUES(?,?,?)";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, prod_id);
            preparar.setLong(2, venda_id);
            preparar.setInt(3, quant);
            preparar.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * esse metodo retorna o ID de uma movimentacão para que passa ser feito um
     * update de um produto na tabela produtdo_movimentação esse metodo deve
     * deixar a conexão aberta.
     *
     * @param venda_id
     * @param produto_id
     * @return id de uma movimentação
     */
    public long pegarIdProdutoAtual(long produto_id, long venda_id) {
        long mov_id = 0;

        String sql = "SELECT * FROM PROD_MOV WHERE  PRODUTO_ID = ? AND VENDA_ID = ?";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, produto_id);
            preparar.setLong(2, venda_id);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                mov_id = resultado.getLong("PROD_MOV_ID");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return mov_id;
    }

    /**
     * Esse metodo faz upade na tabela de produtos movimentação no banco de
     * dados recebendo o valor da linha do Jtable como argumentos
     *
     *
     * @param prod_id
     * @param venda_id
     * @param quant
     */
    public void produto_movimento_atulizar(long prod_id, long venda_id, int quant) {

        long prodModId = pegarIdProdutoAtual(prod_id, venda_id);
        System.out.println(prodModId);
        String sql = "UPDATE PROD_MOV SET QUANT_PROD = ?"
                + "WHERE PROD_MOV_ID = ?";
        try {
            preparar = con.prepareStatement(sql);
            preparar.setInt(1, quant);
            preparar.setLong(2, prodModId);
            preparar.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Esee metodo recebe o numero do prod_mov_id e deleta o protudo do JTble e
     * do banco de dados
     *
     * @param venda_id
     * @param prod_id
     */
    public void produto_movimento_deletar(long venda_id, long prod_id) {

        String sql = "DELETE FROM PROD_MOV WHERE VENDA_ID  = ? AND PRODUTO_ID = ?";
        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, venda_id);
            preparar.setLong(2, prod_id);
            preparar.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * esse metodos atuliza a tabela de vendas_cartao_cons e comita os dados no
     * bancos.
     *
     * @param venda_id
     * @param total
     * @param cartao_id
     */
    public void finalizarVendaCartao(long venda_id, double total, long cartao_id) {
        String sql = "UPDATE VENDAS_CARTAO_CONS SET TOTAL_VENDA_CARTAO = ? , CARTAO_ID = ?"
                + "WHERE VENDA_ID = ?";
        try {
            preparar = con.prepareStatement(sql);
            preparar.setDouble(1, total);
            preparar.setLong(2, cartao_id);
            preparar.setLong(3, venda_id);
            preparar.execute();
            int finaliza = JOptionPane.showConfirmDialog(null, "Confimar a Venda ?");
            if (finaliza == 0) {
                preparar.close();
                con.close();
            } else {
                /*Caso a a reposta da Mensagem Diago for não ou cancelar
                 a venda sera deletada*/
                cancelarVendaCartao(0);
            }
        } catch (SQLException ex) {
            cancelarVendaCartao(0);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }

    public void cancelarVendaCartao(double total) {

        String sql = "DELETE FROM PROD_MOV WHERE VENDA_ID = ?;"
                + "DELETE FROM VENDAS_CARTAO_CONS WHERE VENDA_ID = ?;";

        long venda_id = pegarNovoIdVenda() - 1;

        if (total == 0) {
            try {

                preparar = con.prepareStatement(sql);
                preparar.setLong(1, venda_id);
                preparar.setLong(2, venda_id);
                preparar.execute();
                preparar.close();
                JOptionPane.showMessageDialog(null, "Venda Cancelada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
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

        String sql = "SELECT * FROM CARTOES WHERE CARTAO_ID = ?";
        try {
            preparar = con.prepareStatement(sql);
            //passando numero do cartão que vem do argumento
            preparar.setLong(1, numero);
            //pegando o resultado da consulta
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                cartao.setCartao_id(resultado.getLong("cartao_id"));
                cartao.setSaldo(resultado.getFloat("saldo_cartao"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cartao.getSaldo();
    }

}
