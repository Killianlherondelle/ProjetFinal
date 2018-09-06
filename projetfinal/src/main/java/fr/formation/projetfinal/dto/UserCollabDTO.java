package fr.formation.projetfinal.dto;

import javax.validation.constraints.NotNull;

import fr.formation.projetfinal.entities.User.Role;

public class UserCollabDTO {
	private Long collabId;
//	@NotNull(message = "{error.commons.required}")
//	private String firstName;
//	@NotNull(message = "{error.commons.required}")
//	private String lastName;
//	@NotNull(message = "{error.commons.required}")
	private String email;
	@NotNull(message = "{error.commons.required}")
	private String password;
	private Role role;

	public UserCollabDTO() {
		//
	}

	public Long getCollabId() {
		return collabId;
	}

	public void setCollabId(Long collabId) {
		this.collabId = collabId;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserCollabDTO [collabId=" + collabId + ", password=" + password + ", role=" + role
				+ "]";
	}
}
