package com.example.demo.dto;

import lombok.NoArgsConstructor;

import java.util.List;

public record PessoaDTO(
        Long id,
        String nome,
        Long idade,
        List<EmpregoDTO> empregos
) {
}
