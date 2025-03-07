package com.gabriel.FCamaraBackendTeste.infrastrucre.repository;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    boolean existsByPlaca(String placa);
}
