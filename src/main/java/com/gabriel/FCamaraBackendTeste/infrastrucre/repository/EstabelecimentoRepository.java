package com.gabriel.FCamaraBackendTeste.infrastrucre.repository;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    boolean existsByCnpj(String cnpj);

    Optional<Estabelecimento> findByCnpj(String cnpj);
}
