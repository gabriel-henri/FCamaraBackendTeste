package com.gabriel.FCamaraBackendTeste.business.service;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import com.gabriel.FCamaraBackendTeste.infrastrucre.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public Veiculo pesquisarVeiculoPorPlaca(String placa){
            return veiculoRepository.findVeiculoByPlaca(placa)
                    .orElseThrow(() -> new RuntimeException("Veiculo com a placa " + placa + " não encontrado"));
    }

    public List<Veiculo> pesquisarVeiculos(){
        return veiculoRepository.findAll();
    }
}
