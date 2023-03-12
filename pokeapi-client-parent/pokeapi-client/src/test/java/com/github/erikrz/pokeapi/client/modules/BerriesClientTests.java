package com.github.erikrz.pokeapi.client.modules;

import org.junit.jupiter.api.Test;

import com.github.erikrz.pokeapi.client.PokeApiClientFactory;
import com.github.erikrz.pokeapi.dto.NamedApiResource;

import static com.github.erikrz.pokeapi.dto.NamedApiResourceListAssert.assertThat;
import static com.github.erikrz.pokeapi.dto.berry.BerryAssert.assertThat;
import static com.github.erikrz.pokeapi.dto.berryfirmness.BerryFirmnessAssert.assertThat;
import static com.github.erikrz.pokeapi.dto.berryflavor.BerryFlavorAssert.assertThat;


class BerriesClientTests {

    private final BerriesClient berriesClient = (new PokeApiClientFactory()).buildClient(BerriesClient.class);

    @Test
    void getBerries() {
        var berriesList = berriesClient.getBerries(0, 20);
        assertThat(berriesList)
                .hasCount(64);
    }

    @Test
    void getBerry() {
        var cheri = berriesClient.getBerry(1);
        assertThat(cheri)
                .hasName("cheri");
    }

    @Test
    void testGetBerry() {
        var cheri = berriesClient.getBerry("cheri");
        assertThat(cheri)
                .hasId(1);
    }

    @Test
    void getBerryFirmness() {
        var berriesFirmnessList = berriesClient.getBerryFirmness(0, 20);
        assertThat(berriesFirmnessList)
                .hasCount(5);
    }

    @Test
    void testGetBerryFirmness() {
        var verySoftFirmness = berriesClient.getBerryFirmness(1);
        assertThat(verySoftFirmness)
                .hasName("very-soft");
    }

    @Test
    void testGetBerryFirmness1() {
        var verySoftFirmness = berriesClient.getBerryFirmness("very-soft");
        assertThat(verySoftFirmness)
                .hasId(1);
    }

    @Test
    void getBerryFlavors() {
        var berryFlavorsList = berriesClient.getBerryFlavors(0, 20);
        assertThat(berryFlavorsList)
                .hasCount(5)
                .hasResults(
                        NamedApiResource.builder().name("spicy").url("https://pokeapi.co/api/v2/berry-flavor/1/")
                                .build()
                );
    }

    @Test
    void getBerryFlavor() {
        var spicyFlavor = berriesClient.getBerryFlavor(1);
        assertThat(spicyFlavor)
                .hasName("spicy");
    }

    @Test
    void testGetBerryFlavor() {
        var spicyFlavor = berriesClient.getBerryFlavor("spicy");
        assertThat(spicyFlavor)
                .hasId(1);
    }
}