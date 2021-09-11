package com.Goncadex.Goncadex.service;

import com.Goncadex.Goncadex.model.Pokemon;
import com.Goncadex.Goncadex.model.PokemonIdentificador;

public interface PokemonIdentificadorService {
    PokemonIdentificador save(PokemonIdentificador pokemonIdentificador);
    PokemonIdentificador procurarPorNome(String nome);


}
