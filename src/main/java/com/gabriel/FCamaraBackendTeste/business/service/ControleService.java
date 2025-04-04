package com.gabriel.FCamaraBackendTeste.business.service;

import com.gabriel.FCamaraBackendTeste.infrastrucre.Enums.VeiculoTipo;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Controle;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import com.gabriel.FCamaraBackendTeste.infrastrucre.repository.ControleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ControleService {
    private final ControleRepository controleRepository;
    private final VeiculoService veiculoService;
    private final EstabelecimentoService estabelecimentoService;

    public String entradaVeiculo(String placaVeiculo, String cnpjEstabelecimento) throws Exception {
        Controle controlador;
        Veiculo veiculo = veiculoService.consultarVeiculoPorPlaca(placaVeiculo);
        Estabelecimento estabelecimento = estabelecimentoService.consultarEstabelecimentoPorCnpj(cnpjEstabelecimento);

        if (veiculo.getTipo() == VeiculoTipo.CARRO) {
            if (estabelecimento.getQuantidadeVagasCarros() > 0) {
                controlador = new Controle();
                controlador.setVeiculo(veiculo);
                controlador.setHorarioEntrada(LocalDateTime.now());
                controlador.setEstabelecimento(estabelecimento);
                estabelecimento.setQuantidadeVagasCarros(estabelecimento.getQuantidadeVagasCarros() - 1);
                estabelecimentoService.atualizarEstabelecimento(estabelecimento);
                controleRepository.save(controlador);

                return "Veiculo " + placaVeiculo + " alocado no estabelecimento " + cnpjEstabelecimento;
            }else {
                throw new Exception("Quantidade de vagas chegou ao limite");
            }
        } else{
            if (estabelecimento.getQuantidadeVagasMotos() > 0) {
                controlador = new Controle();
                controlador.setVeiculo(veiculo);
                controlador.setEstabelecimento(estabelecimento);
                controlador.setHorarioEntrada(LocalDateTime.now());
                estabelecimento.setQuantidadeVagasMotos(estabelecimento.getQuantidadeVagasMotos() - 1);
                estabelecimentoService.atualizarEstabelecimento(estabelecimento);
                controleRepository.save(controlador);

                return "Veiculo " + placaVeiculo + " alocado no estabelecimento " + cnpjEstabelecimento;
            } else {
                throw new Exception("Quantidade de vagas chegou ao limite");
            }
        }
    }

    public String saidaVeiculo(String placaVeiculo, String cnpjEstabelecimento) throws Exception{
        List<Controle> controlador;
        Veiculo veiculo = veiculoService.consultarVeiculoPorPlaca(placaVeiculo);
        Estabelecimento estabelecimento = estabelecimentoService.consultarEstabelecimentoPorCnpj(cnpjEstabelecimento);

        controlador = controleRepository.findByVeiculoAndEstabelecimento(veiculo, estabelecimento);

        if(controlador.isEmpty()){
            return "Veiculo ou estabelecimento não encontrados";
        }

        for(Controle controle : controlador){
            if(controle.getHorarioSaida() == null){
                controle.setHorarioSaida(LocalDateTime.now());
                controleRepository.save(controle);
                return "Veiculo " + veiculo.getPlaca() + " saiu do estabelecimento " + estabelecimento.getCnpj();
            }
        }

        return "Veiculo " + veiculo.getPlaca() + " não se encontra no estabelecimento " + estabelecimento.getCnpj();
    }
}
