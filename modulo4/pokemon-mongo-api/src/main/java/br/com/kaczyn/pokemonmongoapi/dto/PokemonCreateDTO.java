package br.com.kaczyn.pokemonmongoapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PokemonCreateDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String number;

    @NotNull
    private Integer level;

    @NotEmpty
    private List<String> types;

    @NotEmpty
    @Size(max = 100)
    private String race;
}
