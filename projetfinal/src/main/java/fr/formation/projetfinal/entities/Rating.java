package fr.formation.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 450895841225949055L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{error.commons.required}")
	@Column(length = 1, nullable = false)
	private String code;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 10, nullable = false)
	private Double valueRating;

	public Rating() {
	
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

	public Double getValueRating() {
		return valueRating;
	}

	public void setValueRating(Double valueRating) {
		this.valueRating = valueRating;
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
		Rating other = (Rating) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", code=" + code + ", valueRating=" + valueRating + "]";
	}
	
	

}
