package com.gabriel.FCamaraBackendTeste.controller;

import com.gabriel.FCamaraBackendTeste.business.service.VeiculoService;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Veiculo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{placa}")
    public ResponseEntity<?> pesquisarVeiculoPorPlaca(@PathVariable String placa){
        try{
            return ResponseEntity.ok().body(veiculoService.pesquisarVeiculoPorPlaca(placa));
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> pesquisarVeiculos(){
        return ResponseEntity.ok().body(veiculoService.pesquisarVeiculos());
    }

    @PutMapping
    public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.ok(veiculoService.atualizarVeiculo(veiculo));
    }
}
