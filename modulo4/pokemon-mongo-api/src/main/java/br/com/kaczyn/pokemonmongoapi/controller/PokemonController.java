package br.com.kaczyn.pokemonmongoapi.controller;

import br.com.kaczyn.pokemonmongoapi.dto.PokemonCreateDTO;
import br.com.kaczyn.pokemonmongoapi.dto.PokemonDTO;
import br.com.kaczyn.pokemonmongoapi.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
@AllArgsConstructor
@Validated
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public List<PokemonDTO> findAll() throws Exception {
        return this.pokemonService.findAll();
    }

    @GetMapping("/{id_pokemon}")
    public PokemonDTO findById(@PathVariable("id_pokemon") String id) throws Exception {
        return this.pokemonService.findById(id);
    }

    @GetMapping("/by-type")
    public List<PokemonDTO> findByTypes(@RequestParam String type) throws Exception {
        return this.pokemonService.findByType(type);
    }

    @GetMapping("/type-quantity")
    public String findTypeQuantity(@RequestParam String type) throws Exception {
        return this.pokemonService.quantityByType(type);
    }

    @PostMapping
    public PokemonDTO create(@Valid @RequestBody PokemonCreateDTO createDTO) throws Exception {
        return this.pokemonService.insert(createDTO);
    }

    @PutMapping("/{id_pokemon}")
    public PokemonDTO update(@PathVariable("id_pokemon") String id,
                             @Valid @RequestBody PokemonCreateDTO createDTO) throws Exception {
        return this.pokemonService.update(id, createDTO);
    }

    @DeleteMapping("/{id_pokemon}")
    public void delete(@PathVariable("id_pokemon") String id) throws Exception {
        this.pokemonService.delete(id);
    }
}
