package com.gabriel.FCamaraBackendTeste.business.service;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import com.gabriel.FCamaraBackendTeste.infrastrucre.repository.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {
    private final EstabelecimentoRepository estabelecimentoRepository;

    public void cadastrarEstabelecimento(Estabelecimento estabelecimento){
        if(estabelecimentoRepository.existsByCnpj(estabelecimento.getCnpj())){
            throw new IllegalArgumentException("O estabelecimento " + estabelecimento.getCnpj() + " já está cadastrado");
        }
        estabelecimentoRepository.save(estabelecimento);
    }
}
