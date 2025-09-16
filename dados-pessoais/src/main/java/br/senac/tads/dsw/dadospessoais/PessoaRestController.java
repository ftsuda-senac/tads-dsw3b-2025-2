package br.senac.tads.dsw.dadospessoais;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Pessoa %s não encontrada".formatted(username));
        }
        return pessoa;
    }

    @PostMapping
    public ResponseEntity<PessoaDto> addNew(@RequestBody PessoaDto input) {
        PessoaDto pessoa = service.addNew(input);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{username}")
            .buildAndExpand(pessoa.getUsername())
            .toUri();
        return ResponseEntity.created(location).build();
    }

}
 