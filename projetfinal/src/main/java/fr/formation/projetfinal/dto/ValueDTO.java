package fr.formation.projetfinal.dto;

public class ValueDTO {
	
	private Long id;
	
	private String label;
	
	public ValueDTO() {
		//
	}

	public ValueDTO(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
