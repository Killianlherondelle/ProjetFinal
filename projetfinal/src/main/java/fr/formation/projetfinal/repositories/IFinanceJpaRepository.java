package fr.formation.projetfinal.repositories;
import org.springframework.data.jpa.repository.JpaRepository;


import fr.formation.projetfinal.entities.Finances;


public interface IFinanceJpaRepository extends JpaRepository<Finances, Long> {

	public boolean existsByCodeIgnoreCase(String code);

	public boolean existsByCodeIgnoreCaseAndIdNot(String code, Long id);

}
