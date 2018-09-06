package fr.formation.projetfinal.services;

import fr.formation.projetfinal.entities.Finances;

public interface IFinanceService {

	public void save(Finances finance);
	
    public boolean validateCode(Finances finance);
    
    public boolean validateFinanceType(Finances finance);

}
