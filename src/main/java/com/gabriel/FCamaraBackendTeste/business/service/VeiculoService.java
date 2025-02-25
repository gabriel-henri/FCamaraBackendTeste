package com.gabriel.FCamaraBackendTeste.business.service;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import com.gabriel.FCamaraBackendTeste.infrastrucre.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public void cadastrarVeiculo(Veiculo veiculo){
        if(veiculoRepository.existsByPlaca(veiculo.getPlaca())){
            throw new IllegalArgumentException("O veiculo já está cadastrado");
        }
        veiculoRepository.save(veiculo);
    }
}
