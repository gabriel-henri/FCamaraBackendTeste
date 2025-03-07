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

    @GetMapping("/{id}")
    public ResponseEntity<?> pesquisarVeiculoPorId(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(veiculoService.consultarVeiculoPorId(id));
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> pesquisarVeiculos(){
        return ResponseEntity.ok().body(veiculoService.consultarVeiculos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo){
        veiculo.setId(id);
        return ResponseEntity.ok(veiculoService.atualizarVeiculo(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Long id){
        veiculoService.removerVeiculo(id);
        return ResponseEntity.ok().build();
    }
}
