package com.Goncadex.Goncadex.service.serviceImplements;

import com.Goncadex.Goncadex.model.Pokemon;
import com.Goncadex.Goncadex.service.PokemonService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonServiceImplements implements PokemonService {
    @Override
    public Pokemon procurarPokemon(String id) {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        String pokemonurl = "https://pokeapi.co/api/v2/pokemon/" + id + "/";
        Pokemon pokemon = restTemplate.getForObject(pokemonurl, Pokemon.class);
        pokemon.setHeight(pokemon.getHeight() / 10);
        pokemon.setWeight(pokemon.getWeight() / 10);
        return pokemon;
    }
}
