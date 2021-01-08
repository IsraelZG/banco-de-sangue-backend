package com.igianesini.backend.dto;

import java.io.Serializable;

public class IMCPorIdadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer min;
	private Integer max;
	private Integer imcMedio;
	
	public IMCPorIdadeDTO() {
		
	}	
	
	public IMCPorIdadeDTO(Integer min, Integer max, Integer imcMedio) {
		super();
		this.min = min;
		this.max = max;
		this.imcMedio = imcMedio;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getImcMedio() {
		return imcMedio;
	}
	public void setImcMedio(Integer imcMedio) {
		this.imcMedio = imcMedio;
	}

	@Override
	public String toString() {
		return "IMCPorIdade [min=" + min + ", max=" + max + ", imcMedio=" + imcMedio + "]";
	}
	
}
