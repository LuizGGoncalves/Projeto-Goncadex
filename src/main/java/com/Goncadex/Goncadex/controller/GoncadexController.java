package com.Goncadex.Goncadex.controller;

import com.Goncadex.Goncadex.model.Pokemon;
import com.Goncadex.Goncadex.model.PokemonIdentificador;
import com.Goncadex.Goncadex.service.PokemonIdentificadorService;
import com.Goncadex.Goncadex.service.PokemonService;
import com.Goncadex.Goncadex.service.serviceImplements.UsuarioServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping()
@Controller
public class GoncadexController {

    @Autowired
    private PokemonIdentificadorService pokemonIdentificadorService;
    @Autowired
    private UsuarioServiceImplements usuarioServiceImplements;
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/goncadex")
    public ModelAndView buscaPokemon(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView("pokemons");
        PokemonIdentificador pokemonIdentificador = new PokemonIdentificador();
        int idinteiro = Integer.parseInt(id);
        if (idinteiro > 898) {
            idinteiro = idinteiro - 898;
            String idstring = Integer.toString(idinteiro);
            Pokemon pokemon = pokemonService.procurarPokemon(idstring);
            pokemon.setIdpagina(idinteiro);
            //            Salvando as informaçoes no banco de dados
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            pokemonIdentificadorService.save(pokemonIdentificador);
            //            Continuaçao Normal
            mv.addObject("pokemon", pokemon);
            return mv;
        } else if (idinteiro < 1) {
            idinteiro = idinteiro + 898;
            String idstring = Integer.toString(idinteiro);
            Pokemon pokemon = pokemonService.procurarPokemon(idstring);
            pokemon.setIdpagina(idinteiro);
            //            Salvando as informaçoes no banco de dados
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            pokemonIdentificadorService.save(pokemonIdentificador);
            //            Continuaçao Normal
            mv.addObject("pokemon", pokemon);
            return mv;
        } else {
            String idString = Integer.toString(idinteiro);
            Pokemon pokemon = pokemonService.procurarPokemon(idString);
            pokemon.setIdpagina(idinteiro);
            //            Salvando as informaçoes no banco de dados
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            pokemonIdentificadorService.save(pokemonIdentificador);
            //            Continuaçao Normal
            mv.addObject("pokemon", pokemon);
            return mv;
        }
    }

    @PostMapping("/goncadex")
    public String pesquisaPokemon(String nome) {
        System.out.println(nome);
        PokemonIdentificador pesquisa = pokemonIdentificadorService.procurarPorNome(nome);
        String redireciona = "redirect:/goncadex?id=";
        String pagina = Integer.toString(pesquisa.getPokemonid());
        return redireciona + pagina;

    }

    @GetMapping("/refresh")
    public String refresh() {
        for(int i= 1; i < 898; i++  ){
            String contadorString = Integer.toString(i);
            Pokemon pokemon = pokemonService.procurarPokemon(contadorString);
            PokemonIdentificador pokemonIdentificador = new PokemonIdentificador();
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificadorService.save(pokemonIdentificador);
        }
        return "redirect:/pokemon?id=1";

    }


}
