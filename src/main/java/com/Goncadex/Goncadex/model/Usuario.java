package com.Goncadex.Goncadex.model;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    @NotNull
    private String usuario;
    @NotNull
    private String senha;
    @OneToMany(targetEntity = PokemonCapturado.class,cascade = CascadeType.ALL)
    @JoinColumn(name="dono",referencedColumnName = "id")
    private List<PokemonCapturado> pokemonsUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PokemonCapturado> getPokemonsUsuario() {
        return pokemonsUsuario;
    }

    public void setPokemonsUsuario(List<PokemonCapturado> pokemonsUsuario) {
        this.pokemonsUsuario = pokemonsUsuario;
    }

}
