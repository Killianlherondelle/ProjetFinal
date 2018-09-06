package fr.formation.projetfinal.dto;

import fr.formation.projetfinal.entities.User.Role;

public class UserDTO {

	private long id;
	private String lastName;
	private String email;
	private Role role;
	// firm // TODO

	public UserDTO() {
		// Empty constructor.
	}

	public UserDTO(long id, String lastName, String email, Role role) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}
}
