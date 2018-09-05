package fr.formation.projetfinal;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:*-context.xml")
@ComponentScan(basePackages = { "fr.formation.projetfinal.repositories", "fr.formation.projetfinal.services",
		"fr.formation.projetfinal.components" })
@EnableJpaRepositories("fr.formation.projetfinal.repositories")
@EnableTransactionManagement
public class AppConfig {
	// Empty class
}
