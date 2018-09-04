package fr.formation.projetfinal;

import java.util.*;

public enum AppLanguage {
	FR(Locale.FRENCH, "dd/MM/yyyy"), EN(Locale.ENGLISH, "MM/dd/yyyy");

	public static final String CODE = "lang";

	private static final Map<Locale, AppLanguage> LOCALES;
	static {
		LOCALES = new HashMap<>();
		LOCALES.put(Locale.FRENCH, AppLanguage.FR);
		LOCALES.put(Locale.ENGLISH, AppLanguage.EN);
	}

	private final Locale locale;

	private final String datePattern;

	private AppLanguage(Locale locale, String datePattern) {
		this.locale = locale;
		this.datePattern = datePattern;
	}

	public static AppLanguage valueOfLocale(Locale locale) {
		AppLanguage result = LOCALES.get(locale);
		return null == result ? getDefault() : result;
	}

	public static AppLanguage getDefault() {
		return FR;
	}

	public Locale getLocale() {
		return locale;
	}

	public boolean isFrench() {
		return FR.equals(this);
	}

	public boolean isEnglish() {
		return EN.equals(this);
	}

	public String getDatePattern() {
		return datePattern;
	}
}
