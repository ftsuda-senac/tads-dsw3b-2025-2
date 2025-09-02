package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;
import java.util.List;

public record Dados(String nome, String email, LocalDateTime dataHoraAtual, String time) {

    public String getXpto() {
        return "xpto";
    }

    public List<String> getInteresses() {
        return List.of("Java", "Spring", "Javascript");
    }

}

// Record é equivalente a classe abaixo:
// Ambas geram objetos imutáveis, cujas propriedades não podem ser alteradas
// depois de setadas
// Diferença: para acessar informações, usar dados.nome() ao invés de dados.getNome()
/*
public class Dados {

    private final String nome;

    private final String email;

    private final LocalDateTime dataHoraAtual;

    public Dados(String nome, String email, LocalDateTime dataHoraAtual) {
        this.nome = nome;
        this.email = email;
        this.dataHoraAtual = dataHoraAtual;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataHoraAtual() {
        return dataHoraAtual;
    }
}
*/
