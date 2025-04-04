package com.gabriel.FCamaraBackendTeste.controller;

import com.gabriel.FCamaraBackendTeste.business.service.EstabelecimentoService;
import com.gabriel.FCamaraBackendTeste.infrastrucre.entities.Estabelecimento;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
    private final EstabelecimentoService estabelecimentoService;

    @PostMapping

    ResponseEntity<?> cadastrarEstabelecimento(@Valid @RequestBody Estabelecimento estabelecimento){
        try {
            return ResponseEntity.ok().body(
                    estabelecimentoService.cadastrarEstabelecimento(estabelecimento)
            );
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping
    ResponseEntity<List<Estabelecimento>> consultarEstabelecimentos(){
        return ResponseEntity.ok().body(estabelecimentoService.consultarEstabelecimentos());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> consultarEstabelecimentoPorId(@PathVariable long id){
        try {
            Estabelecimento estabelecimento = estabelecimentoService.consultarEstabelecimentoPorId(id);
            return ResponseEntity.ok().body(estabelecimento);
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estabelecimento> atualizarEstabelecimento(@PathVariable Long id, @RequestBody Estabelecimento estabelecimento){
        estabelecimento.setId(id);
        return ResponseEntity.ok().body(estabelecimentoService.atualizarEstabelecimento(estabelecimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstabelecimento(@PathVariable Long id){
        estabelecimentoService.removerEstabelecimento(id);
        return ResponseEntity.ok().build();
    }
}
