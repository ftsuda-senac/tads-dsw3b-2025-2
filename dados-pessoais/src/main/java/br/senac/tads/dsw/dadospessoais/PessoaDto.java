package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.List;

public class PessoaDto {

    private String username;

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private String telefone;

    private List<String> interesses;

    private String senha;

    public PessoaDto() {
    }

    public PessoaDto(String username, String nome, LocalDate dataNascimento,
            String email, String telefone, List<String> interesses, String senha) {
        this.username = username;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.interesses = interesses;
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
