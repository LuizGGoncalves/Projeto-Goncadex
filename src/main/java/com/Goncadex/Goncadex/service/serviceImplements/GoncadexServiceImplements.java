package com.Goncadex.Goncadex.service.serviceImplements;

import com.Goncadex.Goncadex.model.Pokemon;
import com.Goncadex.Goncadex.model.PokemonCapturado;
import com.Goncadex.Goncadex.model.PokemonIdentificador;
import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.repository.PokemonCapturadoRepository;
import com.Goncadex.Goncadex.repository.PokemonIdentificadorRepository;
import com.Goncadex.Goncadex.repository.UsuarioRepository;
import com.Goncadex.Goncadex.service.GoncadexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoncadexServiceImplements implements GoncadexService {
    @Autowired
    PokemonIdentificadorRepository pokemonIdentificadorRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PokemonCapturadoRepository pokemonCapturadoRepository;

    @Override
    public PokemonIdentificador save(PokemonIdentificador pokemonIdentificador) {
        return pokemonIdentificadorRepository.save(pokemonIdentificador);
    }

    @Override
    public PokemonIdentificador procurarPorNome(String nome) {
        return pokemonIdentificadorRepository.findById(nome).get();
    }

    @Override
    public void cadastrarUsuario(String nome, String senha) {
        Usuario novo = new Usuario();
        novo.setUsuario(nome);
        novo.setSenha(senha);
        Usuario validar = usuarioRepository.findBynome(nome);
        if (validar == null) {
            usuarioRepository.save(novo);
        }
        System.out.println("funcionou");

    }

    @Override
    public Usuario procurarUsuario(String nome) {
        Usuario usuario = usuarioRepository.findBynome(nome);
        return usuario;
    }

    @Override
    public PokemonCapturado capturarpokemon(String nome, Usuario usuario) {
        PokemonCapturado novopokemon = new PokemonCapturado();
        novopokemon.setNomePokemonCapturado(nome);
        novopokemon.setDono(usuario.getId());
        return pokemonCapturadoRepository.save(novopokemon);
    }

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
