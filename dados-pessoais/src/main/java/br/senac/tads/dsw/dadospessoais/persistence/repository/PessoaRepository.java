package br.senac.tads.dsw.dadospessoais.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import br.senac.tads.dsw.dadospessoais.persistence.entities.PessoaEntity;
import java.util.List;
import java.util.Optional;


public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    Optional<PessoaEntity> findByUsername(String username);

    @Modifying
    void deleteByUsername(String username);

}
