package fr.formation.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Collaborator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6469963931887043704L;
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 10, nullable = false)
    private String register;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false)
    private String lastname;
 
    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false)
    private String firstname;
    
    @NotNull(message = "{error.commons.required}")
    @Column(length = 1, nullable = false, unique = true)
    private String email;

	public Collaborator() {
		//
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((register == null) ? 0 : register.hashCode());
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
		Collaborator other = (Collaborator) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (register == null) {
			if (other.register != null)
				return false;
		} else if (!register.equals(other.register))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Collaborator [id=" + id + ", register=" + register + ", lastname=" + lastname + ", firstname="
				+ firstname + ", email=" + email + "]";
	}   
}
