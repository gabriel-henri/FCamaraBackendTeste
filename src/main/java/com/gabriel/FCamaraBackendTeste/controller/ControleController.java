package com.gabriel.FCamaraBackendTeste.controller;

import com.gabriel.FCamaraBackendTeste.business.service.ControleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador")
@RequiredArgsConstructor
public class ControleController {
    private final ControleService controleService;

    @PostMapping
    public ResponseEntity<String> entradaVeiculo(@RequestParam String placa, @RequestParam String cnpj){
        try {
            return ResponseEntity.ok().body(controleService.entradaVeiculo(placa, cnpj));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<String> saidaVeiculo(@RequestParam String placa, @RequestParam String cnpj){
        try {
            return ResponseEntity.ok().body(controleService.saidaVeiculo(placa, cnpj));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
