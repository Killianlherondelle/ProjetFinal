package fr.formation.projetfinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.repositories.IUserJpaRepository;

@Service
public class UserService implements IUserService {

	private final IUserJpaRepository userJpaRepository;

	@Autowired
	protected UserService(IUserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public void save(User user) {
		encodePassword(user);
		userJpaRepository.save(user);
	}

	private static void encodePassword(User user) {
		String rawPassword = user.getPassWord();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		user.setPassWord(encodedPassword);
	}

	@Override
	public boolean validateEmail(User user) {
		Long id = user.getId();
		String email = user.getEmail();
		if (null == id) { // create
			return !userJpaRepository.existsByEmailIgnoreCase(email);
		}
		return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id); // update
	}

	@Override
	public User findById(Long id) {
		Optional<User> optional = userJpaRepository.findById(id);
		return optional.get();
	}

}
