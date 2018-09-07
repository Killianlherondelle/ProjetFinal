package fr.formation.projetfinal.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import fr.formation.projetfinal.entities.User.Role;



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
    @Column(length = 100, nullable = false)
	private String code;
    
    @NotNull(message = "{error.commons.required}")
	@Positive(message = "{error.commons.positive}")
    @JoinColumn(nullable = false)
	private BigDecimal amount;
    
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
	private Currency currency;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
	private int monthDuration;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 1000, nullable = false)
	private LocalDate startDate;
    
	@ManyToOne
    @JoinColumn(nullable = false)
	private FinancesType financeType;
    
	private BigDecimal perfPlus;
	
	@Convert(converter = BooleanConverter.class)
	@Column(length = 1, nullable = false)
	public boolean state = true;
	


	public BigDecimal getPerfPlus() {
		return perfPlus;
	}



	public void setPerfPlus(BigDecimal perfPlus) {
		this.perfPlus = perfPlus;
	}



	public boolean isState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}

	@Column(length = 100, nullable = false)
	private LocalDate dateRecording;
    
    public Finances() {
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

	public FinancesType getFinanceType() {
		return financeType;
	}

	public void setFinanceType(FinancesType type) {
		this.financeType = type;
	}

	public LocalDate getDateRecording() {
		return dateRecording;
	}

	public void setDateRecording(LocalDate dateRecording) {
		this.dateRecording = dateRecording;
	}

	
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Finances other = (Finances) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Finances [id=" + id + ", code=" + code + ", amount=" + amount + ", currency=" + currency
				+ ", monthDuration=" + monthDuration + ", startDate=" + startDate + ", financeType=" + financeType
				+ ", dateRecording=" + dateRecording + "]";
	}
	
    
    

}
