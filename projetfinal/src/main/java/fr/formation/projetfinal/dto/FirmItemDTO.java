package fr.formation.projetfinal.dto;

public class FirmItemDTO {
	
private Long id;

	private String name;

	public FirmItemDTO() {
		//
	}
	
	
	public FirmItemDTO(Long id, String name) {
		setId(id);
		setName(name);
	    }
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
