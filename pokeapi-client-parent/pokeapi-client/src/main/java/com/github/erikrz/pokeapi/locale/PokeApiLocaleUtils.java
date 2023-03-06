package com.github.erikrz.pokeapi.locale;

import java.util.Optional;

import com.github.erikrz.pokeapi.dto.Name;


public class PokeApiLocaleUtils {

	public static Optional<Name> getInLocale(Localizable localizable, String locale) {
		return localizable.getNames().stream()
				.filter(name -> name.getLanguage().getName().equalsIgnoreCase(locale))
				.findFirst();
	}
	
}
