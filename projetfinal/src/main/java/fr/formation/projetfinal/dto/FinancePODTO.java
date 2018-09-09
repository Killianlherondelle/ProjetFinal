package fr.formation.projetfinal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import fr.formation.projetfinal.entities.Firm;

public class FinancePODTO {
	
	private Long id;
	private String code;
	private Firm firm;
	private BigDecimal perfPlus;
	private LocalDate dateRecording;
	
	
	
	
	public FinancePODTO() {

	}
	
	public FinancePODTO(Long id, String code, Firm firm, BigDecimal perfPlus, LocalDate dateRecording) {
		
		this.id = id;
		this.code = code;
		this.perfPlus = perfPlus;
		this.firm = firm;
		this.dateRecording = dateRecording;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPerfplus() {
		return perfPlus;
	}
	public void setPerfplus(BigDecimal perfPlus) {
		this.perfPlus = perfPlus;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	
	public LocalDate getDateRecording() {
		return dateRecording;
	}

	public void setDateRecording(LocalDate dateRecording) {
		this.dateRecording = dateRecording;
	}

	@Override
	public String toString() {
		return "FinancePODTO [id=" + id + ", code=" + code + ", firm=" + firm + ", perfPlus=" + perfPlus
				+ ", dateRecording=" + dateRecording + "]";
	}

	

	
	
	

	
	
	

}
