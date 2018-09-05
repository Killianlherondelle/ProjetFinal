package fr.formation.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709874898567637089L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "{error.commons.required}")
	@Column(length = 3, nullable = false, unique = true)
	private String iso;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIso() {
		return iso;
	}


	public void setIso(String iso) {
		this.iso = iso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
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
		Currency other = (Currency) obj;
		if (iso == null) {
			if (other.iso != null)
				return false;
		} else if (!iso.equals(other.iso))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", iso=" + iso + "]";
	}

	
	
}
