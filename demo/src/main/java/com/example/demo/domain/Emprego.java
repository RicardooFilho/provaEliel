package com.example.demo.domain;

import com.example.demo.dto.EmpregoDTO;
import com.example.demo.service.PessoaService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Emprego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public EmpregoDTO toDTO() {

        return new EmpregoDTO(id, endereco);
    }
}
