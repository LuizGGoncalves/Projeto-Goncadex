package com.Goncadex.Goncadex.service;

import com.Goncadex.Goncadex.model.PokemonCapturado;
import com.Goncadex.Goncadex.model.Usuario;

public interface PokemonCapturadoService {
    PokemonCapturado capturarpokemon(String nome, Usuario usuario);
}
