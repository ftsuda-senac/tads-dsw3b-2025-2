package br.senac.tads.dsw.dadospessoais;

import java.util.List;

public interface PessoaService {

    List<PessoaDto> findAll();

    PessoaDto findByUsername(String username);

    PessoaDto addNew(PessoaDto dto);

    PessoaDto update(String username, PessoaUpdateDto dto);

    void delete(String username);

}