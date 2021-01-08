package com.igianesini.backend.dto;

import java.io.Serializable;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public EstadoDTO() {
		
	}
	
	public EstadoDTO(String estado, Integer candidatos) {
		super();
		this.estado = estado;
		this.candidatos = candidatos;
	}

	private String estado;
	private Integer candidatos;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(Integer candidatos) {
		this.candidatos = candidatos;
	}
	
	@Override
	public String toString() {
		return "EstadoDTO [estado=" + estado + ", candidatos=" + candidatos + "]";
	}	
}
