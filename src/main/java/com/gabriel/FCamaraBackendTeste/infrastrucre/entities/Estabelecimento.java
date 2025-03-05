package com.gabriel.FCamaraBackendTeste.infrastrucre.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @NotBlank
    private String cnpj;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    private int quantidadeVagasCarro;

    private int quantidadeVagasMoto;
}
