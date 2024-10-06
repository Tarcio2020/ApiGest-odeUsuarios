package com.github.Tarcio2020.ApiGestaoDeUsuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.CuidadorEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.service.CuidadorService;

@RestController
@RequestMapping("/cuidador")
public class CuidadorController {

    @Autowired
    private CuidadorService cuidadorService;

    @PostMapping
    public ResponseEntity<CuidadorEntity> criar(@RequestBody CuidadorEntity cuidadorEntity) {
        CuidadorEntity createdCuidador = cuidadorService.criar(cuidadorEntity);
        return ResponseEntity.status(201).body(createdCuidador); 
    }

    @GetMapping
    public ResponseEntity<List<CuidadorEntity>> listar() {
        List<CuidadorEntity> cuidadores = cuidadorService.lista();
        return ResponseEntity.ok(cuidadores);
    }

    @DeleteMapping(value = "/{cpfCuidador}")
    public ResponseEntity<Void> deletar(@PathVariable Long cpfCuidador) {
        cuidadorService.delete(cpfCuidador);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{cpfCuidador}")
    public ResponseEntity<CuidadorEntity> patch(@PathVariable Long cpfCuidador, @RequestBody CuidadorEntity updates) {
        CuidadorEntity updatedCuidador = cuidadorService.atualizarParcialmente(cpfCuidador, updates);

        if (updatedCuidador != null) {
            return ResponseEntity.ok(updatedCuidador);
        } else {
            return ResponseEntity.notFound().build();  
        }
    }

    @PutMapping(value = "/{cpfCuidador}")
    public ResponseEntity<CuidadorEntity> update(@PathVariable Long cpfCuidador, @RequestBody CuidadorEntity cuidadorEntity) {
        CuidadorEntity updatedCuidador = cuidadorService.update(cpfCuidador, cuidadorEntity);
        return ResponseEntity.ok(updatedCuidador);
    }
}
