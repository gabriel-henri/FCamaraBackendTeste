package com.gabriel.FCamaraBackendTeste.business.service;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import com.gabriel.FCamaraBackendTeste.infrastrucre.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public void cadastrarVeiculo(Veiculo veiculo){
        if(veiculoRepository.existsByPlaca(veiculo.getPlaca())){
            throw new IllegalArgumentException("O veiculo " + veiculo.getPlaca() + " já está cadastrado");
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

    public Veiculo atualizarVeiculo(Veiculo newVeiculo){
        Veiculo oldVeiculo = pesquisarVeiculoPorPlaca(newVeiculo.getPlaca());

        oldVeiculo.setMarca(newVeiculo.getMarca());
        oldVeiculo.setCor(newVeiculo.getCor());
        oldVeiculo.setTipo(newVeiculo.getTipo());
        oldVeiculo.setModelo(newVeiculo.getModelo());

        return veiculoRepository.save(oldVeiculo);
    }

    public void removerVeiculo(String placa){
        veiculoRepository.deleteByPlaca(placa);
    }
}
