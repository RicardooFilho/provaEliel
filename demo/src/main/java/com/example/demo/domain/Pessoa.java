package com.example.demo.domain;

import com.example.demo.dto.EmpregoDTO;
import com.example.demo.dto.PessoaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Long idade;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprego> empregos = new ArrayList<>();

    public PessoaDTO toDTO() {

        List<EmpregoDTO> empregosDTO = this.empregos
                .stream()
                .map(Emprego::toDTO)
                .toList();

        return new PessoaDTO(id, nome, idade, empregosDTO);
    }
}
