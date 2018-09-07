package fr.formation.projetfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.repositories.IFinanceJpaRepository;
import fr.formation.projetfinal.repositories.IFinanceRepository;

@Service
public class FinanceService implements IFinanceService {

	private final IFinanceJpaRepository financeJpaRepository;
	private final IFinanceRepository financeRepository;
	
	@Autowired
	public FinanceService(IFinanceJpaRepository financeJpaRepository, IFinanceRepository financeRepository) {
		this.financeJpaRepository = financeJpaRepository;
		this.financeRepository = financeRepository;
	}

	@Override
	public Finances save(Finances finance) {
		System.out.println("----------------------------------------Save couche service");
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

	@Override
	public List<ValueDTO> findAllAsDTO(AppLanguage appLanguage) {

		return null;
	}

}
