package fr.formation.projetfinal.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Country;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.Perf;
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
	

	@Override
	public BigDecimal calculatePerfPlus(Finances finance, Country rateC , Firm rateF, Perf rateP) {
		BigDecimal mf = finance.getAmount();
		BigDecimal df = BigDecimal.valueOf(finance.getMonthDuration());
		BigDecimal mfdf = divide(mf, df);
		
		BigDecimal crc = new BigDecimal(0.5);
		BigDecimal mfcrc = multiply(mf, crc);
		
		BigDecimal crp = new BigDecimal(0.5);
		BigDecimal crpmf = multiply(crp, mf);
		
		
		BigDecimal a = new BigDecimal(0.5);
		BigDecimal b = new BigDecimal(0.5);
		BigDecimal ba = divide(b, a);
		BigDecimal mfba = multiply(mf, ba);
		
		BigDecimal result = madd(mfdf, mfcrc, crpmf, mfba);
		BigDecimal constante = BigDecimal.valueOf(1000);
		BigDecimal resultPerf = result.divide(constante);
		return resultPerf ;	
	}
	
	
	private static BigDecimal madd(BigDecimal a, BigDecimal b,BigDecimal c,BigDecimal d) {
		return a.add(b).add(c).add(d);
	}
	
	
	private static BigDecimal divide(BigDecimal a, BigDecimal b) {
		BigDecimal c = a.divide(b, RoundingMode.HALF_UP);
		return c;
	}
	private static BigDecimal multiply(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}
	

}
