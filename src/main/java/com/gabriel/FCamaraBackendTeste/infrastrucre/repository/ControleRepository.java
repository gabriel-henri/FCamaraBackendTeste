package com.gabriel.FCamaraBackendTeste.infrastrucre.repository;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Controle;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ControleRepository extends JpaRepository<Controle, Long> {
    List<Controle> findByVeiculoAndEstabelecimento(Veiculo veiculo, Estabelecimento etabelecimento);
}
