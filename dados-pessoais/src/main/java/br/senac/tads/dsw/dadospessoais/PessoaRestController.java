package br.senac.tads.dsw.dadospessoais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pessoas")
public class PessoaRestController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<PessoaDto> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/apelido")
    public PessoaDto findByUsernameRequestParam(
            @RequestParam(value = "username", defaultValue = "beltrana") String u) {
        return service.findByUsername(u);
    }

    @GetMapping("/{username}")    
    public PessoaDto findByUsername(@PathVariable("username") String username) {
        PessoaDto pessoa = service.findByUsername(username);
        if (pessoa == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return pessoa;
    }



}
