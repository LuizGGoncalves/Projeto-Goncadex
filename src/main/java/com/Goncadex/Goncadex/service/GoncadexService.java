package com.Goncadex.Goncadex.service;

import com.Goncadex.Goncadex.model.Pokemon;
import com.Goncadex.Goncadex.model.PokemonCapturado;
import com.Goncadex.Goncadex.model.PokemonIdentificador;
import com.Goncadex.Goncadex.model.Usuario;

public interface GoncadexService {
    Pokemon procurarPokemon(String id);
    PokemonIdentificador save(PokemonIdentificador pokemonIdentificador);
    PokemonIdentificador procurarPorNome(String nome);
    void cadastrarUsuario(String nome, String senha);
    Usuario procurarUsuario(String nome);
    PokemonCapturado capturarpokemon(String nome, Usuario usuario);
}
