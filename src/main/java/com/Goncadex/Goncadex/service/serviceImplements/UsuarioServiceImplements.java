package com.Goncadex.Goncadex.service.serviceImplements;


import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.repository.UsuarioRepository;
import com.Goncadex.Goncadex.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImplements implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

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
    public String buscarUsuarioLogado(){
        Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
        if(!(autenticado instanceof AnonymousAuthenticationToken)){
            String nome = autenticado.getName();
            return nome;
        }
        else {
            return "PokeGon lembre de fazer seu Login ou Registro";
        }
    }

    @Override
    public Usuario getUsuarioLogado() {
        String user = buscarUsuarioLogado();
        return procurarUsuario(user);
    }
}
