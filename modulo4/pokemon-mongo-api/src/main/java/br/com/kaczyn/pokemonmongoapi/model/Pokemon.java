package br.com.kaczyn.pokemonmongoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {

    private String id;
    private String name;
    private String number;
    private Integer level;
    private List<String> types;
    private String race;
}
