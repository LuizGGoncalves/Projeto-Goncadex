package com.Goncadex.Goncadex.controller;

import com.Goncadex.Goncadex.model.PokemonCapturado;
import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.repository.PokemonCapturadoRepository;
import com.Goncadex.Goncadex.service.PokemonService;
import com.Goncadex.Goncadex.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.thymeleaf.util.ListUtils.size;

@Controller
public class CentroPokemonController {
    @Autowired
    private UsuarioService usuarioService;
    private PokemonCapturadoRepository pokemonCapturadoRepository;
    private PokemonService pokemonService;

    @GetMapping("/CentroPokemon")
    public ModelAndView CentroPokemon() {
        String user = usuarioService.buscarUsuarioLogado();
        Usuario usuario = usuarioService.procurarUsuario(user);
        ModelAndView mv = new ModelAndView("CentroPokemon");
        mv.addObject("usuario",usuario);
        return mv;
    }

}
