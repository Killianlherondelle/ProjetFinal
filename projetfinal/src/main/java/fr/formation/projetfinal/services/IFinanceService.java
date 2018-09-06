package fr.formation.projetfinal.services;

import fr.formation.projetfinal.entities.Finances;

public interface IFinanceService {

	public Finances save(Finances finance);
	
    public boolean validateCode(Finances finance);
    


}
