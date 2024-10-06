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

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.EnderecoEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public EnderecoEntity criar(@RequestBody EnderecoEntity enderecoEntity) {
		return enderecoService.criar(enderecoEntity);
	}
	
	@GetMapping
	public List<EnderecoEntity>lista() {
		return enderecoService.lista();
	}
	
	@DeleteMapping(value = "/{id_endereco}")
	public ResponseEntity<Void>delete(@PathVariable Long id_endereco) {
		enderecoService.delete(id_endereco);
		return ResponseEntity.noContent().build();
	}
	
	   @PatchMapping(value = "/{id_endereco}")
	    public ResponseEntity<EnderecoEntity> patch(@PathVariable Long id_endereco, @RequestBody EnderecoEntity updates) {
	    	
		   EnderecoEntity enderecoEntity = enderecoService.atualizarParcialmente(id_endereco, updates);

	        if (enderecoEntity != null) {
	            
	            return ResponseEntity.ok(enderecoEntity);
	        } else {
	            return ResponseEntity.notFound().build();  
	        }
	    }
	   
	    @PutMapping(value = "/{id_endereco}")
	    public ResponseEntity<EnderecoEntity> update(@PathVariable Long id_endereco, @RequestBody EnderecoEntity enderecoEntity) {
	    	EnderecoEntity updatedEnderecoEntity = enderecoService.update(id_endereco, enderecoEntity);
	        return ResponseEntity.ok().body(updatedEnderecoEntity);
	    }
	
}
