package com.gabriel.FCamaraBackendTeste.controller;

import com.gabriel.FCamaraBackendTeste.business.service.EstabelecimentoService;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
    private final EstabelecimentoService estabelecimentoService;

    @PostMapping
    ResponseEntity<?> cadastrarEstabelecimento(@Valid @RequestBody Estabelecimento estabelecimento){
        try {
            estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
            return ResponseEntity.ok().body("Estabelecimento cadastrado com sucesso");
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
