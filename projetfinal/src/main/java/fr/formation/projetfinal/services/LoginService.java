package fr.formation.projetfinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.Principal;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.repositories.IUserJpaRepository;

@Service
public class LoginService implements ILoginService {

	private final IUserJpaRepository userJpaRepository;

	@Autowired
	protected LoginService(IUserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userJpaRepository.findByEmail(username);
		Principal principal;

		if (null == user) {
			throw new UsernameNotFoundException("L'username " + username + " n'est pas reconnu");
		} else {
			principal = new Principal(user);
		}
		return principal;

	}

}