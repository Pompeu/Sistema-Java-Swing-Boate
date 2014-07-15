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
public class Produto {

    private long produto_id;
    private String nome;
    private double preco;

    public Produto() {
    }

    public Produto(long produto_id) {
        this.produto_id = produto_id;
    }

    public Produto(String nome, double preco) {
        this.nome = nome.toUpperCase();
        this.preco = preco;
    }

    public long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(long produto_id) {
        this.produto_id = produto_id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
