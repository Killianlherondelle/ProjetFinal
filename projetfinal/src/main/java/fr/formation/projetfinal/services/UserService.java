package fr.formation.projetfinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.projetfinal.AppLanguage;
import fr.formation.projetfinal.dto.UserCollabDTO;
import fr.formation.projetfinal.dto.UserCustomerDTO;
import fr.formation.projetfinal.dto.UserDTO;
import fr.formation.projetfinal.entities.Collaborator;
import fr.formation.projetfinal.entities.Firm;
import fr.formation.projetfinal.entities.User;
import fr.formation.projetfinal.entities.User.Role;
import fr.formation.projetfinal.repositories.IUserJpaRepository;
import fr.formation.projetfinal.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

	private final IUserJpaRepository userJpaRepository;
	private final IUserRepository userRepository;
	// private final IFirmJpaRepository fpaReirmJpository;
	private final IFirmService firmService;
	private final ICollabService collabService;

	@Autowired
	protected UserService(IUserJpaRepository userJpaRepository, IUserRepository userRepository,
			IFirmService firmService, ICollabService collabService) {
		this.userJpaRepository = userJpaRepository;
		this.userRepository = userRepository;
		this.firmService = firmService;
		this.collabService = collabService;
	}

	@Override
	public User save(User user) {
		encodePassword(user);
		return userJpaRepository.save(user);
	}

	@Override
	public User save(UserCustomerDTO userCustomerDTO) {

		String lastName = userCustomerDTO.getLastName();
		String firstName = userCustomerDTO.getFirstName();
		String email = userCustomerDTO.getEmail();
		String password = userCustomerDTO.getPassword();
		Long firmId = userCustomerDTO.getFirmId();

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

	@Override
	public User saveCollab(UserCollabDTO userCollabDTO) {

		Long collabId = userCollabDTO.getCollabId();
		Collaborator collab = collabService.findById(collabId);
		// via references:
		String lastName = collab.getLastname();
		String firstName = collab.getFirstname();
		String email = collab.getEmail();
		List<Firm> firms = collab.getFirms();
		// via JSP:
		Role role = userCollabDTO.getRole();
		String password = userCollabDTO.getPassword();

		User user = new User();
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setEmail(email);
		/*
		 * Il faut créer une nouvelle collection, et non setter directement avec
		 * setFirms(), pour éviter qu'Hibernate fasse un move de l'association entre les
		 * Collaborators_Firms vers l'association Users_Firms, impliquant un delete sur
		 * Collaborators_Firms !
		 */
		List<Firm> userFirms = new ArrayList<>(firms);
		user.setFirms(userFirms);
		user.setRole(role);
		user.setPassWord(password);
		System.out.println(user);

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
	public boolean validateEmail(User user) {
		Long id = user.getId();
		String email = user.getEmail();
		if (null == id) { // create
			return !userJpaRepository.existsByEmailIgnoreCase(email);
		}
		return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id); // update
	}

	@Override
	public boolean validateEmail(UserCustomerDTO userCustomerDTO) {
		Long id = userCustomerDTO.getId();
		String email = userCustomerDTO.getEmail();
		if (null == id) { // create
			return !userJpaRepository.existsByEmailIgnoreCase(email);
		}
		return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id); // update
	}

	@Override
	public boolean validateCollabEmail(UserCollabDTO userCollabDTO) {
		Long id = userCollabDTO.getCollabId();
		String email = userCollabDTO.getEmail();
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
