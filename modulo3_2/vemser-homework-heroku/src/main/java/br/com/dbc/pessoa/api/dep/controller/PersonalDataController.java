package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.DadosPessoaisDTO;
import br.com.dbc.pessoa.api.dep.service.PersonalDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class PersonalDataController {

    @Autowired
    private PersonalDataService service;

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return service.get();
    }

    @PostMapping
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return service.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                                   @RequestBody DadosPessoaisDTO dto) throws Exception {
        return service.put(cpf, dto);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return service.get(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        service.delete(cpf);
    }
}
