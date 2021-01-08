package com.igianesini.backend.dto;

public class DoadoresPorReceptorDTO {
	
	public DoadoresPorReceptorDTO() {
		
	}

	public DoadoresPorReceptorDTO(String receptor, Integer doadores) {
		super();
		this.receptor = receptor;
		this.doadores = doadores;
	}

	private String receptor;
	private Integer doadores;
	
	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public Integer getDoadores() {
		return doadores;
	}

	public void setDoadores(Integer doadores) {
		this.doadores = doadores;
	}

	@Override
	public String toString() {
		return "DoadoresPorReceptorDTO [receptor=" + receptor + ", doadores=" + doadores + "]";
	}
	
}
