package com.Goncadex.Goncadex.service.serviceImplements;

import com.Goncadex.Goncadex.model.PokemonIdentificador;
import com.Goncadex.Goncadex.repository.PokemonIdentificadorRepository;
import com.Goncadex.Goncadex.service.PokemonIdentificadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonIdentificadorServiceImplements implements PokemonIdentificadorService {
    @Autowired
    PokemonIdentificadorRepository pokemonIdentificadorRepository;
    @Override
    public PokemonIdentificador save(PokemonIdentificador pokemonIdentificador) {
        return pokemonIdentificadorRepository.save(pokemonIdentificador);
    }

    @Override
    public PokemonIdentificador procurarPorNome(String nome) {
        return pokemonIdentificadorRepository.findById(nome).get();
    }
}
