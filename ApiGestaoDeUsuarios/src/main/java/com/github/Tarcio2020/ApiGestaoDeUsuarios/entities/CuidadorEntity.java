package com.github.Tarcio2020.ApiGestaoDeUsuarios.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CuidadorEntity {
	
    @Id
	private Long cpfCuidador;
	private String nome;
	private int idade;
	private String sexo;
	private String tipoSanguineo;
	private String necessidades;
	
	public Long getCpfCuidador() {
		return cpfCuidador;
	}
	public void setCpfCuidador(Long cpfCuidador) {
		this.cpfCuidador = cpfCuidador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipoSanguineo() {
		return tipoSanguineo;
	}
	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	public String getNecessidades() {
		return necessidades;
	}
	public void setNecessidades(String necessidades) {
		this.necessidades = necessidades;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpfCuidador);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorEntity other = (CuidadorEntity) obj;
		return Objects.equals(cpfCuidador, other.cpfCuidador);
	}	
}
