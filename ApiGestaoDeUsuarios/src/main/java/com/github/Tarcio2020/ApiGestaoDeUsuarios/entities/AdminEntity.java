package com.github.Tarcio2020.ApiGestaoDeUsuarios.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_colaborador;
	private String nome;
	private String funcao;
	private String email;
	private String cpf;
	
	@Override
	public int hashCode() {
		return Objects.hash(id_colaborador);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminEntity other = (AdminEntity) obj;
		return Objects.equals(id_colaborador, other.id_colaborador);
	}
	
	public Long getId_colaborador() {
		return id_colaborador;
	}
	public void setId_colaborador(Long id_colaborador) {
		this.id_colaborador = id_colaborador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
