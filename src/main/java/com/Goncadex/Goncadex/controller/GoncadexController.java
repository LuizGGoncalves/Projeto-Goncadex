package com.Goncadex.Goncadex.controller;

import com.Goncadex.Goncadex.model.Pokemon;
import com.Goncadex.Goncadex.model.PokemonIdentificador;
import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.service.GoncadexService;
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
    private GoncadexService goncadexService;

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("test");
        goncadexService.cadastrarUsuario( "Luiz","123");
        Usuario usuario = goncadexService.procurarUsuario("Luiz");
        goncadexService.capturarpokemon("marquinhos",usuario);
        return mv;
    }

    @GetMapping("/goncadex")
    public ModelAndView buscaPokemon(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView("pokemons");
        PokemonIdentificador pokemonIdentificador = new PokemonIdentificador();
        int idinteiro = Integer.parseInt(id);
        if (idinteiro > 898) {
            idinteiro = idinteiro - 898;
            String idstring = Integer.toString(idinteiro);
            Pokemon pokemon = goncadexService.procurarPokemon(idstring);
            pokemon.setIdpagina(idinteiro);
            //            Salvando as informaçoes no banco de dados
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            goncadexService.save(pokemonIdentificador);
            //            Continuaçao Normal
            mv.addObject("pokemon", pokemon);
            return mv;
        } else if (idinteiro < 1) {
            idinteiro = idinteiro + 898;
            String idstring = Integer.toString(idinteiro);
            Pokemon pokemon = goncadexService.procurarPokemon(idstring);
            pokemon.setIdpagina(idinteiro);
            //            Salvando as informaçoes no banco de dados
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            goncadexService.save(pokemonIdentificador);
            //            Continuaçao Normal
            mv.addObject("pokemon", pokemon);
            return mv;
        } else {
            String idString = Integer.toString(idinteiro);
            Pokemon pokemon = goncadexService.procurarPokemon(idString);
            pokemon.setIdpagina(idinteiro);
            //            Salvando as informaçoes no banco de dados
            pokemonIdentificador.setPokemonid(pokemon.getId());
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            goncadexService.save(pokemonIdentificador);
            //            Continuaçao Normal
            mv.addObject("pokemon", pokemon);
            return mv;
        }
    }

    @PostMapping("/goncadex")
    public String pesquisaPokemon(String nome) {
        System.out.println(nome);
        PokemonIdentificador pesquisa = goncadexService.procurarPorNome(nome);
        String redireciona = "redirect:/goncadex?id=";
        String pagina = Integer.toString(pesquisa.getPokemonid());
        return redireciona + pagina;

    }
    @GetMapping("/refresh")
    public String refresh() {
        for(int i= 1; i < 898; i++  ){
            String contadorString = Integer.toString(i);
            Pokemon pokemon = goncadexService.procurarPokemon(contadorString);
            PokemonIdentificador pokemonIdentificador = new PokemonIdentificador();
            pokemonIdentificador.setPokemonNome(pokemon.getName());
            pokemonIdentificador.setPokemonid(pokemon.getId());
            goncadexService.save(pokemonIdentificador);
        }
        return "redirect:/pokemon?id=1";

    }


}
