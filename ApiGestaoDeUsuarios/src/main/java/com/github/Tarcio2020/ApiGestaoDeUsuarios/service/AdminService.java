package com.github.Tarcio2020.ApiGestaoDeUsuarios.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Tarcio2020.ApiGestaoDeUsuarios.entities.AdminEntity;
import com.github.Tarcio2020.ApiGestaoDeUsuarios.repository.AdminRepository;

@Service
public class AdminService {
	
    @Autowired
    private AdminRepository adminRepository;
    
    public AdminEntity criar(AdminEntity adminEntity) { // Torne o método público
        return adminRepository.save(adminEntity);
    }
    
    public List<AdminEntity> list() { // Torne o método público
        return adminRepository.findAll();
    }
    
    public void delete(Long id_colaborador) { // Torne o método público
        adminRepository.deleteById(id_colaborador);
    }
    
    public AdminEntity update(Long id_colaborador, AdminEntity adminEntity) {
        adminEntity.setId_colaborador(id_colaborador);
        return adminRepository.save(adminEntity);
    }
    
    public AdminEntity atualizarParcialmente(Long id_colaborador, AdminEntity updates) {
        Optional<AdminEntity> optionalAdminEntity = adminRepository.findById(id_colaborador);

        if (optionalAdminEntity.isPresent()) {
            AdminEntity adminEntity = optionalAdminEntity.get();

            if (updates.getNome() != null) {
                adminEntity.setNome(updates.getNome());
            }
            if (updates.getFuncao() != null) {
                adminEntity.setFuncao(updates.getFuncao());
            }
            if (updates.getEmail() != null) {
                adminEntity.setEmail(updates.getEmail());
            }
            if (updates.getCpf() != null) {
                adminEntity.setCpf(updates.getCpf());
            }
            
            return adminRepository.save(adminEntity);
        } else {
            return null;
        }
    }
}
