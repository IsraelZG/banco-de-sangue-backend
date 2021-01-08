package com.igianesini.backend.dto;

import java.io.Serializable;

public class ObesosPorSexoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sexo;
	private Integer percentual;
	
	public ObesosPorSexoDTO() {
		
	}
	
	public ObesosPorSexoDTO(String sexo, Integer percentual) {
		super();
		this.sexo = sexo;
		this.percentual = percentual;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getPercentual() {
		return percentual;
	}

	public void setPercentual(Integer percentual) {
		this.percentual = percentual;
	}

	@Override
	public String toString() {
		return "ObesosPorSexoDTO [sexo=" + sexo + ", percentual=" + percentual + "]";
	}
}
