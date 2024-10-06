package com.github.Tarcio2020.ApiGestaoDeUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.IdosoEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.repository.IdosoRepository;

@Service
public class IdosoService {

    @Autowired
    private IdosoRepository idosoRepository;

    public IdosoEntity criar(IdosoEntity idosoEntity) {
        return idosoRepository.save(idosoEntity);
    }
    
    public List<IdosoEntity> list() {
        return idosoRepository.findAll();
    }
    
    public void delete(Long cpfIdoso) {
        idosoRepository.deleteById(cpfIdoso);
    }
    
    public IdosoEntity update(Long cpfIdoso, IdosoEntity idosoEntity) {
        idosoEntity.setCpfIdoso(cpfIdoso);
        return idosoRepository.save(idosoEntity);
    }
    
    public IdosoEntity atualizarParcialmente(Long cpfIdoso, IdosoEntity updates) {
        Optional<IdosoEntity> optionalIdosoEntity = idosoRepository.findById(cpfIdoso);

        if (optionalIdosoEntity.isPresent()) {
            IdosoEntity idosoEntity = optionalIdosoEntity.get(); 
            if (updates.getNome() != null) {
                idosoEntity.setNome(updates.getNome());
            }
            if (updates.getIdade() >= 0 && updates.getIdade() <= 999) { 
                idosoEntity.setIdade(updates.getIdade());
            }
            if (updates.getSexo() != null) {
                idosoEntity.setSexo(updates.getSexo());
            }
            if (updates.getTipoSanguineo() != null) {
                idosoEntity.setTipoSanguineo(updates.getTipoSanguineo());
            }
            if (updates.getNecessidades() != null) {
                idosoEntity.setNecessidades(updates.getNecessidades());
            }

            return idosoRepository.save(idosoEntity);
        } else {
            return null; // Ou lance uma exceção adequada
        }
    }
}
