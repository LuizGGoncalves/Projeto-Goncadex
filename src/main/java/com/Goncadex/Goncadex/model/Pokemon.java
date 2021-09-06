package com.Goncadex.Goncadex.model;

import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSprites sprites) {
        this.sprites = sprites;
    }

    public List<NamedAPIResource> getForms() {
        return forms;
    }

    public void setForms(List<NamedAPIResource> forms) {
        this.forms = forms;
    }

    public List<PokemonAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokemonAbility> abilities) {
        this.abilities = abilities;
    }

    public List<PokemonStat> getStats() {
        return stats;
    }

    public void setStats(List<PokemonStat> stats) {
        this.stats = stats;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    public int getIdpaginaproxima() {
        return idpaginaproxima;
    }

    public void setIdpaginaproxima(int idpaginaproxima) {
        this.idpaginaproxima = idpaginaproxima;
    }

    public int getIdpaginaanterior() {
        return idpaginaanterior;
    }

    public void setIdpaginaanterior(int idpaginaanterior) {
        this.idpaginaanterior = idpaginaanterior;
    }

    public int getIdpagina() {
        return idpagina;
    }

    public void setIdpagina(int idpagina) {
        this.idpagina = idpagina;
    }
}
