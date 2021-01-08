package com.igianesini.backend.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class TipoSanguineo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String[] recebeDe;
	
	public TipoSanguineo() {
		
	}

	public TipoSanguineo(String tipo_sanguineo, String[] recebeDe) {
		super();
		this.tipo = tipo_sanguineo;
		this.recebeDe = recebeDe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String[] getRecebeDe() {
		return recebeDe;
	}

	public void setRecebeDe(String[] recebeDe) {
		this.recebeDe = recebeDe;
	}

	@Override
	public String toString() {
		return "TipoSanguineo [tipo=" + tipo + ", recebeDe=" + recebeDe + "]";
	}	
}
