package com.gabriel.FCamaraBackendTeste.infrastrucre.repository;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, String> {
    boolean existsByCnpj(String cnpj);
}
