package fr.formation.projetfinal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinancesForCustomerDTO {
	private Long id;
	private String code;
	private BigDecimal amount;
	private BigDecimal perfPlus;
	private LocalDate dateRecording;
	private Long firm_id;

	public FinancesForCustomerDTO() {
		// empty constructor.
	}

	public FinancesForCustomerDTO(Long id, String code, BigDecimal amount, BigDecimal perfPlus, Long firm_id, LocalDate dateRecording) {
		this.id = id;
		this.code = code;
		this.amount = amount;
		this.perfPlus = perfPlus;
		this.firm_id = firm_id;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getPerfPlus() {
		return perfPlus;
	}

	public void setPerfPlus(BigDecimal perfPlus) {
		this.perfPlus = perfPlus;
	}

	public Long getFirm_id() {
		return firm_id;
	}

	public void setFirm_id(Long firm_id) {
		this.firm_id = firm_id;
	}
	
	public LocalDate getDateRecording() {
		return dateRecording;
	}

	public void setDateRecording(LocalDate dateRecording) {
		this.dateRecording = dateRecording;
	}

	@Override
	public String toString() {
		return "FinancesForCustomerDTO [id=" + id + ", code=" + code + ", amount=" + amount + ", perfPlus=" + perfPlus
				+ ", firm_id=" + firm_id + "]";
	}
}
