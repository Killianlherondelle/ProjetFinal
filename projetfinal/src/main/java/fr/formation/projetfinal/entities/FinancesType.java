package fr.formation.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FinancesType implements Serializable {
	
	
    private static final long serialVersionUID = -3416208634504083069L;

    public static final String SIMPLE_CODE = "A"; //financement simple

    public static final String UNIONISED_CODE = "B"; //financement syndiqué

    public static final String REVOLVING_CODE = "C"; //financement rotatif
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 11, nullable = false, unique = true)
    private String code;
    
    @Column(length = 50, nullable = false, unique = true)
    private String frenchName;

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
	
	public String getFrenchName() {
		return frenchName;
	}

	public void setFrenchName(String frenchName) {
		this.frenchName = frenchName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getSimpleCode() {
		return SIMPLE_CODE;
	}

	public static String getUnionisedCode() {
		return UNIONISED_CODE;
	}

	public static String getRevolvingCode() {
		return REVOLVING_CODE;
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
		FinancesType other = (FinancesType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinancesType [id=" + id + ", code=" + code + ", frenchName=" + frenchName + "]";
	}


}
