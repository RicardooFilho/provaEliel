package com.example.demo.controller;

import com.example.demo.domain.Emprego;
import com.example.demo.domain.Pessoa;
import com.example.demo.dto.EmpregoDTO;
import com.example.demo.dto.PessoaDTO;
import com.example.demo.service.EmpregoService;
import com.example.demo.service.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/empregos")
@AllArgsConstructor
public class EmpregoController {

    private final EmpregoService service;

    @GetMapping
    public ResponseEntity<List<EmpregoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpregoDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpregoDTO> create(@RequestBody @Valid Emprego emprego) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(emprego));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpregoDTO> update(@PathVariable(value = "id") Long id, @RequestBody @Valid Emprego emprego) {
        return ResponseEntity.ok(service.update(id, emprego));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
