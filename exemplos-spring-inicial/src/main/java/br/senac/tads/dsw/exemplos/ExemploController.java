package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ExemploController {

    private final GeradorSaida geradorSaida;

    @Autowired
    private ObjectMapper objectMapper;

    // Se existir somente este construtor,
    // Spring injeta o bean através dele
    public ExemploController(GeradorSaida geradorSaida) {
        this.geradorSaida = geradorSaida;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public String gerarJson(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email) {
        Dados dados = new Dados(nome, email, 
            LocalDateTime.now(), "Bragantino");
        return geradorSaida.gerarSaida(dados);
    }

    @GetMapping(path = "/jackson2", produces = "application/json")
    @ResponseBody
    public String gerarJsonComJackson2( @RequestParam("nome") String nome,
            @RequestParam("email") String email, @RequestParam("time") String time) {
        Dados dados = new Dados(nome, email, 
            LocalDateTime.now(), time);
        try {
            String json = objectMapper.writeValueAsString(dados);
            return json;
        } catch (Exception ex) {
            return "";
        }
    }

}
