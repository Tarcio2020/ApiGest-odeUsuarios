package com.github.Tarcio2020.ApiGestaoDeUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.EnderecoEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoEntity criar(EnderecoEntity enderecoEntity) {
		return enderecoRepository.save(enderecoEntity);
	}
	
	public void delete(Long id_endereco) {
		enderecoRepository.deleteById(id_endereco);
	}
	
	public List<EnderecoEntity>lista() {
		return enderecoRepository.findAll();
	}
	
	public EnderecoEntity update(Long id_endereco, EnderecoEntity enderecoEntity) {
		enderecoEntity.setId(id_endereco);
		EnderecoEntity updateEnderecoEntity = enderecoRepository.save(enderecoEntity);
		return updateEnderecoEntity;
	}
	
	public EnderecoEntity atualizarParcialmente(Long id_endereco, EnderecoEntity updates) {
	    Optional<EnderecoEntity> optionalEndereco = enderecoRepository.findById(id_endereco);

	    if (optionalEndereco.isPresent()) {
	        EnderecoEntity enderecoEntity = optionalEndereco.get();

	        if (updates.getCidade() != null) enderecoEntity.setCidade(updates.getCidade());
	        if (updates.getBairro() != null) enderecoEntity.setBairro(updates.getBairro());
	        if (updates.getRua() != null) enderecoEntity.setRua(updates.getRua());
	        if (updates.getNumero() != null) enderecoEntity.setNumero(updates.getNumero());
	        if (updates.getCep() != null) enderecoEntity.setCep(updates.getCep());
	        if (updates.getComplemento() != null) enderecoEntity.setComplemento(updates.getComplemento());

	        enderecoRepository.save(enderecoEntity);

	        return enderecoEntity;
	    } else {
	        return null;
	    }
	}

}
