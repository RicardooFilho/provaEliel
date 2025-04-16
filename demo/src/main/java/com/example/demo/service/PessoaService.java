package com.example.demo.service;

import com.example.demo.domain.Pessoa;
import com.example.demo.dto.PessoaDTO;
import com.example.demo.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public List<PessoaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(Pessoa::toDTO)
                .toList();
    }

    public PessoaDTO findById(Long id) {
        return repository.findById(id)
                .map(Pessoa::toDTO)
                .orElseThrow(EntityNotFoundException::new);
    }

    public PessoaDTO create(Pessoa newPessoa) {

        newPessoa.getEmpregos().forEach(emprego -> emprego.setPessoa(newPessoa));

        return repository.save(newPessoa).toDTO();
    }

    public PessoaDTO update(Long id, Pessoa newPessoa) {

        newPessoa.getEmpregos().forEach(emprego -> emprego.setPessoa(newPessoa));

        return repository.findById(id)
                .map(pessoa -> repository.save(newPessoa).toDTO())
                .orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
