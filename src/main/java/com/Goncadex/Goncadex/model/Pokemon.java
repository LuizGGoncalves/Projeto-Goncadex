package com.Goncadex.Goncadex.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Pokemon {
    private int id;
    private String name;
    private float height;
    private float weight;
    private String location_area_encounters;
    private PokemonSprites sprites;
    private List<NamedAPIResource> forms;
    private List<PokemonAbility> abilities;
    private List<PokemonStat> stats;
    private List<PokemonType> types;
    private int idpaginaproxima;
    private int idpaginaanterior;
    private int idpagina;

}
