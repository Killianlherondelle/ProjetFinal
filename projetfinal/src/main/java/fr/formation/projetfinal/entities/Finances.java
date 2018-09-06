package fr.formation.projetfinal.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



@Entity
public class Finances  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5669345826081471356L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message = "{error.commons.required}")
	@Positive(message = "{error.commons.positive}")
    @Column(length = 100, nullable = false)
	private String code;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
	private BigDecimal amount;
    
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
	private Currency currency;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
	private int monthDuration;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 1000, nullable = false)
	private LocalDate startDate;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
	private FinancesType type;
    

    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
	private LocalDate dateRecording;
    
    public Finances() {
    }

	public Finances(Long id,
			@NotNull(message = "{error.commons.required}") @Positive(message = "{error.commons.positive}") String code,
			@NotNull(message = "{error.commons.required}") BigDecimal amount,
			@NotNull(message = "{error.commons.required}") Currency currency,
			@NotNull(message = "{error.commons.required}") int monthDuration,
			@NotNull(message = "{error.commons.required}") LocalDate startDate, FinancesType type,
			@NotNull(message = "{error.commons.required}") LocalDate dateRecording) {
		
		this.id = id;
		this.code = code;
		this.amount = amount;
		this.currency = currency;
		this.monthDuration = monthDuration;
		this.startDate = startDate;
		this.type = type;
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getMonthDuration() {
		return monthDuration;
	}

	public void setMonthDuration(int monthDuration) {
		this.monthDuration = monthDuration;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public FinancesType getType() {
		return type;
	}

	public void setType(FinancesType type) {
		this.type = type;
	}

	public LocalDate getDateRecording() {
		return dateRecording;
	}

	public void setDateRecording(LocalDate dateRecording) {
		this.dateRecording = dateRecording;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
    
    

	
    
    

}
