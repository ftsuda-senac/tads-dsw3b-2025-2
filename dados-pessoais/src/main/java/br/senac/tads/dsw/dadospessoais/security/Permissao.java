package br.senac.tads.dsw.dadospessoais.security;

import org.springframework.security.core.GrantedAuthority;

public class Permissao implements GrantedAuthority {

    private String nome;

    public Permissao() {
    }

    public Permissao(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }

}
