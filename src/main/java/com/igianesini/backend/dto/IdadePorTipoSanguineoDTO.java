package com.igianesini.backend.dto;

import java.io.Serializable;

public class IdadePorTipoSanguineoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tipo_sanguineo;
	private Integer idadeMedia;
	
	public IdadePorTipoSanguineoDTO() {
		
	}

	public IdadePorTipoSanguineoDTO(String tipo_sanguineo, Integer idadeMedia) {
		super();
		this.tipo_sanguineo = tipo_sanguineo;
		this.idadeMedia = idadeMedia;
	}

	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}

	public Integer getIdadeMedia() {
		return idadeMedia;
	}

	public void setIdadeMedia(Integer idadeMedia) {
		this.idadeMedia = idadeMedia;
	}

	@Override
	public String toString() {
		return "IdadePorTipoSanguineoDTO [tipo_sanguineo=" + tipo_sanguineo + ", idadeMedia=" + idadeMedia + "]";
	}	
}
