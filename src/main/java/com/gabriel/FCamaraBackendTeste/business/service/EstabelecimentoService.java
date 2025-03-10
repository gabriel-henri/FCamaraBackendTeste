package com.gabriel.FCamaraBackendTeste.business.service;

import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import com.gabriel.FCamaraBackendTeste.infrastrucre.repository.EstabelecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {
    private final EstabelecimentoRepository estabelecimentoRepository;

    public Estabelecimento cadastrarEstabelecimento(Estabelecimento estabelecimento){
        if(estabelecimentoRepository.existsByCnpj(estabelecimento.getCnpj())){
            throw new IllegalArgumentException("O etabelecimento "
            + estabelecimento.getCnpj() + " já está cadastrado");
        }
        return estabelecimentoRepository.save(estabelecimento);
    }

    public List<Estabelecimento> consultarEstabelecimentos(){
        return estabelecimentoRepository.findAll();
    }

    public Estabelecimento consultarEstabelecimentoPorId(Long id){
        return estabelecimentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estabelecimento não registrado"));
    }


}
