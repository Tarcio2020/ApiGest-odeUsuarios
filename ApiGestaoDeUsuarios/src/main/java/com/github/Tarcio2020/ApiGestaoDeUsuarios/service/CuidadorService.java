package com.github.Tarcio2020.ApiGestaoDeUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.CuidadorEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.repository.CuidadorRepository;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    public CuidadorEntity criar(CuidadorEntity cuidadorEntity) {
        return cuidadorRepository.save(cuidadorEntity);
    }

    public void delete(Long cpfCuidador) {
        cuidadorRepository.deleteById(cpfCuidador);
    }

    public List<CuidadorEntity> lista() {
        return cuidadorRepository.findAll();
    }

    public CuidadorEntity update(Long cpfCuidador, CuidadorEntity cuidadorEntity) {
        cuidadorEntity.setCpfCuidador(cpfCuidador);
        return cuidadorRepository.save(cuidadorEntity);
    }

    public CuidadorEntity atualizarParcialmente(Long cpfCuidador, CuidadorEntity updates) {
        Optional<CuidadorEntity> optionalCuidador = cuidadorRepository.findById(cpfCuidador);

        if (optionalCuidador.isPresent()) {
            CuidadorEntity cuidadorEntity = optionalCuidador.get();

            if (updates.getNome() != null) {
                cuidadorEntity.setNome(updates.getNome());
            }
            if (updates.getIdade() >= 0 && updates.getIdade() <= 999) {
                cuidadorEntity.setIdade(updates.getIdade());
            }
            if (updates.getSexo() != null) {
                cuidadorEntity.setSexo(updates.getSexo());
            }
            if (updates.getTipoSanguineo() != null) {
                cuidadorEntity.setTipoSanguineo(updates.getTipoSanguineo());
            }
            if (updates.getNecessidades() != null) {
                cuidadorEntity.setNecessidades(updates.getNecessidades());
            }

            return cuidadorRepository.save(cuidadorEntity);
        } else {
            return null; // Ou lance uma exceção apropriada
        }
    }
}
