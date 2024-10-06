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

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.IdosoEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.service.IdosoService;

@RestController
@RequestMapping("/idoso")
public class IdosoController {

    @Autowired
    private IdosoService idosoService;

    @PostMapping
    public ResponseEntity<IdosoEntity> criar(@RequestBody IdosoEntity idosoEntity) {
        IdosoEntity createdIdoso = idosoService.criar(idosoEntity);
        return ResponseEntity.status(201).body(createdIdoso); 
    }

    @GetMapping
    public ResponseEntity<List<IdosoEntity>> listar() {
        return ResponseEntity.ok(idosoService.list());
    }

    @DeleteMapping("/{cpfIdoso}")
    public ResponseEntity<Void> deletar(@PathVariable Long cpfIdoso) {
        idosoService.delete(cpfIdoso);
        return ResponseEntity.noContent().build(); 
    }

    @PutMapping("/{cpfIdoso}")
    public ResponseEntity<IdosoEntity> atualizar(@PathVariable Long cpfIdoso, @RequestBody IdosoEntity idosoEntity) {
        IdosoEntity updatedIdoso = idosoService.update(cpfIdoso, idosoEntity);
        return ResponseEntity.ok(updatedIdoso);
    }

    @PatchMapping("/{cpfIdoso}")
    public ResponseEntity<IdosoEntity> atualizarParcialmente(@PathVariable Long cpfIdoso, @RequestBody IdosoEntity updates) {
        IdosoEntity updatedIdoso = idosoService.atualizarParcialmente(cpfIdoso, updates);
        return updatedIdoso != null ? ResponseEntity.ok(updatedIdoso) : ResponseEntity.notFound().build();
    }
}
