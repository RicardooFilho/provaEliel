package com.example.demo.service;

import com.example.demo.domain.Emprego;
import com.example.demo.domain.Pessoa;
import com.example.demo.dto.EmpregoDTO;
import com.example.demo.repository.EmpregoRepository;
import com.example.demo.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpregoService {

    private final EmpregoRepository repository;

    public List<EmpregoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(Emprego::toDTO)
                .toList();
    }

    public EmpregoDTO findById(Long id) {
        return repository.findById(id)
                .map(Emprego::toDTO)
                .orElseThrow(EntityNotFoundException::new);
    }

    public EmpregoDTO create(Emprego newEmprego) {
        return repository.save(newEmprego).toDTO();
    }

    public EmpregoDTO update(Long id, Emprego newEmprego) {

        return repository.findById(id)
                .map(pessoa -> repository.save(newEmprego).toDTO())
                .orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
