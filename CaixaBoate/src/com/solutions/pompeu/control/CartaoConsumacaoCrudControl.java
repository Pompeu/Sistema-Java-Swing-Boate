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
package com.solutions.pompeu.control;

import com.solutions.pompeu.model.CartaoConsumacao;
import com.solutions.pompeu.model.CartaoConsumacaoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Pompeu
 */
public class CartaoConsumacaoCrudControl {

    public void cadastraCartao(long id, String nome, double saldo) {
        CartaoConsumacao cartaoConsumacao = new CartaoConsumacao(id, saldo);
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.cadastraCartao(cartaoConsumacao);
    }

    public void atulizarCartao(long id, double saldo) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        CartaoConsumacao cartao = new CartaoConsumacao(id, cartaoDAO.cartaoSAldo(id) + saldo);
        cartaoDAO.cartaoUpdate(cartao);
    }

    public void deletarCartao(long id) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        CartaoConsumacao cartao = new CartaoConsumacao();
        cartao.setCartao_id(id);
        cartaoDAO.deltarCartao(cartao);
    }

    public CartaoConsumacao buscaPorNumero(long numero) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        CartaoConsumacao cartao = cartaoDAO.BuscarCartao(numero);
        return cartao;
    }

    public ArrayList ListaTodos() {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        return cartaoDAO.ListaTodos();
    }

}