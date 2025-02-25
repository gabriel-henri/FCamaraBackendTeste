package com.gabriel.FCamaraBackendTeste.infrastrucre.repository;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
    boolean existsByPlaca(String placa);
}
