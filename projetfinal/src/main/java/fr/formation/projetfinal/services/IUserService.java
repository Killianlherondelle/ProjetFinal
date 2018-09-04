package fr.formation.projetfinal.services;

import fr.formation.projetfinal.entities.User;

public interface IUserService {

	public void save(User user);

	public boolean validateEmail(User user);

	public User findById(Long id);
}
