package fr.formation.projetfinal.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ILoginService  extends UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username);

}
