package fr.formation.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Atlantic
 *
 */
@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4624449348068920239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{error.commons.required}")
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@NotNull(message = "{error.commons.required}")
	@Column(length = 20, nullable = false)
	private String passWord;

	@NotNull(message = "{error.commons.required}")
	@Column(length = 20, nullable = false)
	private String lastName;

	@NotNull(message = "{error.commons.required}")
	@Column(length = 20, nullable = false)
	private String firstName;

	public User() {
		// Empty constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", passWord=" + passWord + ", lastName=" + lastName + ", firstName="
				+ firstName + "]";
	}

	public static enum Role {
		ROLE_PO, ROLE_CUSTOMER, ROLE_BANKER, ROLE_ADMIN;

		public String getName() {
			return name();
		}
	}
}
