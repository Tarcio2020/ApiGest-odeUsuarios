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

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.AdminEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminEntity> criar(@RequestBody AdminEntity adminEntity) {
        AdminEntity createdAdmin = adminService.criar(adminEntity);
        return ResponseEntity.status(201).body(createdAdmin); 
    }

    @GetMapping
    public ResponseEntity<List<AdminEntity>> listar() {
        List<AdminEntity> admins = adminService.list();
        return ResponseEntity.ok(admins);
    }

    @DeleteMapping(value = "/{id_colaborador}")
    public ResponseEntity<Void> deletar(@PathVariable Long id_colaborador) {
        adminService.delete(id_colaborador);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id_colaborador}")
    public ResponseEntity<AdminEntity> patch(@PathVariable Long id_colaborador, @RequestBody AdminEntity updates) {
        AdminEntity updatedAdmin = adminService.atualizarParcialmente(id_colaborador, updates);

        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();  
        }
    }

    @PutMapping(value = "/{id_colaborador}")
    public ResponseEntity<AdminEntity> update(@PathVariable Long id_colaborador, @RequestBody AdminEntity adminEntity) {
        AdminEntity updatedAdmin = adminService.update(id_colaborador, adminEntity);
        return ResponseEntity.ok(updatedAdmin);
    }
}
