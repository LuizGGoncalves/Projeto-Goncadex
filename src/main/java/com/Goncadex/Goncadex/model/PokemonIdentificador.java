package com.Goncadex.Goncadex.model;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemonIdentificador")
public class PokemonIdentificador {
    @NotNull
    private int pokemonid;
    @Id
    private String pokemonNome;

    public int getPokemonid() {
        return pokemonid;
    }

    public void setPokemonid(int pokemonid) {
        this.pokemonid = pokemonid;
    }

    public String getPokemonNome() {
        return pokemonNome;
    }

    public void setPokemonNome(String pokemonNome) {
        this.pokemonNome = pokemonNome;
    }
}
