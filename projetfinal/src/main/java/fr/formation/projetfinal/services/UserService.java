package fr.formation.projetfinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.dto.UserDTO;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.repositories.IUserJpaRepository;
import fr.formation.projetfinal.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

	private final IUserJpaRepository userJpaRepository;
	private final IUserRepository userRepository;

	@Autowired
	protected UserService(IUserJpaRepository userJpaRepository, IUserRepository userRepository) {
		this.userJpaRepository = userJpaRepository;
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		encodePassword(user);
		return userJpaRepository.save(user);
	}
	
	/*
	 * TODO
	 */
	@Override
	public void save(UserCustomerDTO userCustomerDTO) {
		User user = new User();
		// set get

		encodePassword(user);
		// userJpaRepository.save(user);
	}

	private static void encodePassword(User user) {
		String rawPassword = user.getPassWord();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		user.setPassWord(encodedPassword);
	}

	@Override
	public boolean validateEmail(UserCustomerDTO user) {
		Long id = user.getId();
		String email = user.getEmail();
		if (null == id) { // create
			return !userJpaRepository.existsByEmailIgnoreCase(email);
		}
		return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id); // update
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

	@Override
	public List<UserDTO> findAllAsDTO(AppLanguage lang) {
		return userRepository.findAllAsDTO(lang);
	}

}
