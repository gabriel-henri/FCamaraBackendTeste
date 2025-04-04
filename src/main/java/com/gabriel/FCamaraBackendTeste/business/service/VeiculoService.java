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

    public Veiculo cadastrarVeiculo(Veiculo veiculo){
        if(veiculoRepository.existsByPlaca(veiculo.getPlaca())){
            throw new IllegalArgumentException("O veiculo " + veiculo.getPlaca() + " já está cadastrado");
        }
        return veiculoRepository.save(veiculo);
    }

    public Veiculo consultarVeiculoPorId(Long id){
            return veiculoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Veiculo com a placa " + id + " não encontrado"));
    }

    public Veiculo consultarVeiculoPorPlaca(String placa){
        return veiculoRepository.findVeiculoByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo com a placa " + placa + " não encontrado"));
    }

    public List<Veiculo> consultarVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo atualizarVeiculo(Veiculo newVeiculo){
        Veiculo oldVeiculo = consultarVeiculoPorId(newVeiculo.getId());

        oldVeiculo.setMarca(newVeiculo.getMarca());
        oldVeiculo.setCor(newVeiculo.getCor());
        oldVeiculo.setTipo(newVeiculo.getTipo());
        oldVeiculo.setModelo(newVeiculo.getModelo());

        return veiculoRepository.save(oldVeiculo);
    }

    public void removerVeiculo(Long id){
        veiculoRepository.deleteById(id);
    }
}
