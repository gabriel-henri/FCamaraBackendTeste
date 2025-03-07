package com.gabriel.FCamaraBackendTeste.infrastrucre.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="veiculos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String placa;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String cor;

    @NotBlank
    private String tipo;
}
