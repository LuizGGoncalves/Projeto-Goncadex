package com.Goncadex.Goncadex.service.serviceImplements;

import com.Goncadex.Goncadex.model.*;
import com.Goncadex.Goncadex.repository.ExpedicaoRepository;
import com.Goncadex.Goncadex.repository.PokemonCapturadoRepository;
import com.Goncadex.Goncadex.service.ExpedicaoService;
import com.Goncadex.Goncadex.service.PokemonService;
import com.Goncadex.Goncadex.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExpedicaoServiceImplements implements ExpedicaoService {
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ExpedicaoRepository expedicaoRepository;
    @Autowired
    private PokemonCapturadoRepository pokemonCapturadoRepository;

    @Override
    public Boolean verificarExpedicao() {
        Usuario usuarioLogado = usuarioService.getUsuarioLogado();
        Expedicao expedicao = expedicaoRepository.findByUser(usuarioLogado.getUsuario());
        if(expedicao == null){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public Expedicao criarExpedicao(String idpokemon) {
        Pokemon pokemonAlvo = pokemonService.procurarPokemon(idpokemon);
        Usuario usuarioLogado = usuarioService.getUsuarioLogado();
        Expedicao novaExpedicao = new Expedicao();
        novaExpedicao.setUser(usuarioLogado.getUsuario());
        novaExpedicao.setPokemon(pokemonAlvo.getName());
        novaExpedicao.setPokemonid(Integer.toString(pokemonAlvo.getId()));
        novaExpedicao.setFinalizado(false);
        return expedicaoRepository.save(novaExpedicao);


    }

    @Override
    public Expedicao retomarExpedicao() {
        Usuario usuarioLogado = usuarioService.getUsuarioLogado();
        Expedicao expedicao = expedicaoRepository.findByUser(usuarioLogado.getUsuario());
        return expedicao;
    }

    @Override
    public Pokemon expedicao() {
        Boolean situacao = verificarExpedicao();
        if(!situacao) {
            Random random = new Random();
            String numeroPokemon = Integer.toString(random.nextInt(100));
            criarExpedicao(numeroPokemon);
            Pokemon pokemon = pokemonService.procurarPokemon(numeroPokemon);
            return pokemon;
        }else{
            Expedicao expedicao = retomarExpedicao();
            Pokemon pokemon = pokemonService.procurarPokemon(expedicao.getPokemonid());
            return pokemon;
        }
    }

    @Override
    public void matarpokemon() {
        Boolean situacao = verificarExpedicao();
        if(situacao){
            Usuario usuarioLogado = usuarioService.getUsuarioLogado();
            Expedicao expedicao = expedicaoRepository.findByUser(usuarioLogado.getUsuario());
            expedicaoRepository.delete(expedicao);
        }

    }

    @Override
    public void capturar(String nome) {
        Boolean situacao = verificarExpedicao();
        if(situacao){
            Usuario usuarioLogado = usuarioService.getUsuarioLogado();
            Expedicao expedicao = expedicaoRepository.findByUser(usuarioLogado.getUsuario());
            Pokemon pokemon = pokemonService.procurarPokemon(expedicao.getPokemonid());
            PokemonCapturado pokemonCapturado = new PokemonCapturado();
            pokemonCapturado.setId(pokemon.getId());
            pokemonCapturado.setDono(usuarioLogado.getId());
            pokemonCapturado.setName(pokemon.getName());
            pokemonCapturado.setNomePokemonCapturado(nome);
            pokemonCapturado.setHeight(pokemon.getHeight());
            pokemonCapturado.setWeight(pokemon.getWeight());


            pokemonCapturado.setAtaque(pokemon.getHeight()*2+pokemon.getWeight()*3);
            pokemonCapturado.setDefesa(pokemon.getHeight()+ pokemon.getWeight());
            pokemonCapturado.setVelocidade(pokemon.getWeight()/(pokemon.getHeight()*pokemon.getHeight()));
            pokemonCapturado.setVidaMaxima(pokemon.getHeight()*pokemon.getWeight());
            pokemonCapturado.setVidaCombate(pokemonCapturado.getVidaMaxima());
            PokemonSprites pokemonSprites = pokemon.getSprites();


            pokemonCapturado.setSprite(pokemonSprites.getFront_default());
            pokemonCapturadoRepository.save(pokemonCapturado);
            expedicaoRepository.delete(expedicao);
        }
    }
}
