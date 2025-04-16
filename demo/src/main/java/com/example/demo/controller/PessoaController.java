package com.example.demo.controller;

import com.example.demo.domain.Pessoa;
import com.example.demo.dto.PessoaDTO;
import com.example.demo.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable(value = "id") Long id, @RequestBody @Valid Pessoa pessoa) {
        return ResponseEntity.ok(service.update(id, pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
