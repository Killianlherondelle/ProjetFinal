package fr.formation.projetfinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.dto.UserDTO;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.entities.User.Role;
import fr.formation.projetfinal.repositories.IFirmJpaRepository;
import fr.formation.projetfinal.repositories.IUserJpaRepository;
import fr.formation.projetfinal.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

	private final IUserJpaRepository userJpaRepository;
	private final IUserRepository userRepository;
//	private final IFirmJpaRepository fpaReirmJpository;
	private final IFirmService firmService;

	@Autowired
	protected UserService(IUserJpaRepository userJpaRepository, IUserRepository userRepository, IFirmService firmService) {
		this.userJpaRepository = userJpaRepository;
		this.userRepository = userRepository;
		this.firmService = firmService;
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
	public User save(UserCustomerDTO userCustomerDTO) {

		String lastName = userCustomerDTO.getLastName();
		String firstName = userCustomerDTO.getFirstName();
		String email = userCustomerDTO.getEmail();
		String password = userCustomerDTO.getPassword();
		Long firmId = userCustomerDTO.getFirmId();// TODO

		User user = new User();
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setEmail(email);
		user.setPassWord(password);
		user.setRole(Role.ROLE_CUSTOMER);
		Firm firm = firmService.findById(firmId);
		
		List<Firm> firms = new ArrayList<Firm>();
		firms.add(firm);
		user.setFirms(firms);

		encodePassword(user);
		return userJpaRepository.save(user);
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
