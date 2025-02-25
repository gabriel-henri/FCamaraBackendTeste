package com.gabriel.FCamaraBackendTeste.controller;

import com.gabriel.FCamaraBackendTeste.business.service.VeiculoService;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {
    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<?> cadastrarVeiculo(@Valid @RequestBody Veiculo veiculo){
        try{
            veiculoService.cadastrarVeiculo(veiculo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Veiculo cadastrado com sucesso");
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
