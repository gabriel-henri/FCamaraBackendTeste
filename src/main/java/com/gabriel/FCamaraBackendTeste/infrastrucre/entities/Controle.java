package com.gabriel.FCamaraBackendTeste.infrastrucre.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="controle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Controle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name="estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    private LocalDateTime horarioEntrada;

    private LocalDateTime horarioSaida;

}
