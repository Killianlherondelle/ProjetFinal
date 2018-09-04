package fr.formation.projetfinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import fr.formation.projetfinal.services.ILoginService;

/**
 * La classe de configuration de Spring Security.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ILoginService loginService;

    @Autowired
    protected SecurityConfig(ILoginService loginService) {
	this.loginService = loginService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	CharacterEncodingFilter filter = new CharacterEncodingFilter();
	filter.setEncoding("UTF-8");
	filter.setForceEncoding(true);
	http.addFilterBefore(filter, CsrfFilter.class);
	http.authorizeRequests()
		.antMatchers("/security/login", "/users/toCreate",
			"/users/create", "/static/**")
		.permitAll().anyRequest().authenticated().and().formLogin()
		.loginPage("/security/login").loginProcessingUrl("/login")
		.defaultSuccessUrl("/users/toCreate", true)
		.failureUrl("/security/login?error=true").permitAll().and()
		.logout().invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/security/login?logout=true").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
	auth.userDetailsService(loginService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }
}
