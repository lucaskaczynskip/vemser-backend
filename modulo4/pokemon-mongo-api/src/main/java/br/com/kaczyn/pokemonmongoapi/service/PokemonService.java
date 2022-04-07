package br.com.kaczyn.pokemonmongoapi.service;

import br.com.kaczyn.pokemonmongoapi.dto.PokemonCreateDTO;
import br.com.kaczyn.pokemonmongoapi.dto.PokemonDTO;
import br.com.kaczyn.pokemonmongoapi.exceptions.BusinessRuleException;
import br.com.kaczyn.pokemonmongoapi.model.Pokemon;
import br.com.kaczyn.pokemonmongoapi.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonDTO insert(PokemonCreateDTO createDTO) throws Exception {
        if (createDTO.getTypes().size() > 2) {
            throw new BusinessRuleException("Pokemon must have one or two types.");
        }

        Pokemon model = this.convertCreateDTOToModel(createDTO);
        Pokemon created = this.pokemonRepository.insert(model);

        return this.convertModelToDTO(created);
    }

    public PokemonDTO update(String id, PokemonCreateDTO createDTO) throws Exception {
        if (createDTO.getTypes().size() > 2) {
            throw new BusinessRuleException("Pokemon must have one or two types.");
        }

        Pokemon model = this.convertCreateDTOToModel(createDTO);
        Pokemon updated = this.pokemonRepository.updateById(id, model);

        return this.convertModelToDTO(updated);
    }

    public void delete(String id) throws Exception {
        this.pokemonRepository.deleteById(id);
    }

    public PokemonDTO findById(String id) throws Exception {
        Optional<Pokemon> pokemon = this.pokemonRepository.findById(id);
        if (pokemon.isEmpty()) {
            throw new BusinessRuleException("Pokemon not found.");
        }
        return this.convertModelToDTO(pokemon.get());
    }

    public List<PokemonDTO> findAll() throws Exception {
        return this.pokemonRepository.findAll().stream()
                .map(pokemon -> convertModelToDTO(pokemon))
                .collect(Collectors.toList());
    }

    public List<PokemonDTO> findByType(String type) throws Exception {
        return this.pokemonRepository.findByType(type).stream()
                .map(pokemon -> convertModelToDTO(pokemon))
                .collect(Collectors.toList());
    }

    public String quantityByType(String string) throws Exception {
        Integer number = this.pokemonRepository.typesQuantity(string);
        return "The type " + string + " has " + number + " pokemons.";
    }

    private Pokemon convertCreateDTOToModel(PokemonCreateDTO createDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(createDTO.getName());
        pokemon.setLevel(createDTO.getLevel());
        pokemon.setNumber(createDTO.getNumber());
        pokemon.setRace(createDTO.getRace());
        pokemon.setTypes(createDTO.getTypes());
        return pokemon;
    }

    private PokemonDTO convertModelToDTO(Pokemon pokemon) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setLevel(pokemon.getLevel());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setNumber(pokemon.getNumber());
        pokemonDTO.setRace(pokemon.getRace());
        pokemonDTO.setTypes(pokemon.getTypes());
        pokemonDTO.setId(pokemon.getId());
        return pokemonDTO;
    }
}
