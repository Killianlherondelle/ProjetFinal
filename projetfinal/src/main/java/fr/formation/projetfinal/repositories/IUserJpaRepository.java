package fr.formation.projetfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projetfinal.entities.User;

public interface IUserJpaRepository extends JpaRepository<User, Long> {
	
	
	public boolean existsByEmailIgnoreCase(String email);

	public boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);
	
	public  User findByEmail (String username);

}
