/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutions.pompeu.model;

/**
 *
 * @author Pompeu
 */
public class Ingresso {

    private long id;
    private String tipo;
    private float preco;
    private String nomeEvento;

    public Ingresso() {
    }

    public Ingresso(String tipo,float preco, String nomeEvento) {
        this.tipo = tipo;
        this.preco = preco;
        this.nomeEvento = nomeEvento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

}
