package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.language.Language;

import feign.Param;
import feign.RequestLine;

public interface UtilityClient {

    @RequestLine("GET /language?offset={offset}&limit={offset}")
    NamedApiResourceList<Language> getLanguages(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /language/{id}")
    Language getLanguage(@Param("id") Integer id);

    @RequestLine("GET /language/{name}")
    Language getLanguage(@Param("name") String name);
}
