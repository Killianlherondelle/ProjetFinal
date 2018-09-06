package fr.formation.projetfinal.dto;

import javax.validation.constraints.NotNull;

public class UserCustomerDTO {
	private Long id;
	@NotNull(message = "{error.commons.required}")
	private String firstName;
	@NotNull(message = "{error.commons.required}")
	private String lastName;
	@NotNull(message = "{error.commons.required}")
	private String email;
	@NotNull(message = "{error.commons.required}")
	private String password;

	private Long firmId;

	public UserCustomerDTO() {
		//
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getFirmId() {
		return firmId;
	}

	public void setFirmId(Long firmId) {
		this.firmId = firmId;
	}

}
