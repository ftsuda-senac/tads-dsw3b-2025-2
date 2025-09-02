package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExemploController {

    @GetMapping(path = "/jackson2")
    public Dados gerarJsonComJackson2( @RequestParam("nome") String nome,
            @RequestParam("email") String email, @RequestParam("time") String time) {
        return new Dados(nome, email, 
            LocalDateTime.now(), time);
    }

}
