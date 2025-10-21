package br.senac.tads.dsw.dadospessoais;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.dsw.dadospessoais.persistence.entities.InteresseEntity;
import br.senac.tads.dsw.dadospessoais.persistence.entities.PessoaEntity;
import br.senac.tads.dsw.dadospessoais.persistence.repository.PessoaRepository;

@Service
public class PessoaServiceJpaImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<PessoaDto> findAll() {
        List<PessoaEntity> entities = pessoaRepository.findAll();
        List<PessoaDto> resultado = new ArrayList<>();
        for (PessoaEntity entity : entities) {
            PessoaDto dto = new PessoaDto();
            dto.setUsername(entity.getUsername());
            dto.setNome(entity.getNome());
            dto.setDataNascimento(entity.getDataNascimento());
            dto.setEmail(entity.getEmail());
            dto.setTelefone(entity.getTelefone());
            List<String> interesses = new ArrayList<>();
            if (entity.getInteresses() != null) {
                for (InteresseEntity interesseEntity : entity.getInteresses()) {
                    interesses.add(interesseEntity.getNome());
                }
                dto.setInteresses(interesses);
            }
            resultado.add(dto);
        }
        return resultado;
    }

    @Override
    public PessoaDto findByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaDto addNew(PessoaDto dto) {
        PessoaEntity entity = new PessoaEntity();
        entity.setUsername(dto.getUsername());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setSenha(dto.getSenha());
        // TODO: Setar interesses

        pessoaRepository.save(entity);
        return dto;
    }

    @Override
    public PessoaDto update(String username, PessoaDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String username) {
        // TODO Auto-generated method stub
        
    }

}
