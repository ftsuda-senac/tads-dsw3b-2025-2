package br.senac.tads.dsw.dadospessoais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.tads.dsw.dadospessoais.persistence.entities.InteresseEntity;
import br.senac.tads.dsw.dadospessoais.persistence.repository.InteresseRepository;

@RestController
@RequestMapping("/api/interesses")
@CrossOrigin(origins = "*")
public class InteresseRestController {

    @Autowired
    private InteresseRepository interesseRepository;

    @GetMapping
    public List<String> findAll() {
        return interesseRepository.findAll().stream() //
            .map(InteresseEntity::getNome).toList();
    }

    @PostMapping("/criar-todos")
    @Transactional
    public ResponseEntity<?> criarInteresses() {
        InteresseEntity i1 = new InteresseEntity(1, "Java");
        interesseRepository.save(i1);
        interesseRepository.save(new InteresseEntity(2, "Spring Boot"));
        interesseRepository.save(new InteresseEntity(3, "Javascript"));
        interesseRepository.save(new InteresseEntity(4, "HTML"));
        interesseRepository.save(new InteresseEntity(5, "CSS"));
        interesseRepository.save(new InteresseEntity(6, "SQL"));

        return ResponseEntity.ok().build();
    }

}
