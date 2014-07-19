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
     */
    public void produtoMovimentacaoinserir(long prod_id, long venda_id, int quant) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.produto_movimento_inserir(prod_id, venda_id, quant);
    }

    /**
     * Esse metodo atuliza prudotos da tablela de produto_movimentações
     *
     * @param prod_id
     * @param venda_id
     * @param quant
     */
    public void produtoMovimentacaoAtulizar(long prod_id, long venda_id, int quant) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.produto_movimento_atulizar(prod_id, venda_id, quant);
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

    /**
     * esse metodo retorna o id do usuario pegando o numero do cartão como
     * parametro
     *
     * @param numero_cartao
     * @return usuario_id;
     */
    public long pegarIdUsuarioProCartao(long numero_cartao) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        return cartaoDAO.listaCartao(numero_cartao).getUsuario_id();
    }

    /**
     * Esse metodo finaliza uma venda , atuliza o saldo do cartão
     *
     * @param venda_id
     * @param total_venda
     * @param cartao_id
     *
     */
    public void finalizarVendaCartao(long venda_id, double total_venda, long cartao_id) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        /*aulizando saldo do carão usando sue id*/
        atulizarSaldoCartaoPosvenda(-total_venda, cartao_id);
        cartaoDAO.finalizarVendaCartao(venda_id,total_venda, cartao_id);

    }

    public void atulizarSaldoCartaoPosvenda(double total_venda, long cartao_id) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        CartaoConsumacao cartao = new CartaoConsumacao(cartao_id,cartaoDAO.cartaoSAldo(cartao_id) + total_venda);
        cartaoDAO.cartaoUpdate(cartao);
   }

    /**
     * esse metodos cansela uma venda e deleta todos seus registros no banco
     *
     * @param total
     */
    public void cancelarVendaCartao(double total) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.cancelarVendaCartao(total);
    }
}
