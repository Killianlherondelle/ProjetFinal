package fr.formation.projetfinal.services;

import org.springframework.stereotype.Service;

import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.repositories.IFinanceJpaRepository;
import fr.formation.projetfinal.repositories.IFinanceRepository;

@Service
public class FinanceService implements IFinanceService {

	private IFinanceJpaRepository financeJpaRepository;
	private final IFinanceRepository financeRepository;
	
	public FinanceService(IFinanceJpaRepository financeJpaRepository, IFinanceRepository financeRepository) {
		this.financeJpaRepository = financeJpaRepository;
		this.financeRepository = financeRepository;
	}

	@Override
	public Finances save(Finances finance) {
		return financeJpaRepository.save(finance);
	}
	
	@Override
	public boolean validateCode(Finances finance) {
		Long id = finance.getId();
		String code = finance.getCode();
		if (null == id) { // create
		    return !financeJpaRepository.existsByCodeIgnoreCase(code);
		}
		return !financeJpaRepository.existsByCodeIgnoreCaseAndIdNot(code, id);
	}

}
