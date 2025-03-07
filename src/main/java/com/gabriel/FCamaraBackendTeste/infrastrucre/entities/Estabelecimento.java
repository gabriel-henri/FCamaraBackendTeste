package com.gabriel.FCamaraBackendTeste.infrastrucre.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="estabelecimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String cnpj;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    private Integer quantidadeVagasCarros;

    private Integer quantidadeVagasMotos;

}
