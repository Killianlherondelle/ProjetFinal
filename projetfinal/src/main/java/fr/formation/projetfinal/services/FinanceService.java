package fr.formation.projetfinal.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.FinancePODTO;
import fr.formation.projetfinal.dto.ValueDTO;
import fr.formation.projetfinal.entities.Country;
import fr.formation.projetfinal.entities.Finances;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.Perf;
import fr.formation.projetfinal.entities.Rating;
import fr.formation.projetfinal.repositories.IFinanceJpaRepository;
import fr.formation.projetfinal.repositories.IFinanceRepository;

@Service
public class FinanceService implements IFinanceService {

	private final IFinanceJpaRepository financeJpaRepository;

	private final IPerfService perfService;

	private final IFirmService firmService;
	
	private final IFinanceRepository financeRepository;

	@Autowired
	public FinanceService(IFinanceJpaRepository financeJpaRepository, 
			IPerfService perfService,  IFirmService firmService, IFinanceRepository financeRepository) {
		this.financeJpaRepository = financeJpaRepository;
		this.financeRepository = financeRepository;
		this.perfService = perfService;

		this.firmService = firmService;

	}

	@Override
	public Finances save(Finances finance) {
		Long firmId = finance.getFirm().getId();
		Firm firm = firmService.findById(firmId);
		Perf perf = perfService.findById(1L);
		BigDecimal perfPlus = calculatePerfPlus(finance, perf, firm);
		finance.setPerfPlus(perfPlus);
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
	public BigDecimal calculatePerfPlus(Finances finance, Perf perf, Firm firm) {
		BigDecimal mf = finance.getAmount();
		BigDecimal df = BigDecimal.valueOf(finance.getMonthDuration());
		BigDecimal mfdf = divide(mf, df);

		// BigDecimal z = firm.getRating().getValueRating();

		BigDecimal mfcrc = multiply(mf, firm.getRating().getValueRating());

		BigDecimal crp = firm.getCountry().getRating().getValueRating();
		BigDecimal crpmf = multiply(crp, mf);

		BigDecimal a = perf.getParameterA();
		BigDecimal b = perf.getParameterB();
		BigDecimal ba = divide(b, a);

		BigDecimal mfba = multiply(mf, ba);

		BigDecimal result = madd(mfdf, mfcrc, crpmf, mfba);
		BigDecimal constante = BigDecimal.valueOf(1000);
		BigDecimal resultPerf = result.divide(constante);
		return resultPerf;
	}

	private static BigDecimal madd(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
		return a.add(b).add(c).add(d);
	}

	private static BigDecimal divide(BigDecimal a, BigDecimal b) {
		BigDecimal c = a.divide(b, RoundingMode.HALF_UP);
		return c;
	}

	private static BigDecimal multiply(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

	@Override
	public List<FinancePODTO> findAllForPOAsDTO(AppLanguage appLanguage) {
		return financeRepository.findAllForPOAsDTO(appLanguage);
	}
	public List<FinancePODTO> findAllForBankerAsDTO(Long userId) {
		return financeRepository.findAllForBankerAsDTO(userId);
	}

}
