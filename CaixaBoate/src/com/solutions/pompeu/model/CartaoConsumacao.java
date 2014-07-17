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

/**
 *
 * @author Pompeu
 */
public class CartaoConsumacao {

    private long cartao_id;
    private double saldo;
    private long usurario_id;

    public CartaoConsumacao() {
    }

    public CartaoConsumacao(double saldo, long cartao_id) {
        this.saldo = saldo;
        this.cartao_id = cartao_id;
    }

    public CartaoConsumacao(long cartao_id, double saldo, long usurario_id) {
        this.cartao_id = cartao_id;
        this.saldo = saldo;
        this.usurario_id = usurario_id;
    }

    public long getCartao_id() {
        return cartao_id;
    }

    public void setCartao_id(long cartao_id) {
        this.cartao_id = cartao_id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long getUsurario_id() {
        return usurario_id;
    }

    public void setUsurario_id(long usurario_id) {
        this.usurario_id = usurario_id;
    }

}
