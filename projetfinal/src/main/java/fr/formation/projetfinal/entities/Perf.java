package fr.formation.projetfinal.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Perf implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2380270804968010077L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 100, nullable = false, precision = 19, scale = 3)
	@DecimalMin(value="0.01")
	@DecimalMax(value="1")
	private BigDecimal parameterA;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 100, nullable = false, precision = 19, scale = 3)
	@DecimalMin(value="0.001")
	@DecimalMax(value="0.025")
	private BigDecimal parameterB;

	public Perf() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Perf [id=" + id + ", parameterA=" + parameterA + ", parameterB=" + parameterB + "]";
	}
	
	

}
