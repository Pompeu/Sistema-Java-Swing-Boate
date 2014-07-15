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
public class Usuario {

    private long usuario_id;
    private String nome;
    private String login;
    private String senha;
    private String funcao;
    private String telefone;
    private String cpf;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha, String funcao, String telefone, String cpf) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.funcao = funcao;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + usuario_id + ", nome=" + nome
                + ", login=" + login + ", senha=" + senha
                + ", funcao=" + funcao + ", telefone=" + telefone
                + ", cpf=" + cpf + '}';
    }

}
