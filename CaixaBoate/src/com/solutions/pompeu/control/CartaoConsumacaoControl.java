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

import com.solutions.pompeu.model.CartaoConsumacaoDAO;

/**
 *
 * @author Pompeu
 */
public class CartaoConsumacaoControl {

    /**
     * esse metodo pega no proximo Id de uma venda e faz a e retorna seu valor
     *
     * @return o valor da proxima venda do barnco
     */
    public Long pegarNovoIdVenda() {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.inserirIdVenda();
        return cartaoDAO.pegarNovoIdVenda();
    }

    /**
     * Esse metodo pode inserir produtos na tebela de produto_movimentações ele
     * paga o numero do id da Venda pelo metodo pegarNovoIdVenda()
     *
     * @param prod_id
     * @param venda_id
     * @param quant
     * @param total
     */
    public void produtoMovimentacaoinserir(long prod_id, long venda_id, int quant, double total) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.produto_movimento_inserir(prod_id, venda_id, quant, total);
    }

    /**
     * Esse metodo atuliza prudotos da tablela de produto_movimentações
     *
     * @param prod_id
     * @param venda_id
     * @param quant
     * @param total
     */
    public void produtoMovimentacaoAtulizar(long prod_id,long venda_id, int quant, double total) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.produto_movimento_atulizar(prod_id,venda_id, quant, total);
    }
    
    /**
     * Esse metodo deleta produtos da tabela de produto_movimentações
     *
     * @param venda_id
     * @param prod_id
     */
    public void produtoMovimentacaoDelatar(long venda_id, long prod_id) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.produto_movimento_deletar(venda_id, prod_id);
    }
}
