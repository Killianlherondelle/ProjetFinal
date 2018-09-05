package fr.formation.projetfinal.dto;

public class UserDTO {

	private long id;
	private String lastName;
	private String email;
	private String code;
	private String firm;
	
	
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getFirm() {
		return firm;
	}


	public void setFirm(String firm) {
		this.firm = firm;
	}


	public UserDTO(long id, String lastName, String email, String code, String firm) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.code = code;
		this.firm = firm;
	}
	
	
	

}
