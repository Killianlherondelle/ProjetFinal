package fr.formation.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Firm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4780540428946809291L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 10, nullable = false, unique = true)
	private String code;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 100, nullable = false)
	private String name;
	
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 20, nullable = false, unique = true)
	private String status;
	
	@ManyToOne
    @JoinColumn(nullable = false)
	private Country country;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 20, nullable = false, unique = true)
	private String accountNum;
	
	@ManyToOne
    @JoinColumn(nullable = false)
	private Rating rating;

	public Firm() {
		
	}
	
	public Firm(Long id) {
		setId(id);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNum == null) ? 0 : accountNum.hashCode());
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
		Firm other = (Firm) obj;
		if (accountNum == null) {
			if (other.accountNum != null)
				return false;
		} else if (!accountNum.equals(other.accountNum))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Firm [id=" + id + ", code=" + code + ", name=" + name + ", status=" + status + ", country=" + country
				+ ", accountNum=" + accountNum + "]";
	}
	
	
	
	
	
		

}
