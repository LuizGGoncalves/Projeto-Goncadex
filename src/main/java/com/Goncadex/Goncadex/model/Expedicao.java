package com.Goncadex.Goncadex.model;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="expedicao")
public class Expedicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String user;
    @NotNull
    private String pokemonid;
    @NotNull
    private String pokemon;
    @NotNull
    private boolean finalizado;

}
