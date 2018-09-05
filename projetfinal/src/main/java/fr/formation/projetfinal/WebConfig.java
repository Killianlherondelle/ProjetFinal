package fr.formation.projetfinal;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.*;
import org.springframework.web.servlet.view.*;

@Configuration
@Import(value = { AppConfig.class, SecurityConfig.class })
@EnableWebMvc
@ComponentScan("fr.formation.projetfinal.controllers")
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Configuration des ressources statiques afin d'�viter les filtres inutiles sur
	 * les requ�tes.
	 * <p>
	 * Classiquement tous les fichiers JS, CSS et images.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/**
	 * Configuration des JSP, chemin et extension.
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jspf/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * Configuration des fichiers properties contenant les messages externalis�s.
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:messages");
		return source;
	}

	/**
	 * Configuration de du param�tre de langue pour l'application.
	 */
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName(AppLanguage.CODE);
		resolver.setDefaultLocale(AppLanguage.getDefault().getLocale());
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName(AppLanguage.CODE);
		registry.addInterceptor(interceptor);
	}

	/**
	 * Configuration des fichiers properties contenant les messages d'erreur de
	 * validation.
	 */
	@Bean
	public ReloadableResourceBundleMessageSource validationMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:errors");
		return messageSource;
	}

	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(validationMessageSource());
		return validator;
	}
}