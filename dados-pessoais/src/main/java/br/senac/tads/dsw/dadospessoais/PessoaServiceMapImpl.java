package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public class PessoaServiceMapImpl implements PessoaService {

    private Map<String, PessoaDto> mapPessoas;

    public PessoaServiceMapImpl() {
        mapPessoas = new HashMap<>();
        mapPessoas.put("fulano",
            new PessoaDto("fulano", "Fulano da Silva", LocalDate.parse("2000-10-20"),
            "fulano@email.com", "11 91234-1234", List.of("Java", "Spring Boot"),
            "Abcd1234"));
        mapPessoas.put("ciclano",
            new PessoaDto("ciclano", "Ciclano de Souza", LocalDate.parse("1999-05-25"),
            "ciclano@email.com", "11 98765-8765", List.of("HTML", "CSS", "Javascript"),
            "Abcd1234"));
        mapPessoas.put("beltrana",
            new PessoaDto("beltrana", "Beltrana dos Santos", LocalDate.parse("2001-02-14"),
            "beltrana@email.com", "11 91122-1122", List.of("Javascript", "React", "Angular"),
            "Abcd1234"));
    }

    @Override
    public List<PessoaDto> findAll() {
        return new ArrayList<>(mapPessoas.values());
    }

    @Override
    public PessoaDto findByUsername(String username) {
        return mapPessoas.get(username);
    }

    @Override
    public PessoaDto addNew(PessoaDto dto) {
        mapPessoas.put(dto.getUsername(), dto);
        return dto;
    }

    @Override
    public PessoaDto update(String username, PessoaDto dto) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}
