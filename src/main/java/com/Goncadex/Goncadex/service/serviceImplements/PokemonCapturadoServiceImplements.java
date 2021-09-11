package com.Goncadex.Goncadex.service.serviceImplements;

import com.Goncadex.Goncadex.model.PokemonCapturado;
import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.repository.PokemonCapturadoRepository;
import com.Goncadex.Goncadex.service.PokemonCapturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCapturadoServiceImplements implements PokemonCapturadoService {
    @Autowired
    PokemonCapturadoRepository pokemonCapturadoRepository;
    @Override
    public PokemonCapturado capturarpokemon(String nome, Usuario usuario) {
        PokemonCapturado novopokemon = new PokemonCapturado();
        novopokemon.setNomePokemonCapturado(nome);
        novopokemon.setDono(usuario.getId());
        return pokemonCapturadoRepository.save(novopokemon);
    }
}
