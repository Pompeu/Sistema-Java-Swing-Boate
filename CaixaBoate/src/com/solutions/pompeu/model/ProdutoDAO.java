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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class ProdutoDAO extends UsuarioDAO {

    /**
     * cadastrar produtos no sistema
     *
     * @param produto
     */
    public void cadProduto(Produto produto) {

        try {
            String sql = "INSERT INTO PRODUTOS(NOME_PRODUTO,PRECO_PRODUTO) VALUES (?,?)";
            preparar = con.prepareStatement(sql);
            preparar.setString(1, produto.getNome());
            preparar.setDouble(2, produto.getPreco());
            preparar.execute();
            preparar.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * metodo que faz exclusão de produtos no sistema
     *
     * @param produto
     */
    public void excluirProdutos(Produto produto) {

        try {
            String sql = "DELETE FROM PRODUTOS WHERE PRODUTO_ID = ?";
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, produto.getProduto_id());

            int x = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir um Produto");
            if (x == 0) {
                preparar.execute();
                preparar.close();
                con.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * esse metodo retorma num nome de um produto ele faz um busca usando o id
     *
     * @param id
     * @return nome
     */
    public Produto buscarProdutoId(long id) {
        Produto produto = new Produto();

        String sql = "SELECT * FROM PRODUTOS WHERE PRODUTO_ID = ?";

        try {
            preparar = con.prepareStatement(sql);
            preparar.setLong(1, id);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                produto.setNome(resultado.getString("nome_produto"));
                produto.setPreco(resultado.getDouble("preco_produto"));
            }
            preparar.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return produto;

    }

    /**
     * Metodo que faz busca de todos produtos do sistema ordenados por id
     *
     * @return Lista de protudos
     */
    public List<Produto> buscarProdutos() {
        List<Produto> listaProduto = new ArrayList<>();

        String sql = "SELECT * FROM PRODUTOS ORDER BY PRODUTO_ID";
        try {
            preparar = con.prepareStatement(sql);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setProduto_id(resultado.getLong("PRODUTO_ID"));
                produto.setNome(resultado.getString("nome_produto"));
                produto.setPreco(resultado.getDouble("preco_produto"));
                listaProduto.add(produto);
            }
            preparar.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaProduto;
    }

}
