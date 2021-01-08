package com.igianesini.backend.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<EstadoDTO> candidatosPorEstado;
	private List<IMCPorIdadeDTO> imcPorIdade;
	private List<ObesosPorSexoDTO> obesosPorSexo;
	private List<IdadePorTipoSanguineoDTO> idadePorTipoSanguineo;
	private List<DoadoresPorReceptorDTO> doadoresPorReceptor;
	
	public ResponseDTO() {
		
	}

	public ResponseDTO(List<EstadoDTO> candidatosPorEstado, List<IMCPorIdadeDTO> imcPorIdade,
			List<ObesosPorSexoDTO> obesosPorSexo, List<IdadePorTipoSanguineoDTO> idadePorTipoSanguineo,
			List<DoadoresPorReceptorDTO> doadoresPorReceptor) {
		super();
		this.candidatosPorEstado = candidatosPorEstado;
		this.imcPorIdade = imcPorIdade;
		this.obesosPorSexo = obesosPorSexo;
		this.idadePorTipoSanguineo = idadePorTipoSanguineo;
		this.doadoresPorReceptor = doadoresPorReceptor;
	}

	public List<EstadoDTO> getCandidatosPorEstado() {
		return candidatosPorEstado;
	}

	public void setCandidatosPorEstado(List<EstadoDTO> candidatosPorEstado) {
		this.candidatosPorEstado = candidatosPorEstado;
	}

	public List<IMCPorIdadeDTO> getImcPorIdade() {
		return imcPorIdade;
	}

	public void setImcPorIdade(List<IMCPorIdadeDTO> imcPorIdade) {
		this.imcPorIdade = imcPorIdade;
	}

	public List<ObesosPorSexoDTO> getObesosPorSexo() {
		return obesosPorSexo;
	}

	public void setObesosPorSexo(List<ObesosPorSexoDTO> obesosPorSexo) {
		this.obesosPorSexo = obesosPorSexo;
	}

	public List<IdadePorTipoSanguineoDTO> getIdadePorTipoSanguineo() {
		return idadePorTipoSanguineo;
	}

	public void setIdadePorTipoSanguineo(List<IdadePorTipoSanguineoDTO> idadePorTipoSanguineo) {
		this.idadePorTipoSanguineo = idadePorTipoSanguineo;
	}

	public List<DoadoresPorReceptorDTO> getDoadoresPorReceptor() {
		return doadoresPorReceptor;
	}

	public void setDoadoresPorReceptor(List<DoadoresPorReceptorDTO> doadoresPorReceptor) {
		this.doadoresPorReceptor = doadoresPorReceptor;
	}

	@Override
	public String toString() {
		return "ResponseDTO [candidatosPorEstado=" + candidatosPorEstado + ", imcPorIdade=" + imcPorIdade
				+ ", obesosPorSexo=" + obesosPorSexo + ", idadePorTipoSanguineo=" + idadePorTipoSanguineo
				+ ", doadoresPorReceptor=" + doadoresPorReceptor + "]";
	}
}