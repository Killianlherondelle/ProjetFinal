package fr.formation.projetfinal.dto;

import java.math.BigDecimal;

public class PerfDTO {
	
	private Long id;
	private BigDecimal parameterA;
	private BigDecimal parameterB;
	
	
	
	
	public PerfDTO() {
		//
	}
	public PerfDTO(BigDecimal parameterA, BigDecimal parameterB) {
		super();
		this.parameterA = parameterA;
		this.parameterB = parameterB;
	}
	public BigDecimal getParameterA() {
		return parameterA;
	}
	public void setParameterA(BigDecimal parameterA) {
		this.parameterA = parameterA;
	}
	public BigDecimal getParameterB() {
		return parameterB;
	}
	public void setParameterB(BigDecimal parameterB) {
		this.parameterB = parameterB;
	}
	@Override
	public String toString() {
		return "PerfDTO [id=" + id + ", parameterA=" + parameterA + ", parameterB=" + parameterB + "]";
	}
	
	
	

}
